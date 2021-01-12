package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import maes.tech.intentanim.CustomIntent;

public class layouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);
    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(layouts.this, "fadein-to-fadeout");

    }
}
