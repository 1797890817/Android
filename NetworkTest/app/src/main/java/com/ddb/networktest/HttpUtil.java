package com.ddb.networktest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by deepin on 17-3-10.
 */

public class HttpUtil {


    public static String sendHttpRequest(String address, final HttpCallbackListener listener) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        HttpURLConnection connection = null;
                        try {
                            URL url = new URL(address);
                            connection = (HttpURLConnection) url.openConnection();

                            connection.setRequestMethod("GET");
                            connection.setConnectTimeout(8000);
                            connection.setReadTimeout(8000);
                            connection.setDoInput(true);
                            connection.setDoOutput(true);

                            InputStream in = connection.getInputStream();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                            StringBuilder response = new StringBuilder();
                            String line;
                            while ((line = reader.readLine()) != null) {
                                response.append(line);
                            }
                            //return response.toString();改为使用回调的方式
                            if (listener != null) {
                                //回调ｏｎfinish()方法
                                listener.onFinish(response);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            //return e.getMessage();
                            if (listener != null) {
                                listener.onError(e);
                            }
                        } finally {
                            if (connection != null) {
                                connection.disconnect();
                            }
                        }

                    }
                }
        ).start();
    }

    //外部的调用方式：
    /*HttpUtil.sendHttpRequest(address,new

    HttpCallbackListener() {
        @Override
        public void onFinish (String response){
            //在这里根据返回内容执行具体的逻辑

        }

        @Override
        public void onError (Exception e){
            //在这里对异常情况进行处理
        }
    });*/

    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);

    }

    //调用方式：
    /*HttpUtil.sendOkHttpRequest("http://www.baidu.com",new okhttp3.Callback()

    {
        @Override
        public void onResponse (Call call, Response response) throws IOException {
        //得到服务器返回的具体内容
        String responseData = response.body().string();
    }

        @Override
        public void onFailure (Call call, IOException e){
        //在这里对异常进行处理
    }

    });*/


}
