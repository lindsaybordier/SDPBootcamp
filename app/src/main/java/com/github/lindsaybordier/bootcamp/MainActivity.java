package com.github.lindsaybordier.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = (EditText) findViewById(R.id.inputText);
    }



    public void goToGreeting(View view) {
        //System.out.println(inputText.getText());
        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("name", inputText.getText().toString());
        startActivity(intent);
    }
}