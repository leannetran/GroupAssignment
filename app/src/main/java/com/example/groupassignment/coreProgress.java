package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class coreProgress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_progress);

        TextView yourMark = findViewById(R.id.yourMarkCore);
        TextView highestMark = findViewById(R.id.highestMarkCore);

        TextView attempt = findViewById(R.id.attemptCore);
        //TextView attemptValue = findViewById(R.id.attemptValue);

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
