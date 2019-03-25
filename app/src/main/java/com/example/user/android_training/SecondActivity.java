package com.example.user.android_training;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button dFragButton2;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.incoming_info);
        textView.setText(message);

        // Capture button clicks
        dFragButton2 = (Button) findViewById(R.id.dfragbutton2);
        dFragButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                sendMessageFragment();
            }
        });
    }

    public void sendMessageFragment(){
        //take string
        EditText editText = (EditText) findViewById(R.id.incoming_info);
        String message = editText.getText().toString();

        //send string as a param
        Bundle bundle = new Bundle();
        bundle.putString("params", message);

        //create DialogFragment
        MyDialogFragment dFragment2 = new MyDialogFragment();
        dFragment2.setArguments(bundle);
        dFragment2.show(fm, "Dialog Fragment");
    }
}
