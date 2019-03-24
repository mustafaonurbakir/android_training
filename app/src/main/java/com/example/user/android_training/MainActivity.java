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

public class MainActivity extends FragmentActivity {
    Button dFragButton;
    Button sendButton;
    FragmentManager fm = getSupportFragmentManager();
    public static final String EXTRA_MESSAGE = "com.example.android_training.MESSAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_main);

        // Locate the button in activity_main.xml
        dFragButton = (Button) findViewById(R.id.dfragbutton);

        // Capture button clicks
        dFragButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                MyDialogFragment dFragment = new MyDialogFragment();
                // Show DialogFragment
                dFragment.show(fm, "Dialog Fragment");
            }
        });

        // Locate the button in activity_main.xml
        sendButton = (Button) findViewById(R.id.btn_send);

        // Capture button clicks
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                sendMessage();
            }
        });
    }

    public void sendMessage() {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editText = (EditText) findViewById(R.id.input_user);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
