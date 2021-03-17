package com.krishna.sharedpreferencelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username,password;
    Button login;
    SharedPreferences sharedPreferences;
    public static final String fileName = "login";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.t1);
        password = findViewById(R.id.t2);
        login = findViewById(R.id.submit);

        sharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(USERNAME)){
            Intent i = new Intent(Login.this,MainActivity.class);
            startActivity(i);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(uname.equals("krishna") && pass.equals("krishna@123")){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(USERNAME,uname);
                    editor.putString(PASSWORD,pass);
                    editor.commit();

                    Toast.makeText(getApplicationContext(),"Login Successfull..",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalid User Details",Toast.LENGTH_LONG).show();
                    username.setText("");
                    username.requestFocus();
                    password.setText("");
                }

            }
        });
    }
}