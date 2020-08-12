package com.example.mydrawable2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button;
    int idx=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        final ImageView imageView1 = findViewById(R.id.imageView);
        final ImageView imageView3 = findViewById(R.id.imageView3);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                 if(idx == 0){
                     imageView1.setVisibility(View.VISIBLE);
                     imageView3.setVisibility(View.INVISIBLE);
                     idx++;
                 }
                 else {
                     imageView3.setVisibility(View.VISIBLE);
                     imageView1.setVisibility(View.INVISIBLE);
                     idx=0;
                 }

            }
        });


    }
}