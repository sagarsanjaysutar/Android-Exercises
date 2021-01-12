package com.example.practicals;

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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Permission;

public class media_telephone extends AppCompatActivity {
    private Button t1, t2;
    private MediaPlayer player;
    boolean play_status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_telephone);
        getReference();
        performAction();
    }

    void getReference() {
        t1 = findViewById(R.id.media);
        t2 = findViewById(R.id.tele);
    }

    void performAction() {
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!play_status) {
                    if (player == null) {
                        t1.setText("Music - Playing");
                        play_status = true;
                        Toast.makeText(getBaseContext(), "Playing music" + play_status, Toast.LENGTH_LONG).show();
                        player = MediaPlayer.create(getBaseContext(), R.raw.detective);
                        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                t1.setText("Play Music");
                                player.release();
                                player = null;
                                play_status = false;
                                Toast.makeText(getBaseContext(), "Music ended", Toast.LENGTH_LONG).show();
                            }
                        });
                        player.start();
                    }
                }
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Calling home.", Toast.LENGTH_LONG).show();
                if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(media_telephone.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
                Intent tele = new Intent(Intent.ACTION_CALL);
                tele.setData(Uri.parse("tel:8856078947"));
                startActivity(tele);
            }
        });

    }

}
