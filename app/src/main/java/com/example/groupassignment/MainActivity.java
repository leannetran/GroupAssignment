package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static int splashTime = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a handler for the splash screen:
        new Handler().postDelayed(new Runnable(){
            @Override

            public void run(){
                Intent homeScreenIntent = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(homeScreenIntent);
                finish();
            }
        }, splashTime);

    }
}
