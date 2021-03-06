package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class backProgress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_progress);

        TextView yourMark = findViewById(R.id.yourMarkBack);
        TextView highestMark = findViewById(R.id.highestMarkBack);

        //get the score from the quiz by Intent
        Intent intent = getIntent();
        int marks = intent.getIntExtra("marks", 0);
        //int count = intent.getIntExtra("count", 0);
        yourMark.setText("Your Mark: " + marks);
        //attempt.setText("Attempt: " + count);


        //use SharedPreferences to save the best score
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore", 0);
        if (highscore>= marks){
            highestMark.setText("Highest Mark: " +highscore);
        }
        else{
            highestMark.setText("New Highest Mark: " +marks);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", marks);
            editor.commit();
        }

    }
}
