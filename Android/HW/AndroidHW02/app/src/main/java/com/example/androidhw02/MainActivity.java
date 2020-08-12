package com.example.androidhw02;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button customManageView_btn = findViewById(R.id.CustomManageView_btn);
        Button salesManageView_btn = findViewById(R.id.salesManageView_btn);
        Button goodsManageView_btn = findViewById(R.id.goodsManageView_btn);

        Intent receivedIntent = getIntent();
        String id = receivedIntent.getStringExtra("id");

        Toast.makeText(getBaseContext(), id, Toast.LENGTH_LONG).show();

        customManageView_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomManage.class);
                startActivityForResult(intent, 100);
            }
        });

        salesManageView_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SalesManage.class);
                startActivityForResult(intent, 101);
            }
        });

        goodsManageView_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoodsManage.class);
                startActivityForResult(intent, 102);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100){
            if(resultCode==RESULT_OK){
                Toast.makeText(this, "고객 관리에서 메뉴으로", Toast.LENGTH_LONG).show();
            }
        }else if(requestCode==101){
            if(resultCode==RESULT_OK){
                Toast.makeText(this, "매출 관리에서 메뉴으로", Toast.LENGTH_LONG).show();
            }
        }else if(requestCode==102){
            if(resultCode==RESULT_OK){
                Toast.makeText(this, "상품 관리에서 메뉴으로", Toast.LENGTH_LONG).show();
            }
        }

    }




}

