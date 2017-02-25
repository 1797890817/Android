package com.ddb.activitylifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        Log.d(TAG, this.toString());
        Log.d(TAG, "Task id is:"+getTaskId());

        //读取保存的临时数据
        if (savedInstanceState !=null){
            String tmpdata = savedInstanceState.getString("data_key");
            Log.d(TAG, tmpdata);
            Toast.makeText(MainActivity.this,tmpdata,Toast.LENGTH_SHORT);
        }


        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        //startNormalActivity.setOnClickListener(getListener(NormalActivity.class));
        //启动当前活动自己，测试启动standard模式
        //startNormalActivity.setOnClickListener(getListener(MainActivity.class));

        //启动带参数的活动
        startNormalActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NormalActivity.actionStart(MainActivity.this,"pam1","pam2","pam3");
                    }
                }
        );

        //
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        startDialogActivity.setOnClickListener(getListener(DialogActivity.class));

    }

    //重复代码抽取出来复用！
    @NonNull
    private View.OnClickListener getListener(final Class clazz) {
        return new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,clazz);
                startActivity(intent);
            }
        };
    }

    //用来对活动的临时数据进行保存
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        String tmpData = "Something you just typed";
        outState.putString("data_key",tmpData);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

}
