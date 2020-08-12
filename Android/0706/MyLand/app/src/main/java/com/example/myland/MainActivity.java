package com.example.myland;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String name;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this , "onCreate 호출됨", Toast.LENGTH_LONG).show();

        editText = findViewById(R.id.editText);
        button= findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name= editText.getText().toString();
                Toast.makeText(getApplicationContext(), "값을 넣었습니다." + name, Toast.LENGTH_LONG).show();
            }
        });

        if(savedInstanceState!=null){
            name= savedInstanceState.getString("name");
            Toast.makeText(this, "name: " + savedInstanceState.getString("name"), Toast.LENGTH_LONG).show();
            //Toast.makeText(this, "name: " + name, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onStart() {  //프로그램 런링상태
        super.onStart();
        Toast.makeText(this, "onStart 호출됨.", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop 호출됨.", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //화면전환이 될 때 정보를 저장
        outState.putString("name", name);
    }
}