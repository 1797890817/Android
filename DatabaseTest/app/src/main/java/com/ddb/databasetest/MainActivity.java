package com.ddb.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,1);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);//大于１表示升级
        Button createDb = (Button) findViewById(R.id.create_database);

        createDb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dbHelper.getWritableDatabase();
                    }
                }
        );

        //添加数据
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        /*ContentValues values = new ContentValues();
                        //开始组装第一条数据
                        values.put("name","The Da Vinci Code");
                        values.put("author","Dan Brown");
                        values.put("pages",454);
                        values.put("price",16.96);
                        db.insert("Book",null,values);//插入第一条数据
                        values.clear();

                        //开始组装第二条数据
                        values.put("name","The Lost Symbol");
                        values.put("author","Dan Brown");
                        values.put("pages",510);
                        values.put("price",16.95);
                        db.insert("Book",null,values);//插入第二条数据*/

                        //直接使用ＳＱＬ添加数据
                        db.execSQL("insert into Book (name,author,pages,price) values (?,?,?,?)", new String[]{"Da Qin", "Sun hao hui", "11000", "500" });
                        db.execSQL("insert into Book (name,author,pages,price) values (?,?,?,?)", new String[]{"Da Ming", "DangnianMingyue", "1000", "600" });

                    }
                }
        );

        //修改数据
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        /*ContentValues values = new ContentValues();
                        values.put("price", 10.99);
                        db.update("Book", values, "name=?", new String[]{"The Da Vinci Code" });//更新数据
*/
                        //直接使用ＳＱＬ语句
                        db.execSQL("update Book set price = ? where name = ?",new String[]{"600","Da Qin"});
                    }
                }
        );

        //删除数据
        Button deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        //db.delete("Book", "pages > ?", new String[]{"500" });//删除数据

                        //使用ＳＱＬ
                        db.execSQL("delete from Book where pages > ?",new String[]{"500"});
                    }
                }
        );

        //查询数据
        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        //查询ＢｏｏＫ表中所有的数据
                       // Cursor cursor = db.query("Book", null, null, null, null, null, null);
                        //直接使用ＳＱＬ
                        Cursor cursor = db.rawQuery("select * from Book",null);

                        if (cursor.moveToFirst()) {
                            do {
                                //遍历ｃｕｒｓｏｒ对象，取出数据并打印
                                String name = cursor.getString(cursor.getColumnIndex("name"));
                                String author = cursor.getString(cursor.getColumnIndex("author"));
                                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                                Log.d("MainActivity", "Book name is: " + name);
                                Log.d("MainActivity", "Book author is: " + author);
                                Log.d("MainActivity", "Book pages is: " + pages);
                                Log.d("MainActivity", "Book price is: " + price);
                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    }
                }
        );

    }
}
