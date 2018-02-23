package com.example.joe.intentlauncher;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private String mTitle;
    private String mMessage;
    private boolean mCheckbox ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendEmail(View view) {

        EditText title = findViewById(R.id.title_text); //
        mTitle = title.getText().toString();

        EditText message = findViewById(R.id.message_text); //
        mMessage = message.getText().toString();

        CheckBox checkbox = findViewById(R.id.only_checkbox);
        mCheckbox = checkbox.isChecked();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, mTitle);
        if (!mCheckbox) {
            intent.putExtra(Intent.EXTRA_TEXT, mMessage);
        }
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void startCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void launchActivity(View view) {

        EditText title = findViewById(R.id.title_text); //
        mTitle = title.getText().toString();

        EditText message = findViewById(R.id.message_text); //
        mMessage = message.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        // pass a string to the second activity
        intent.putExtra("KEY_TITLE", mTitle);
        intent.putExtra("KEY_MESSAGE", mMessage);

        startActivity(intent);

    }
}
