package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.VectorEnabledTintResources;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    TextView textView;
    Button button;
    Button button2;
    Button button3;

    SQLiteDatabase database;

    EditText et_name, et_age, et_id, et_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        textView = findViewById(R.id.textView);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 데이터 베이스 생성
                String name = editText.getText().toString();
                createDatabase(name);
            }
        });

        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 테이블 생성
                String name = editText2.getText().toString();

                createTable(name);
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertRecord();
            }
        });

        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        et_id = findViewById(R.id.et_id);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_phone = findViewById(R.id.et_phone);

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                updateRecode();
            }
        });

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deleteRecode();
            }
        });
    }

    public void createDatabase(String dbName) {
        println("createDatabase call");
        try {
            database = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
        } catch (Exception e) {
            e.printStackTrace();;
        }

        println("데이터베이스 생성함: " + dbName);
    }

    public void insertRecord() {
        println("insert Call");
        String tableName = editText2.getText().toString();

        String name = et_name.getText().toString();
        int age = Integer.parseInt(et_age.getText().toString());
        String phone = et_phone.getText().toString();

        if(database == null) {
            println("데이터베이스를 먼저 생성하시오.");
            return;
        }
        if(tableName == null) {
            println("테이블을 먼저 생성하시오.");
            return;
        }

        String query="insert into " + tableName
                + "(name, age, mobile) "
                + " values "
                +"(" + "'" + name + "'" + ", " + age  + ", " +  "'"+phone + "'"+ ")";

        Log.d("tag", query);
        database.execSQL(query);

        println("레코드 추가");
    }

    public void updateRecode(){
        println("update call");
        String tableName = editText2.getText().toString();

        int _id= Integer.parseInt(et_id.getText().toString());
        String name = et_name.getText().toString();
        int age = Integer.parseInt(et_age.getText().toString());
        String phone = et_phone.getText().toString();


        if(database == null) {
            println("데이터베이스를 먼저 생성하시오.");
            return;
        }
        if(tableName == null) {
            println("테이블을 먼저 생성하시오.");
            return;
        }

        String query="update emp set age=1000 where name="+"'"+name+"'";

        Log.d("tag", query);

        database.execSQL(query);

        println("레코드 수정");
    }

    public void deleteRecode(){
        println("delete call");
        String tableName = editText2.getText().toString();

        int _id= Integer.parseInt(et_id.getText().toString());
        String name = et_name.getText().toString();
        int age = Integer.parseInt(et_age.getText().toString());
        String phone = et_phone.getText().toString();


        if(database == null) {
            println("데이터베이스를 먼저 생성하시오.");
            return;
        }
        if(tableName == null) {
            println("테이블을 먼저 생성하시오.");
            return;
        }

        String query="delete from emp where name="+"'"+name+"'";

        database.execSQL(query);

        Log.d("tag", query);

        println("레코드 삭제");
    }

    public void createTable(String tableName) {
        println("createTable 호출됨.");

        if (database == null) {
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }

        String query ="create table if not exists " + tableName + "("
                + " _id integer PRIMARY KEY autoincrement, "
                + " name text, "
                + " age integer, "
                + " mobile text)";

        database.execSQL(query);

        println("테이블 생성함: " + tableName);
    }

    public void println(String data) {
        textView.append(data+"\n");
    }
}