package com.example.androidhw02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomManage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_manage);




        Button mainViewChange = findViewById(R.id.c_menu_change_btn);
        Button loginViewChange = findViewById(R.id.c_login_change_btn);


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
                startActivityForResult(intent, 200);


                finish();
            }
        });
    }

}