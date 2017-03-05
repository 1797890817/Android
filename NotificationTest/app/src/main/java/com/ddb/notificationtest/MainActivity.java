package com.ddb.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.send_notice:
                Intent intent = new Intent(this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pi)   //设定通知可以单击
                        //.setAutoCancel(true)    //设定单击后自动消失－－－方法一
                        //.setSound(Uri.fromFile(new File("system/media/audio/ringtones/Luna.ogg")))  //播放音频
                        //.setVibrate(new long[]{0,1000,1000,1000})   //设定震动
                        //.setLights(Color.BLUE,1000,1000)    //设定闪灯
                        .setDefaults(NotificationCompat.DEFAULT_ALL)    //使用默认通１知的设定
                        //.setStyle(new NotificationCompat.BigTextStyle().bigText("最新版的红米note3开发版，用Android studio运行自己创建的应用，总是安装不到手机上了？？？以前是可以的？？？"))//设定一大段文字
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.big_image)))
                        .setPriority(NotificationCompat.PRIORITY_MAX)   //最大优先级
                        .build();
                manager.notify(1,notification);
                break;
            default:
                break;
        }
    }

}
