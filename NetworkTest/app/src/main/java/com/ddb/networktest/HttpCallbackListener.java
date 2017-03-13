package com.ddb.networktest;

/**
 * Created by deepin on 17-3-10.
 */

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}
