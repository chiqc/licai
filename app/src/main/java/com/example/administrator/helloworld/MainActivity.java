package com.example.administrator.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button recordAssetsAndLiabilitiesButton,showAssetsAndLiabilitiesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
