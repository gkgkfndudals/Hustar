package com.example.myinflerator1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout container;
    int nBefore= 0;
    Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.sub);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                container.removeAllViews();

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.add1, container, true);

                Button button3 = container.findViewById(R.id.button3);

                final CheckBox checkBox = container.findViewById(R.id.checkBox);
                final CheckBox checkBox2 = container.findViewById(R.id.checkBox2);
                final CheckBox checkBox3 = container.findViewById(R.id.checkBox3);

                button3.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        String msg= "";
                        if (checkBox.isChecked()) {
                            msg += checkBox.getText()+ " ";
                        }
                        if(checkBox2.isChecked()){
                            msg+= checkBox2.getText()+" ";
                        }
                        if(checkBox3.isChecked()){
                            msg+= checkBox3.getText()+" ";
                        }

                        TextView textView4 = container.findViewById(R.id.textView4);
                        textView4.setText(msg + "입니다");
                    }
                });

            }
        });



        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                container.removeAllViews();
                
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.add2, container, true);

                button4 = container.findViewById(R.id.button4);

                final CheckBox checkBox4 = container.findViewById(R.id.checkBox4);
                final CheckBox checkBox5= container.findViewById(R.id.checkBox5);

                button4.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        if(checkBox4.isChecked()){
                            testRotation(nBefore -45);
                        } else if(checkBox5.isChecked()){
                            testRotation(nBefore -90);
                        }
                    }
                });

            }
        });
    }



    public void testRotation(int i) {
        RotateAnimation ra = new RotateAnimation(nBefore, i, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(250);
        ra.setFillAfter(true);
        button4.startAnimation(ra);
        nBefore=i;
    }
}