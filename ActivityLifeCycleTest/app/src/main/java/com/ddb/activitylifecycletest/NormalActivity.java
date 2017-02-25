package com.ddb.activitylifecycletest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NormalActivity extends BaseActivity {
    public static final String TAG = "NormalActivity";

    //接收启动本活动需要的可变参数
    public static void actionStart(Context context, String... params) {
        Intent intent = new Intent(context, NormalActivity.class);
        if (params.length >= 1) {
            Log.d(TAG, "Params length: " + params.length);
            for (int i = 0; i < params.length; i++) {
                intent.putExtra("param" + (i + 1), params[i]);
                Log.d(TAG, "param" + (i + 1) + ":" + params[i]);
            }
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_layout);
        Log.d("NormalActivity", this.toString());
        Log.d(TAG, "Task id is: " + getTaskId());
        //返回主活动，测试启动模式
        Button button2 = (Button) findViewById(R.id.button_2);
        //button2.setOnClickListener(getListener(MainActivity.class));
        //启动ｄｉａｌｏｇ活动,测试ｓｉｎｇｌｅＩｎｓｔａｎｃｅ
        button2.setOnClickListener(getListener(DialogActivity.class));

    }

    //重复代码抽取出来复用！
    private View.OnClickListener getListener(final Class clazz) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NormalActivity.this, clazz);
                startActivity(intent);
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}
