package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

import maes.tech.intentanim.CustomIntent;

public class appBar extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar);
        getReference();
        showAppBar();
        showFragment();
    }

    void getReference() {

        t1 = (TextView)findViewById(R.id.fragmentTextView0);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
    }
    void showAppBar(){
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    void showFragment() {

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_modal f1 = new fragment_modal();
                FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
                tx.replace(R.id.fragmentFrame, f1);
                tx.addToBackStack(null);
                tx.commit();

            }
        });
    }
    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(appBar.this, "fadein-to-fadeout");

    }
}
