package com.example.groupassignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class chestQuiz extends AppCompatActivity {

    private TextView tv;
    private Button submitBtn, quitBtn;
    private RadioGroup radiog;
    private RadioButton rba1, rba2, rba3, rba4;

    private String questions[] = {
            "1. What are the 3 primary muscles in a bench press?",
            "2. Which exercise begins with elbows aligning at 90 degrees?",
            "3. Which chest exercise requires the arms to converge right into the middle in an upright position? ",
            "4. Which exercise requires the starting position with knees and hands on the floor?",
            "5. What best describes a cable bench press?"
    };

    private String answers[] = {
            "Anterior deltoids, Pectorals major and minor, and triceps", "Seated Chess Press",
            "Converging Bench Press", "Modified Push Up", "Grip handles pressing it away from the chest and back in a seated position"
    };

    private String choices[] = {
            "Anterior deltoids, Pectorals major and minor, and triceps", "Anterior deltoids, Pectorals major and minor, and triceps brachii", "Anterior deltoids, Pectorals major and minor, and biceps", "Anterior deltoids, Pectorals major, and triceps",
            "Bench Press", "Converging Bench Press", "Cable Bench Press", "Seated Chess Press",
            "Converging Bench Press", "Cable Bench Press", "Seated Chess Press", "Modified Push Up",
            "Bench Press", "Modified Push Up", "Cable Bench Press", "Seated Chess Press",
            "Grip handles pressing it away from the chest and back in a seated position", "Grip handles and allow arms to converge right into the middle in a seated position", "Extend elbows with shoulder pushing up gently the returning to start position at a 90 degrees elbow inflexion", "Sit in an upright position and extend elbow joint 90 degrees"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_quiz);
        final TextView score = (TextView) findViewById(R.id.tvNumChest);
        Intent intent = getIntent();

        submitBtn = (Button) findViewById(R.id.btnNextChest);
        quitBtn = (Button) findViewById(R.id.btnQuitChest);
        tv = (TextView) findViewById(R.id.tvQChest);

        radiog = (RadioGroup) findViewById(R.id.answersChest);
        rba1 = (RadioButton) findViewById(R.id.rbChest);
        rba2 = (RadioButton) findViewById(R.id.rbChest2);
        rba3 = (RadioButton) findViewById(R.id.rbChest3);
        rba4 = (RadioButton) findViewById(R.id.rbChest4);
        tv.setText(questions[flag]);
        rba1.setText(choices[0]);
        rba2.setText(choices[1]);
        rba3.setText(choices[2]);
        rba4.setText(choices[3]);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If a radio button isn't selected, application makes user select a choice
                if (radiog.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                //hold correct and wrong answers
                RadioButton rdb = (RadioButton) findViewById(radiog.getCheckedRadioButtonId());
                String answer = rdb.getText().toString();
                if (answer.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong! Answer is " + answers[flag], Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText("" + correct);

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rba1.setText(choices[flag * 4]);
                    rba2.setText(choices[flag * 4 + 1]);
                    rba3.setText(choices[flag * 4 + 2]);
                    rba4.setText(choices[flag * 4 + 3]);
                } else {
                    marks = correct;
                    finishQuiz();
                    //reset the score back to 0;
                    correct = Integer.valueOf(0);
                }
                radiog.clearCheck();

            }
        });

        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), quizHomePage.class);
                startActivity(intent);
            }
        });

    }

    //small window to set and display results and option to exit or redo quiz
    private void finishQuiz() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(chestQuiz.this);
        alertDialogBuilder
                .setMessage("You've finished the quiz! Your scored " + marks + "/5.")
                .setCancelable(false)
                .setPositiveButton("REDO QUIZ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        startActivity(new Intent(getApplicationContext(), chestQuiz.class));
                    }
                })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}