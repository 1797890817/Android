package com.ddb.activitylifecycletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by deepin on 17-2-25.
 * 使用此类的目的是为了知道当前的活动的名称是什么
 */

public class BaseActivity extends AppCompatActivity {
    //提供ｅｘｉｔＬｉｓｔｅｎｅｒ监听器，用于退出程序，减少代码冗余
    public static View.OnClickListener exitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActivityCollector.finishAll();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
