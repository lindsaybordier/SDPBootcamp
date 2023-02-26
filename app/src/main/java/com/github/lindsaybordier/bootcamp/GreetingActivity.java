package com.github.lindsaybordier.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    String name;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        textView = (TextView) findViewById(R.id.greetingMessage);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        System.out.println("oui le nom : "+name);
        textView.setText("Greetings " + name.toString());
    }
}