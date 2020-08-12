package com.example.androidhw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SalesManage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_manage);



        setResult(RESULT_OK);

        Button mainViewChange = findViewById(R.id.s_menu_change_btn);
        Button loginViewChange = findViewById(R.id.s_login_change_btn);

        mainViewChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });

        loginViewChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginView.class);
                startActivityForResult(intent, 201);

                setResult(RESULT_OK);
                finish();
            }
        });
    }
}