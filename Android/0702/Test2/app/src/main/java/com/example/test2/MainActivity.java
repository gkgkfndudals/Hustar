package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ConstraintLayout c_Layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml 파일의 구성요소를 인플레이션한다.
        textView = findViewById(R.id.textView);  // xml의 id값을 불러와서 객체화 시킨다.
        Button button = findViewById(R.id.button);

        //textView.setText("안녕하세요");
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView.setText("안녕하세요!!");
                textView.setBackgroundColor(Color.RED);
            }
        });


        c_Layout = findViewById(R.id.cLayout);

        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c_Layout.setBackgroundColor(Color.GREEN);
            }
        });



    }
}