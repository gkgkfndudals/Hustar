package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {
    View view;
    View view2;
    TextView textView2;
    GestureDetector detector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.view);
        view2 = findViewById(R.id.view2);
        textView2 = findViewById(R.id.textView2);

        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if(action == MotionEvent.ACTION_DOWN){
                    textView2.append("손가락 눌림:" +curX +", " + curY +"\n");
                    println("손가락 눌림:" +curX +", " + curY);
                } else if(action == MotionEvent.ACTION_MOVE){
                    textView2.append("손가락 움직임:" + curX + "," + curY + "\n");
                    println("손가락 움직임:" + curX + "," + curY);
                } else if(action == MotionEvent.ACTION_UP){
                    textView2.append("손가락 뗌:" + curX + ", " + curY + "\n");
                    println("손가락 뗌:" + curX + ", " + curY);
                }
               return true;
            }
        });

        //////////////////////////////////////////////////////////////////////////////

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                textView2.append("onDown\n" );
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
                textView2.append("\n onScroll \n\t x = " + distanceX + "\n\ty=" + distanceY);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
                println("\n onFling \n\t x = " + distanceX + "\n\ty=" + distanceY);
                return true;
            }
        });

        view2.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            textView2.append("시스템 [back]버튼이 눌렸습니다. \n");
            //System.exit(0);
            finish();
            return true;
        }
        return false;
    }
}