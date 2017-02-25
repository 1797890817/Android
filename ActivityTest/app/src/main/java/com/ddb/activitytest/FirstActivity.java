package com.ddb.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity{

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(FirstActivity.this, "You click Button1!", Toast.LENGTH_SHORT).show();
                        //finish();//用代码销毁活动

                        //使用显示Ｉｎｔｅｎｔ来启动第二个活动
//                        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                        startActivity(intent);

                        //使用隐式ｉｎｔｅｎｔ来启动第二个活动
                        //Intent intent = new Intent("com.ddb.activitytest.ACTION_START");
                        //startActivity(intent);

                        //添加额外的ｃａｔｅｇｏｒｙ让程序崩溃
                        //intent.addCategory("com.ddb.activitytest.MY_CATEGORY");
                        //startActivity(intent);

                        //打开baidu网页内容在当前的应用程序中
//                        Intent intent = new Intent(Intent.ACTION_VIEW);
//                        intent.setData(Uri.parse("http://www.baidu.com"));
//                        startActivity(intent);

                        //打开拨号的界面
//                        Intent intent = new Intent(Intent.ACTION_DIAL);
//                        intent.setData(Uri.parse("tel:10086"));
//                        startActivity(intent);

                        //向下一个活动传递数据
//                        String data = "Hello SecondActivity!";
//                        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                        intent.putExtra("extra_data",data);
//                        startActivity(intent);

                        //从下一个活动接收数据
                        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                        startActivityForResult(intent,1);


                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You click Add!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You click Remove!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    //重写方法用来接受后面活动返回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnData);
                    Toast.makeText(FirstActivity.this,"Return data:" + returnData,Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }


}
