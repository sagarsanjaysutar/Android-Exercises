package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import maes.tech.intentanim.CustomIntent;

public class resources extends AppCompatActivity {
    private Button t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        getReference();
        changeIntent();
    }

    private void getReference() {
        t1 = findViewById(R.id.resourceTextView2);

    }
    private void changeIntent() {
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent one = new Intent(resources.this, practical_list.class);
                startActivity(one);
                CustomIntent.customType(resources.this, "fadein-to-fadeout");

            }
        });
    }
    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(resources.this, "fadein-to-fadeout");

    }
}
