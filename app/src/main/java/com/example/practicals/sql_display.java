package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class sql_display extends AppCompatActivity {
    private TextView t1;
    db_helper db_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_display);
        getReference();
        db_helper = new db_helper(this,"test.db", null, 1);
        List<String> data = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        data = db_helper.getValue();
        for (String datax : data) {

            builder.append("- " + datax + "\n");

        }
        t1.setText(builder);
        }

        void getReference () {
            t1 = findViewById(R.id.sql_tv1);
        }

    }
