package com.example.practicals;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class thread extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int counter = 0;
    volatile boolean threadStarted = true;
    private Button btn1, btn2;
    private TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        btn1 = findViewById(R.id.thread_btn1);
        btn2 = findViewById(R.id.thread_btn2);
        t1 = findViewById(R.id.thread_tv1);
        t2 = findViewById(R.id.thread_tv2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThread1(v);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startThread2(v);


            }
        });
    }

    public void startThread1(View view) {
        Threading1 threading = new Threading1();
        new Thread(threading).start();
    }

    public void startThread2(View view) {

        Threading2 threading2 = new Threading2();
        threading2.start();

    }

    void setValue(final TextView t, final String s1) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                t.setText(s1);
            }
        });
    }

    class Threading1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.d("--", "start Thread" + i);
                setValue(t1,"" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Threading2 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.d("--", "start Thread 2 " + i);
                setValue(t2, "" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



