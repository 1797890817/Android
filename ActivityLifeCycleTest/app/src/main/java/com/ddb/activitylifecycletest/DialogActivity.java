package com.ddb.activitylifecycletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class DialogActivity extends BaseActivity {
    public static final String TAG = "DialogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        Log.d(TAG, "Task id is: " + getTaskId());
        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(BaseActivity.exitListener);
    }
}
