package com.example.user.android_training;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    Button dFragButton;
    Button sendButton;
    FragmentManager fm = getSupportFragmentManager();
    public static final String EXTRA_MESSAGE = "com.example.android_training.MESSAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Capture button clicks
        dFragButton = (Button) findViewById(R.id.dfragbutton);
        dFragButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                sendMessageFragment();
            }
        });

        // Capture button clicks
        sendButton = (Button) findViewById(R.id.btn_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                sendMessageActivity();
            }
        });
    }

    public void sendMessageFragment(){
        //take string
        EditText editText = (EditText) findViewById(R.id.input_info);
        String message = editText.getText().toString();

        //send string as a param
        Bundle bundle = new Bundle();
        bundle.putString("params", message);

        //create DialogFragment
        MyDialogFragment dFragment = new MyDialogFragment();
        dFragment.setArguments(bundle);
        dFragment.show(fm, "Dialog Fragment");
    }

    public void sendMessageActivity() {
        Intent intent = new Intent(this, SecondActivity.class);

        //take string
        EditText editText = (EditText) findViewById(R.id.input_info);
        String message = editText.getText().toString();

        //put string and
        intent.putExtra(EXTRA_MESSAGE, message);

        //start activity
        startActivity(intent);
    }
}
