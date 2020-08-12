package com.example.myinflerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        linearLayout = findViewById(R.id.container);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //container 레이아웃에 sub.xml을 인플레이션 한다.
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.sub, linearLayout, true);

                CheckBox checkBox = linearLayout.findViewById(R.id.checkBox);
                checkBox.setText("로딩되었어요.");

            }
        });

    }


    //setContentView 는 전체 다 를 띄움
    //getSystemService 는 부분을 띄움

}