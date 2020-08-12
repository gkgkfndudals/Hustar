package com.example.myintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //인텐트 액티비티 간에 데이터를 담아두고 이동하기 위해서 사용
    //bundle이랑 비슷하다
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //메뉴 액티비티를 띄운다.
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, 101);

                ///////////////

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
            Toast.makeText(getApplicationContext(), "onActivityResult 메소드 호출됨. 요청 코드: " + requestCode +
                    ", 결과코드: " + resultCode, Toast.LENGTH_LONG).show();

            if(resultCode == RESULT_OK){
                String name = data.getExtras().getString("name");
                Toast.makeText(getApplicationContext(), "응답으로 전달된 name : " +name, Toast.LENGTH_LONG).show();
            }
        }
    }
}