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

public class shouldersQuiz extends AppCompatActivity {

    private TextView tv;
    private Button submitBtn, quitBtn;
    private RadioGroup radiog;
    private RadioButton rba1, rba2, rba3, rba4;

    private String questions[] = {
            "1. Which exercise requires the seat to be adjusted to the most upright position with training arms in a vertical position?",
            "2. What best describes a shoulder press?",
            "3. What muscle/s is/are used in the lateral arm raise?",
            "4. What exercises requires the trainee to start at the starting position with the back rested to the bar of a chair?",
            "5. How long are the dumbbells usually held for in a lateral arm raise?"
    };

    private String answers[] = {
            "Cable Shoulder Press", "Seat must be aligned with shoulder, trainee grabs handles and presses away from shoulder then returns to starting position",
            "Deltoids", "Seated Shoulder Press", "2-3 seconds"
    };

    private String choices[] = {
            "Shoulder Press", "Seated Shoulder Press", "Lateral Arm Raise", "Cable Shoulder Press",
            "Seat is aligned with shoulder, trainee grabs handles and presses away from shoulder then returns to starting position", "Seat is adjusted to the most upright position, trainee grabs handle at shoulder level and lifts cable overhead and returning to start position", "Standing with dumbbells pointing downwards, lift dumbbells horizontally and then down again", "Trainee sits with back rested on chair, and extends elbows with shoulder flexion upwards",
            "Triceps", "Deltoids", "Triceps and deltoids", "Tricep brachii and deltoids",
            "Seated shoulder press", "Cable shoulder press", "Lateral Arm Raise", "Shoulder Press",
            "1-2 seconds", "2-3 seconds", "4-5 seconds", "10 seconds"

    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulders_quiz);
        final TextView score = (TextView) findViewById(R.id.tvNumShoulders);
        Intent intent = getIntent();

        submitBtn = (Button) findViewById(R.id.btnNextShoulders);
        quitBtn = (Button) findViewById(R.id.btnQuitShoulders);
        tv = (TextView) findViewById(R.id.tvQShoulders);

        radiog = (RadioGroup) findViewById(R.id.answersShoulders);
        rba1 = (RadioButton) findViewById(R.id.rbShoulders);
        rba2 = (RadioButton) findViewById(R.id.rbShoulders2);
        rba3 = (RadioButton) findViewById(R.id.rbShoulders3);
        rba4 = (RadioButton) findViewById(R.id.rbShoulders4);
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

                //hold correct and wrong answers using flag, and displaying these correct/wrong answers with Toast
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
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(shouldersQuiz.this, R.style.AlertDialogTheme);
        alertDialogBuilder
                .setMessage("You've finished the quiz! You scored " + marks + "/5.")
                .setCancelable(false)
                .setPositiveButton("REDO QUIZ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        startActivity(new Intent(getApplicationContext(), shouldersQuiz.class));
                    }
                })
                .setNeutralButton("CHECK PROGRESS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        finish();
                        Intent intent = new Intent(shouldersQuiz.this, shouldersProgress.class);
                        intent.putExtra("marks", marks);
                        startActivity(intent);
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


