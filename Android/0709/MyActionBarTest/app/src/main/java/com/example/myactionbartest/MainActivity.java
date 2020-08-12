package com.example.myactionbartest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        View view = menu.findItem(R.id.menu_search).getActionView();
        if(view!=null){
            final EditText editText = view.findViewById(R.id.editText);

            if(editText!=null){
                editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        Toast.makeText(getApplicationContext(), "입력됨"+editText.getText().toString(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.menu_refresh:
                Toast.makeText(this, "새로고침 메뉴 선택", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this, "검색 메뉴가 선택", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(this, "설정 메뉴 선택", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}