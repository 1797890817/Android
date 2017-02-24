package com.ddb.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //接受第一个活动给的参数值
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra_data");
//        Log.d("SecondActivity", "SecondActivity get data from FirstActivity:"+data);
//        Toast.makeText(SecondActivity.this,"SecondActivity get data from FirstActivity:"+data,Toast.LENGTH_SHORT).show();

        //向上一个活动返回数据
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        genData4Return();
                    }
                }
        );
    }

    //下面的代码让按下Ｂａｃｋ建也可以把数值返回
    @Override
    public void onBackPressed() {
        genData4Return();
    }
    //共同部分抽取出来作为方法以便调用，减少代码冗余
    private void genData4Return() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity,from SecondActivity!");
        setResult(RESULT_OK,intent);
        finish();
    }
}
