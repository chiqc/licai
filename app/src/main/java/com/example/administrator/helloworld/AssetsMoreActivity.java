package com.example.administrator.helloworld;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.administrator.helloworld.db.CreateAssetsAndLiabilitiesDb;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AssetsMoreActivity extends AppCompatActivity {
    private Button submitButton;
    private Spinner assetsSpinner,typeSpinner;
    private EditText detailTypeEditText,moneyEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets_more);

        //查询资产名称，并将数据显示在下拉框中
        CreateAssetsAndLiabilitiesDb createDb = new CreateAssetsAndLiabilitiesDb(AssetsMoreActivity.this);
        SQLiteDatabase db = createDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("select name from assets_and_liabilities where type='资产'",null);
        String[] assetsNameArr=new String[cursor.getCount()];
        for (int i = 0; i < cursor.getCount(); i++){
            cursor.moveToNext();
            assetsNameArr[i]=cursor.getString(0);
        }
        assetsSpinner =(Spinner) findViewById(R.id.assetsSpinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,android.R.id.text1,assetsNameArr);
        assetsSpinner.setAdapter(adapter);

        //提交数据
        submitButton=(Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取资产名称
                assetsSpinner = (Spinner) findViewById(R.id.assetsSpinner);
                String assetsName=assetsSpinner.getSelectedItem().toString();
                //获取收入类别
                typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
                String type=typeSpinner.getSelectedItem().toString();
                //获取详细类别
                detailTypeEditText=(EditText)findViewById(R.id.detailTypeEditText);
                String detailType=detailTypeEditText.getText().toString();
                //获取金额
                moneyEditText=(EditText)findViewById(R.id.moneyEditText);
                String money=moneyEditText.getText().toString();
                //创建时间
                Date date = new Date();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                String now=simpleDateFormat.format(date);
                //数据插入数据库
                CreateAssetsAndLiabilitiesDb createDb = new CreateAssetsAndLiabilitiesDb(AssetsMoreActivity.this);
                SQLiteDatabase db = createDb.getReadableDatabase();
                String sql="insert into income_and_expenditure (money,income_or_expenditure,assets_or_liabilities_name,type,detail_type,create_time) " +
                        "values ('"+money+"','收入','"+assetsName+"','"+type+"','"+detailType+"','"+now+"')";
                db.execSQL(sql);
                //根据资产名称查询资产数额
                sql="select money from assets_and_liabilities where type='资产' and name='"+assetsName+"'";
                Cursor cursor = db.rawQuery(sql,null);
                cursor.moveToNext();
                Double assetsMoney=Double.parseDouble(cursor.getString(0));
                assetsMoney=assetsMoney+Double.parseDouble(money);
                //更新资产数额
                sql="update assets_and_liabilities set money="+assetsMoney+" where type='资产' and name='"+assetsName+"'";
                db.execSQL(sql);
                //跳转到收支展示页面
                Intent intent=new Intent(AssetsMoreActivity.this,ShowIncomeAndExpenditureActivity.class);
                startActivity(intent);
            }
        });







    }
}
