package com.example.administrator.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.helloworld.db.CreateAssetsAndLiabilitiesDb;

public class ShowAssetsAndLiabilitiesActivity extends AppCompatActivity {
    private LinearLayout assetsDetail,liabilitiesDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_assets_and_liabilities);

        //资产详情
        Double assetsMoney=0.0;
        assetsDetail = (LinearLayout) findViewById(R.id.assetsDetail);
        CreateAssetsAndLiabilitiesDb createDb = new CreateAssetsAndLiabilitiesDb(ShowAssetsAndLiabilitiesActivity.this);
        SQLiteDatabase db = createDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("select name,money from assets_and_liabilities where type='资产'",null);
        for (int i = 0; i < cursor.getCount(); i++){
            cursor.moveToNext();
            assetsMoney=assetsMoney+Double.parseDouble(cursor.getString(1));
            String result=cursor.getString(0)+":"+cursor.getString(1)+"元";
            TextView textView=new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            textView.setText(result);
            textView.setTextSize(25);
            assetsDetail.addView(textView);
        }
        TextView assets=(TextView)findViewById(R.id.assets);
        assets.setText(""+assetsMoney);

        //负债详情
        Double liabilitiesMoney=0.0;
        liabilitiesDetail = (LinearLayout) findViewById(R.id.liabilitiesDetail);
        cursor = db.rawQuery("select name,money from assets_and_liabilities where type='负债'",null);
        for (int i = 0; i < cursor.getCount(); i++){
            cursor.moveToNext();
            liabilitiesMoney=liabilitiesMoney+Double.parseDouble(cursor.getString(1));
            String result=cursor.getString(0)+":"+cursor.getString(1)+"元";
            TextView textView=new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            textView.setText(result);
            textView.setTextSize(25);
            liabilitiesDetail.addView(textView);
        }
        TextView liabilities=(TextView)findViewById(R.id.liabilities);
        liabilities.setText(""+liabilitiesMoney);
        //所有者权益
        Double ownersEquityMoney=assetsMoney-liabilitiesMoney;
        TextView ownersEquity=(TextView)findViewById(R.id.ownersEquity);
        ownersEquity.setText(""+ownersEquityMoney);
    }
}
