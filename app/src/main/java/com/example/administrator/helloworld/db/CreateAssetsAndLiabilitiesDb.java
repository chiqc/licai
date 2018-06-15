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
        //创建资产负债表
        db.execSQL("create table assets_and_liabilities (id integer primary key autoincrement, type varchar(10),name varchar(25),money real)");
        //创建收入支出表
        /**
         * income_or_expenditure 代表是收入还是支出
         * assets_or_liabilities_name    属于哪一项资产或者负债
         * money 金额
         * type 类别：衣、食、住、行、其他
         * detail_type 详细类别：早餐、午餐等
         * create_time 创建时间   2018-12-23
         * */
        db.execSQL("create table income_and_expenditure (id integer primary key autoincrement,money real,income_or_expenditure varchar(20),assets_or_liabilities_name varchar(20),type varchar(25),detail_type  varchar(25),create_time  varchar(20))");
        bol = true;
        Log.i("message","onCreate()"+bol);

    }

    //更新数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("message","onUpgrade()");
    }
}
