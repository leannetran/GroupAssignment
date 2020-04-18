package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quizHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_home_page);


        Button armButton = (Button) findViewById(R.id.btnArms);
        Button backButton = (Button) findViewById(R.id.btnBack);
        Button chestButton = (Button) findViewById(R.id.btnChest);
        Button coreButton = (Button) findViewById(R.id.btnCore);
        Button legButton = (Button) findViewById(R.id.btnLegs);
        Button shoulderButton = (Button) findViewById(R.id.btnShoulders);

        armButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),armsQuiz.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),backQuiz.class);
                startActivity(intent);
            }
        });

        chestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),chestQuiz.class);
                startActivity(intent);
            }
        });

        coreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),coreQuiz.class);
                startActivity(intent);
            }
        });

        legButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),legsQuiz.class);
                startActivity(intent);
            }
        });

        shoulderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),shouldersQuiz.class);
                startActivity(intent);
            }
        });
    }
}
