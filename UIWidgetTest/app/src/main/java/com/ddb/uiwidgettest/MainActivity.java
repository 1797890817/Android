package com.ddb.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        Button button = (Button) findViewById(R.id.button);
        //使用匿名类的方式，来注册监听器
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                //按钮的单击的逻辑
//
//            }
//        });

        //使用实现接口的方式来注册
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                //在此处添加逻辑
                //String inputText = editText.getText().toString();
                //Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();
                //动态修改显示的图片
                imageView.setImageResource(R.drawable.img_2);
                //改变进度条的显隐状态
//                if (progressBar.getVisibility()==View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else{
//                    progressBar.setVisibility(View.GONE);
//                }

                //动态改变进度条的进度值
//                int progress = progressBar.getProgress();
//                progress = progress + 10;
//                progressBar.setProgress(progress);

                //Alert Dialog
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("This is a dialog");
//                dialog.setMessage("Something important!");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialog,int which){}
//
//                });
//                dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialog,int which){}
//                });
//                dialog.show();

                //Progress Dialog
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();

                break;
            default:
                break;
        }
    }
    //实现接口的方式，当界面有多个按钮时，代码清晰易读，个人喜欢实现接口的方式！
}
