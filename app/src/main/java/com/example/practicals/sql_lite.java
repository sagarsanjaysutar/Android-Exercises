package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sql_lite extends AppCompatActivity {
    private TextView t1;
    private EditText e1;
    private Button b1;
    db_helper db_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite);
        getReference();

        db_helper = new db_helper(this,"test.db", null, 1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sql_lite.this, sql_display.class);
                String data = e1.getText().toString();
                db_helper.setValue(3,data);
                startActivity(intent);
            }
        });


    }
    void getReference(){

        t1 = findViewById(R.id.sql_tv1);
        e1 = findViewById(R.id.sq_ev);
        b1 = findViewById(R.id.sql_btn);


    }
}
