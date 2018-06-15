package com.example.administrator.helloworld;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.helloworld.db.CreateAssetsAndLiabilitiesDb;

public class MainActivity extends AppCompatActivity {
    private Button recordAssetsAndLiabilitiesButton,showAssetsAndLiabilitiesButton;
    private Button recordIncomeAndExpenditureButton,showIncomeAndExpenditureButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateAssetsAndLiabilitiesDb createDb = new CreateAssetsAndLiabilitiesDb(MainActivity.this);
        SQLiteDatabase db = createDb.getReadableDatabase();

        showIncomeAndExpenditureButton=(Button) findViewById(R.id.showIncomeAndExpenditureButton);
        showIncomeAndExpenditureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ShowIncomeAndExpenditureActivity.class);
                startActivity(intent);
            }
        });

        recordIncomeAndExpenditureButton=(Button) findViewById(R.id.recordIncomeAndExpenditureButton);
        recordIncomeAndExpenditureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RecordIncomeAndExpenditureActivity.class);
                startActivity(intent);
            }
        });



        recordAssetsAndLiabilitiesButton=(Button) findViewById(R.id.recordAssetsAndLiabilitiesButton);
        recordAssetsAndLiabilitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RecordAssetsAndLiabilitiesActivity.class);
                startActivity(intent);
            }
        });

        showAssetsAndLiabilitiesButton=(Button) findViewById(R.id.showAssetsAndLiabilitiesButton);
        showAssetsAndLiabilitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ShowAssetsAndLiabilitiesActivity.class);
                startActivity(intent);
            }
        });

    }
}
