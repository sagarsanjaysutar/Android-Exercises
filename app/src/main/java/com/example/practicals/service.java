package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class service extends AppCompatActivity {
    private static final String CHANNEL_ID = "" ;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        getReference();
        startServices();
        showNotification();


    }

    void startServices() {
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Success","---startservice called");
                startService(new Intent(service.this,service_class.class));

            }
        });
         t2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Log.d("Success","---stopService called");
                 stopService(new Intent(service.this,service_class.class));

             }
         });
    }
    void showNotification() {
        NotificationCompat.Builder build = new NotificationCompat.Builder(this,"My Notidication").setContentTitle("Practicals").setContentText("This is a custom notification.").setSmallIcon(R.drawable.blur);


        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1,build.build());



    }

    void getReference(){
        t1 = findViewById(R.id.servicetextView24);
        t2 = findViewById(R.id.servicetextView25);
        t3 = findViewById(R.id.servicetextView26);
    }


}
