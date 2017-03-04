package com.ddb.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //如果数据库不存在，创建数据库
        Button createDb = (Button) findViewById(R.id.create_database);
        createDb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LitePal.getDatabase();  //没有数据库，数据库就会自动被创建，对应的ｊａｖａ类对用的表也会被创建！
                    }
                }
        );

        //添加数据
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Book book = new Book();
                        book.setName("Da Qin Di Guo");
                        book.setAuthor("Sun hao hui");
                        book.setPages(1100);
                        book.setPrice(600);
                        book.setPress("Unknow");
                        book.save();    //添加数据，ｓａｖｅ方法继承而来
                    }
                }
        );

        //更新数据
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*//对已经存储的对象进行更新－－－限制性比较大
                        Book book = new Book();
                        book.setName("Ming chao naxie shier");
                        book.setAuthor("Dangnianmingyue");
                        book.setPress("unknow");
                        book.setPages(780);
                        book.setPrice(300);

                        book.save();//表中没有此数据，所以是插入操作
                        book.setPrice(500);
                        book.save();//表中已经存在，执行的是更新操作*/

                        //可以批量更新很多数据
                        Book book = new Book();
                        book.setPrice(45.78);
                        book.setPress("USTC");
                        book.updateAll("name =? and author = ?","Ming chao naxie shier","Dangnianmingyue");
                    }
                }
        );
        //删除数据
        Button deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DataSupport.deleteAll(Book.class,"price < ?","50");
                    }
                }
        );

        //查询数据
        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<Book> books = DataSupport.findAll(Book.class);
                        for (Book book:books){
                            Log.d("MainActivity", "book name is : " + book.getName());
                            Log.d("MainActivity", "book author is : " + book.getAuthor());
                            Log.d("MainActivity", "book pages is : " + book.getPages());
                            Log.d("MainActivity", "book price is : " + book.getPrice());
                            Log.d("MainActivity", "book press is : " + book.getPress());
                        }

                    }
                }
        );
    }
}
