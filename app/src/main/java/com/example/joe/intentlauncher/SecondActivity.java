package com.example.joe.intentlauncher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String title = intent.getStringExtra("KEY_TITLE");
        String message = intent.getStringExtra("KEY_MESSAGE");
        this.setTitle(title);
        TextView text = findViewById(R.id.message);
        text.setText(message);
    }




}
