package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.ArrayList;

public class practical_list extends AppCompatActivity implements com.example.practicals.adapter.onNoteListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter; //Bridge between data(ArraYList card_list) and recycler view. Gives only those items which we need
    private RecyclerView.LayoutManager layoutManager; //Aligning work
    private ArrayList<card_items> card_ArrayList = new ArrayList<>();
    int pos,nextPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_list);
        setRecyclerView();
        bindData();




        }

        void bindData(){
            for(int i = 0; i < 26; i=i+2){
                pos = Integer.valueOf(i);
                nextPos = Integer.valueOf(pos) + 1;
                card_ArrayList.add(new card_items(getResources().getStringArray(R.array.all_prac)[pos],getResources().getStringArray(R.array.all_prac)[nextPos]));
            }
        }

        void setRecyclerView(){
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            adapter = new adapter(card_ArrayList,this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

        }

    @Override
    public void onNoteClick(int pos) {
        //intent code
        final Intent intent;
        switch (pos){
            case 0:
                intent =  new Intent(this, hello_world.class);
                break;
            case 1:
                intent =  new Intent(this, resources.class);
                break;
            case 2:
                intent =  new Intent(this, life_cycle.class);
                break;
            case 3:
                intent =  new Intent(this, layouts.class);
                break;
            case 4:
                intent =  new Intent(this, appBar.class);
                break;
            case 5:
                intent =  new Intent(this, menus_dialog.class);
                break;
            case 6:
                intent =  new Intent(this, intent.class);
                break;
            case 7:
                intent =  new Intent(this, service.class);
                break;
            case 8:
                intent =  new Intent(this, sql_lite.class);
                break;
            case 9:
                intent =  new Intent(this, thread.class);
                break;
            case 10:
                intent =  new Intent(this, media_telephone.class);
                break;
            case 11:
                intent =  new Intent(this, security_permission.class);
                break;
            case 12:
                intent =  new Intent(this, volley.class);
                break;


            default:
                intent =  new Intent(this, volley.class);
                break;


        }
        this.startActivity(intent);
    }
}
