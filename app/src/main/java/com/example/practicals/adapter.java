package com.example.practicals;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.adapterViewHolder> {
    private onNoteListener adapterOnNoteListener;
    private  ArrayList<card_items> arrayList;
    public adapter(ArrayList<card_items> card_items, onNoteListener onNoteListener){ //constructor to get data
        arrayList = card_items;
        adapterOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public adapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Wwe define our layout of our card in this method
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_items, parent, false);
        adapterViewHolder adapterViewHolder = new adapterViewHolder(v,adapterOnNoteListener);
        return adapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapterViewHolder holder, int position) {
        card_items current_card_item = arrayList.get(position);
        holder.textView_prac_title.setText(current_card_item.getPrac_title());
        holder.textView_prac_desc.setText(current_card_item.getPrac_desc());

    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public static class adapterViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener //custom view holder
    {
        public TextView textView_prac_title,textView_prac_desc;
        onNoteListener viewHolderListener;
        public adapterViewHolder(@NonNull View itemView, onNoteListener onNoteListener) {
            super(itemView);
            textView_prac_title = itemView.findViewById(R.id.prac_title);
            textView_prac_desc = itemView.findViewById(R.id.prac_desc);
            itemView.setOnClickListener(this); //attact the on clicklistner to the view holder
            viewHolderListener = onNoteListener;
        }

        @Override
        public void onClick(View v) {
            viewHolderListener.onNoteClick(getAdapterPosition());



        }
    }


    /*Interface for onCLick listener which will be used in VIewHolder*/





    public interface onNoteListener{
        void onNoteClick(int pos); //to detect the click and use this method in main activity to send that click to item.
    }





}
