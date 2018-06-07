package com.example.administrator.helloworld;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.administrator.helloworld.db.CreateAssetsAndLiabilitiesDb;

public class RecordAssetsAndLiabilitiesActivity extends AppCompatActivity {
    private Button submit;
    private Spinner typeSpinner;
    private EditText nameEditText,moneyEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_assets_and_liabilities);

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //type的值是资产或者是负债
                typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
                String type=typeSpinner.getSelectedItem().toString();
                //获取资产或负债的名称
                nameEditText=(EditText)findViewById(R.id.name);
                String name=nameEditText.getText().toString();
                //获取金额
                moneyEditText=(EditText)findViewById(R.id.money);
                String money=moneyEditText.getText().toString();
                CreateAssetsAndLiabilitiesDb createDb = new CreateAssetsAndLiabilitiesDb(RecordAssetsAndLiabilitiesActivity.this);
                SQLiteDatabase db = createDb.getReadableDatabase();
                db.execSQL("insert into assets_and_liabilities (type,name,money) values ('"+type+"','"+name+"',"+money+")");

                //跳转到资产负债显示页面
                Intent intent=new Intent(RecordAssetsAndLiabilitiesActivity.this,ShowAssetsAndLiabilitiesActivity.class);
                startActivity(intent);
            }
        });

    }
}
