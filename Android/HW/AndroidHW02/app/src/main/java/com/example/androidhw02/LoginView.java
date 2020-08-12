package com.example.androidhw02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

public class LoginView extends AppCompatActivity {

    EditText login_et_id, login_et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        login_et_id = findViewById(R.id.login_et_id);
        login_et_pwd = findViewById(R.id.login_et_pwd);

        Button login_btn = findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                intent.putExtra("id", login_et_id.getText().toString());
                intent.putExtra("pass", login_et_pwd.getText().toString());

                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

                setResult(RESULT_OK, intent);

                startActivity(intent);

            }
        });
    }


}


