package com.example.myintent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class MenuActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        editText = findViewById(R.id.editText);
        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                int year = Integer.parseInt(s.substring(0, 2));
                int month = Integer.parseInt(s.substring(2, 3));
                int day= Integer.parseInt(s.substring(4,5));

                int age = getAge(year+1900, month, day);

                Intent intent = new Intent();
                intent.putExtra("name", "손영준");
                intent.putExtra("age", age);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    public int getAge(int birthYear, int birthMonth, int birthDay)
    {
        Calendar current = Calendar.getInstance();
        int currentYear  = current.get(Calendar.YEAR);
        int currentMonth = current.get(Calendar.MONTH) + 1;
        int currentDay   = current.get(Calendar.DAY_OF_MONTH);

        int age = currentYear - birthYear;
        // 생일 안 지난 경우 -1
        if (birthMonth * 100 + birthDay > currentMonth * 100 + currentDay)
            age--;

        return age;
    }


}