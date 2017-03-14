package com.ddb.androidthreadtest;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by deepin on 17-3-13.
 */

public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {
    @Override
    protected void onPreExecute() {
        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            while (true) {
                int downloadPercent = doDownload();//这是一个虚构的方法
                publishProgress(downloadPercent);
                if (downloadPercent >= 100) {
                    break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //在这里更新下载进度
        progressDialog.setMessage("Download " + values[0] + "%");
    }

    @Override
    protected void onPostExecute(Boolean result) {
        progressDialog.dismiss();//关闭进度对话框
        //在这里提示下载结果
        if (result) {
            Toast.makeText(context, "Download successed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Download failed", Toast.LENGTH_SHORT).show();
        }
    }
git gitｇｉｔ
    //要想启动这个任务：
   /* new DownloadTask().execute();*/


}
