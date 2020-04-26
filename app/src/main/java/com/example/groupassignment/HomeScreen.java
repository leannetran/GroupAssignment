package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {


    private Button chestContent;
    private Button armsContent;
    private Button backContent;
    private Button coreContent;
    private Button introductionContent;
    private Button legsContent;
    private Button shouldersContent;
    private Button bodyCraft;
    private Button progress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Chest content:

        final Button chestContent = (Button) findViewById(R.id.chestContent);

        chestContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, chestExerciseLearning.class);
                startActivity(intent);
            }
        });

        //Arms content:

        final Button armsContent = (Button) findViewById(R.id.armsContent);

        armsContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, armsExerciseLearning.class);
                startActivity(intent);
            }
        });


        //Back content:
        final Button backContent = (Button) findViewById(R.id.backContent);

        backContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, backExerciseLearning.class);
                startActivity(intent);
            }
        });


        //Core exercises content:
        final Button coreContent = (Button) findViewById(R.id.coreContent);

        coreContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, coreExerciseLearning.class);
                startActivity(intent);
            }
        });


        //Introduction content:
        final Button introductionContent = (Button) findViewById(R.id.introductionContent);

        introductionContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, introduction.class);
                startActivity(intent);
            }
        });


        //Legs content:
        final Button legsContent = (Button) findViewById(R.id.legsContent);

        legsContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, legsExerciseLearning.class);
                startActivity(intent);
            }
        });


        //Shoulders content:
        final Button shouldersContent = (Button) findViewById(R.id.shouldersContent);

        shouldersContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, shouldersExerciseLearning.class);
                startActivity(intent);
            }
        });


        //Additional content:
        final Button bodyCraft = (Button) findViewById(R.id.bodyCraft);

        bodyCraft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser1intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bodycraft.com/pdfs/exercise/ExerciseBook.pdf"));
                startActivity(browser1intent);
            }

        });

        final Button cancerCouncil = (Button) findViewById(R.id.cancerCouncil);

        cancerCouncil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browser2intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.racgp.org.au/FSDEDEV/media/documents/Clinical%20Resources/HANDI/Guidelines-for-implementing-exercise.pdf"));
                startActivity(browser2intent);
            }

        });

        //Access Quizzes
        Button quizBtn = (Button) findViewById(R.id.quiz);

        quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),quizHomePage.class);
                startActivity(intent);
            }
        });

        //Access API
        Button exerciseButton = (Button) findViewById(R.id.exerciseButton);

        exerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),API.class);
                startActivity(intent);
            }
        });



        //Access workouts
        Button workoutButton = (Button) findViewById(R.id.workoutButton);

        workoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Workout.class);
                startActivity(intent);
            }
        });


    }
}
