package com.example.mytest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String msg = editText.getText().toString();
                Toast.makeText(getApplicationContext(), "손영준", Toast.LENGTH_LONG).show();
                //makeText(Context, text, duration) 이므로 Context에 this를 쓸수 없다.
                //button의 onClick이므로
                textView.setText(msg);
            }
        });

        Toast.makeText(this, "손영준", Toast.LENGTH_LONG).show();


    }
}