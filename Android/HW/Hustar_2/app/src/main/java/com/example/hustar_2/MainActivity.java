package com.example.hustar_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button left_btn;
    Button right_btn;
    ImageView imageView;
    int nBefore =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left_btn= findViewById(R.id.leftbtn);
        right_btn = findViewById(R.id.rightbtn);
        imageView = findViewById(R.id.imageView);

        left_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                testRotation(nBefore -10);
            }
        });

        right_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                testRotation(nBefore+10);
            }
        });
    }

    public void testRotation(int i) {
        RotateAnimation ra = new RotateAnimation(nBefore, i, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(250);
        ra.setFillAfter(true);
        imageView.startAnimation(ra);
        nBefore=i;
    }
}