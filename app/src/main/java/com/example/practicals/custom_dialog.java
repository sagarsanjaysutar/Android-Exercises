package com.example.practicals;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class custom_dialog extends DialogFragment {
    Button b1,b2;
//    ExampleDialogListner listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_custom_dialog, null);
            builder.setView(view);
        getReference(view);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

        return builder.create();
    }





    private void getReference(View view) {
        b1 = view.findViewById(R.id.dialogButtonSubmit);
        b2 = view.findViewById(R.id.dialogButtonClose);
    }



}
