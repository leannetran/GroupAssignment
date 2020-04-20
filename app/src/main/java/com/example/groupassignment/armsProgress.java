package com.example.groupassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class armsProgress extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms_progress);

        TextView yourMark = findViewById(R.id.yourMark);
        TextView highestMark = findViewById(R.id.highestMark);

        TextView attempt = findViewById(R.id.attempt);
        //TextView attemptValue = findViewById(R.id.attemptValue);

        //get the score from the quiz by Intent
        Intent intent = getIntent();
        int marks = intent.getIntExtra("marks", 0);


        yourMark.setText("Your Mark: " + marks);


        if(marks >= 0){
            count++;
        }
        else{
            count--;
        }
        attempt.setText("Your Attempt: " + count);

       /* SharedPreferences attemptcount = getPreferences(MODE_PRIVATE);
        int count = attemptcount.getInt("number", 0);
        if (count>= 0){
            count++;

        }*/

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

/*

        SharedPreferences countPref = getPreferences(MODE_PRIVATE);
        int counter = countPref.getInt("counter", 0);
        if (marks>= 0){
            counter++;
            attempt.setText("Attempt: " + counter);
        }
        else{

            attempt.setText("Attempt:" + counter);

        }



*/


    }


}
