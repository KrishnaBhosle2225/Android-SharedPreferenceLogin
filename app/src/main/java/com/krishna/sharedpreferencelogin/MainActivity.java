package com.krishna.sharedpreferencelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    SharedPreferences sharedPreferences;
    public static final String fileName = "login";
    public static final String USERNAME = "username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        sharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(USERNAME)){
            textView.setText("Welcome To AsciiEducation");
        }

    }
}