package com.example.practicals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class menus_dialog extends AppCompatActivity {

    private Button t1, t2, t3, t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_dialog);
        getReference();
        show_menu();
        registerForContextMenu(t3);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    void getReference() {
        t1 = findViewById(R.id.menutextView25);
        t2 = findViewById(R.id.menutextView26);
        t3 = findViewById(R.id.menutextView27);
        t4 = findViewById(R.id.dialogtextView24);
    }

    void show_menu() {
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(menus_dialog.this, "Option menu selected.", Toast.LENGTH_SHORT).show();
                openOptionsMenu();
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(menus_dialog.this, "Pop up menu selected.", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),v);
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.show();

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(menus_dialog.this, "Context menu selected.", Toast.LENGTH_SHORT).show();
                openContextMenu(v);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(menus_dialog.this, "Dialog selected.", Toast.LENGTH_SHORT).show();
                DialogFragment fragment = new custom_dialog();
                fragment.show(getSupportFragmentManager(),"dialog");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}

