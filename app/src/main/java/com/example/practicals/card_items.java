package com.example.practicals;

import android.widget.TextView;

public class card_items {
    private String prac_title, prac_desc;

    public card_items(String prac_title,String prac_desc){
        this.prac_title = prac_title;
        this.prac_desc = prac_desc;

    }
    public String getPrac_title(){
        return prac_title;
    }

    public String getPrac_desc() {
        return prac_desc;
    }
}
