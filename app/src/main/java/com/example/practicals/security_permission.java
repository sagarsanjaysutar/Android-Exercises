package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.drm.DrmStore;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Permission;

public class security_permission extends AppCompatActivity {
    private Button t1, t2, t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_permission);
        getReference();
        performAction();
    }

    void getReference() {
        t1 = findViewById(R.id.securitytextView24);
        t2 = findViewById(R.id.securitytextView25);
        t3 = findViewById(R.id.securitytextView26);
    }

    void performAction() {
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Telephone permission.", Toast.LENGTH_LONG).show();
                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(security_permission.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Contact permission.", Toast.LENGTH_LONG).show();
                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(security_permission.this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
                }
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Message permission.", Toast.LENGTH_LONG).show();
                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(security_permission.this, new String[]{Manifest.permission.READ_SMS}, 1);
                }
            }
        });
    }
}
