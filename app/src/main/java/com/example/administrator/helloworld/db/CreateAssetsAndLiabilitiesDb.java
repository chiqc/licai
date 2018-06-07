package com.example.administrator.helloworld.db;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Administrator on 2018/6/3.
 */
public class CreateAssetsAndLiabilitiesDb  extends SQLiteOpenHelper {
    private final static String DB_NAME = "data.db"; //库名 == 文件名
    private final static int VERSION = 1; //版本号

    public CreateAssetsAndLiabilitiesDb(Context context) {
        super(context, DB_NAME, null, VERSION);
    }
    //用来创建数据库的
    //如果没有特殊情况 库只创建一次
    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i("message","onCreate()");
        boolean bol = false;
        db.execSQL("create table assets_and_liabilities (id integer primary key autoincrement, type varchar(10),name varchar(25),money real)");
        bol = true;
        Log.i("message","onCreate()"+bol);

    }

    //更新数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("message","onUpgrade()");
    }
}
