package com.example.administrator.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.helloworld.db.CreateAssetsAndLiabilitiesDb;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowIncomeAndExpenditureActivity extends AppCompatActivity {
    private LinearLayout todayIncomeAndExpenditureLinearLayout,historyIncomeAndExpenditureLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_income_and_expenditure);



        todayIncomeAndExpenditureLinearLayout = (LinearLayout) findViewById(R.id.todayIncomeAndExpenditureLinearLayout);
        historyIncomeAndExpenditureLinearLayout = (LinearLayout) findViewById(R.id.historyIncomeAndExpenditureLinearLayout);
        CreateAssetsAndLiabilitiesDb createDb = new CreateAssetsAndLiabilitiesDb(ShowIncomeAndExpenditureActivity.this);
        SQLiteDatabase db = createDb.getReadableDatabase();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String now=simpleDateFormat.format(date);
        String sql="select money,income_or_expenditure,detail_type,create_time from income_and_expenditure";
        Cursor cursor = db.rawQuery(sql,null);
        Double incomeMoney=0.0;
        Double expenditureMoney=0.0;
        for (int i = 0; i < cursor.getCount(); i++){
            cursor.moveToNext();
            if(cursor.getString(3).equals(now)){
                if(cursor.getString(1).equals("支出")){
                    expenditureMoney=expenditureMoney+Double.parseDouble(cursor.getString(0));
                }else{
                    incomeMoney=incomeMoney+Double.parseDouble(cursor.getString(0));
                }
                String result=cursor.getString(3)+"   "+cursor.getString(1)+"   "+cursor.getString(2)+"   "+cursor.getString(0)+"元";
                TextView textView=new TextView(this);
                textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                textView.setText(result);
                textView.setTextSize(25);
                todayIncomeAndExpenditureLinearLayout.addView(textView);
            }else{
                String result=cursor.getString(3)+"   "+cursor.getString(1)+"   "+cursor.getString(2)+"   "+cursor.getString(0)+"元";
                TextView textView=new TextView(this);
                textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                textView.setText(result);
                textView.setTextSize(25);
                historyIncomeAndExpenditureLinearLayout.addView(textView);
            }



        }
        TextView incomeMoneyTextView=(TextView)findViewById(R.id.incomeMoneyTextView);
        incomeMoneyTextView.setText(""+incomeMoney);
        TextView expenditureMoneyTextView=(TextView)findViewById(R.id.expenditureMoneyTextView);
        expenditureMoneyTextView.setText(""+expenditureMoney);


    }
}
