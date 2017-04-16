package com.ddb.servicebestpractice;

/**
 * Created by deepin on 17-3-16.
 */

public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();


}
