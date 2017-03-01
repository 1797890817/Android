package com.ddb.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context,String title,String content){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",title);
        intent.putExtra("news_content",content);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);


        //获取传入的标题与内容
        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_content");

        //获取活动中引用的碎片

        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        //刷新碎片中显示ｎｅｗｓ信息的组件内容
        newsContentFragment.refresh(newsTitle,newsContent);

    }
}
