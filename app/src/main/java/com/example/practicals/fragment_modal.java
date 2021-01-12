package com.example.practicals;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragment_modal extends Fragment {
    private TextView t1;
    View modal_obj;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        modal_obj = inflater.inflate(R.layout.activity_fragment_modal, container, false);
        return modal_obj;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        t1 = (TextView)modal_obj.findViewById(R.id.fragmentTextView1);
    }
}
