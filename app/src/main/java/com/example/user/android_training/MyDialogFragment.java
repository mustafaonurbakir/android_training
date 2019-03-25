package com.example.user.android_training;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MyDialogFragment extends DialogFragment {
    Button closeButton;
    String mParam1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //take parameters
        if (getArguments() != null) {
            mParam1 = getArguments().getString("params");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_dialog, container, false);
        getDialog().setTitle("DialogFragment");

        // Capture button clicks
        closeButton = (Button) rootView.findViewById(R.id.btnClose);
        closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                getDialog().dismiss();
            }
        });

        //set text
        TextView textView = rootView.findViewById(R.id.dialogTextView);
        textView.setText(mParam1);

        return rootView;
    }


}
