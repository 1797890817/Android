package com.ddb.uilayouttest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        //在主活动中启动ｆｉｒｓｔ活动
        button1.setOnClickListener(getListener(FirstActivity.class));

        Button button2 = (Button) findViewById(R.id.button2);
        //启动相对布局的ｌａｙｏｕｔ
        button2.setOnClickListener(getListener(RelativeLayoutActivity.class));

        //启动帧布局ｌａｙｏｕｔ
        Button button3 =(Button) findViewById(R.id.button3);
        button3.setOnClickListener(getListener(FrameLayoutActivity.class));

        //启动百分比布局ｌａｙｏｕｔ
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(getListener(PercentLayoutActivity.class));

    }

    @NonNull
    private View.OnClickListener getListener(final Class nextActivityClazz) {
        return new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this,nextActivityClazz);
                startActivity(intent);
            }

        };
    }
}
