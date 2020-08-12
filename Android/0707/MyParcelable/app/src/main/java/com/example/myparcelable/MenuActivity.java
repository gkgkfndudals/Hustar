package com.example.myparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = findViewById(R.id.textView);

        //1. 메인 액티비티 객체에서 보낸 인텐트 객체를 얻어온다.
        Intent intent = getIntent();

        //2. 얻어온 객체 안에 포함 된 부가 데이터를 텍스트에 출력한다.
        if(intent!=null){
            Bundle bundle = intent.getExtras();
            SimpleData data = (SimpleData) bundle.getParcelable("data");
            textView.setText("전달받은 데이터\n Number: " + data.getNumber() + "\nMessage: " +data.getMessage());
        }



        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}