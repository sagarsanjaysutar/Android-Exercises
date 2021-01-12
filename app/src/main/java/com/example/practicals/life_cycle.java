package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class life_cycle extends AppCompatActivity {
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("----", "onCreate() called");
        Toast.makeText(this,"onCreate() called", Toast.LENGTH_SHORT).show();
        getReference();
        t1.setText("onCreate() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("----", "onStart() called");
        Toast.makeText(this,"onStart() called", Toast.LENGTH_SHORT).show();
        t2.setText("onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("----", "onResume() called");
        Toast.makeText(this,"onResume() called", Toast.LENGTH_SHORT).show();
        t3.setText("onResume() called");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("----", "onPause() called");
        Toast.makeText(this,"onPause() called", Toast.LENGTH_SHORT).show();
        t4.setText("onPause() called");
        t1.setText("-");
        t2.setText("-");
        t3.setText("-");
        t4.setText("-");
        t5.setText("-");
        t6.setText("-");


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("----", "onRestart() called");
        Toast.makeText(this,"onRestart() called", Toast.LENGTH_SHORT).show();
        t5.setText("onRestart() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("----", "onDestroy() called");
        Toast.makeText(this,"onDestroy() called", Toast.LENGTH_SHORT).show();
        t6.setText("onDestroy() called");
    }


    void getReference(){
        t1 = findViewById(R.id.lifeCycle_t1);
        t2 = findViewById(R.id.lifeCycle_t2);
        t3 = findViewById(R.id.lifeCycle_t3);
        t4 = findViewById(R.id.lifeCycle_t4);
        t5 = findViewById(R.id.lifeCycle_t5);
        t6 = findViewById(R.id.lifeCycle_t6);
    }

}
