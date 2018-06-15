package com.example.administrator.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecordIncomeAndExpenditureActivity extends AppCompatActivity {
    private Button AssetsLessButton,LiabilitiesMoreButton,AssetsMoreButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_income_and_expenditure);

        AssetsLessButton=(Button) findViewById(R.id.AssetsLessButton);
        AssetsLessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecordIncomeAndExpenditureActivity.this,AssetsLessActivity.class);
                startActivity(intent);
            }
        });
        LiabilitiesMoreButton=(Button) findViewById(R.id.LiabilitiesMoreButton);
        LiabilitiesMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecordIncomeAndExpenditureActivity.this,LiabilitiesMoreActivity.class);
                startActivity(intent);
            }
        });
        AssetsMoreButton=(Button) findViewById(R.id.AssetsMoreButton);
        AssetsMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecordIncomeAndExpenditureActivity.this,AssetsMoreActivity.class);
                startActivity(intent);
            }
        });


    }
}
