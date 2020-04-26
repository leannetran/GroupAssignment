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

public class backQuiz extends AppCompatActivity {

    private TextView tvBack;
    private Button submitBackBtn, quitBackBtn;
    private RadioGroup radiogBack;
    private RadioButton rbb1, rbb2, rbb3, rbb4;

    private String questions[] = {
            "1. What is/are the primary muscle/s in a lat pull down?",
            "2. What best describes a low cable row?",
            "3. Which home exercise requires extension of the elbow with shoulders pushing body towards the wall? ",
            "4. Is a mid-row a home or gym exercise? Does this exercise require feet extension? ",
            "5. Can the trunk be moved when doing a standing row?"
    };

    private String answers[] = {
            "Latissimus dorsi, rhomboideus, trapezius", "Trainee sits with feet placed on foot plate while pulling the bar to the midsection",
            "Standing Push Up", "Gym, no", "No"
    };

    private String choices[] = {
            "Latissimus dorsi, rhomboideus, trapezius", "Latissimus dorsi, rhomboideus, trapezius, biceps", "Latissimus dorsi, rhomboideus, trapezius, reat deltoids", "Latissimus dorsi, rhomboideus",
            "Trainee sits with feet placed on foot plate while pulling the bar to the midsection", "Trainee sits on seat adjusted as far back as possible, while pulling the bar far back", "While standing, trainee starts with flexed shoulders, elbows extended outwards and pulling resistance as far back as possible", "Trainee sits on seat adjusted to the lowest position, and grips onto bar and pulls straight down then up again",
            "Lat Pull Down", "Standing Row", "Standing Push Up", "Mid Row",
            "Gym, no", "Gym, yes", "Home, no", "Home, yes",
            "Yes", "No", "Only when elbows are extended outwards", "Only when breathing out"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_quiz);

        final TextView score = (TextView) findViewById(R.id.tvNumBack);
        Intent intent = getIntent();

        submitBackBtn = (Button) findViewById(R.id.btnNextBack);
        quitBackBtn = (Button) findViewById(R.id.btnQuitBack);
        tvBack = (TextView) findViewById(R.id.tvQBack);

        radiogBack = (RadioGroup) findViewById(R.id.answersBack);
        rbb1 = (RadioButton) findViewById(R.id.rbBack);
        rbb2 = (RadioButton) findViewById(R.id.rbBack2);
        rbb3 = (RadioButton) findViewById(R.id.rbBack3);
        rbb4 = (RadioButton) findViewById(R.id.rbBack4);
        tvBack.setText(questions[flag]);
        rbb1.setText(choices[0]);
        rbb2.setText(choices[1]);
        rbb3.setText(choices[2]);
        rbb4.setText(choices[3]);
        submitBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If a radio button isn't selected, application makes user select a choice
                if (radiogBack.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                //hold correct and wrong answers using flag, and displaying these correct/wrong answers with Toast
                RadioButton rdb = (RadioButton) findViewById(radiogBack.getCheckedRadioButtonId());
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
                    tvBack.setText(questions[flag]);
                    rbb1.setText(choices[flag * 4]);
                    rbb2.setText(choices[flag * 4 + 1]);
                    rbb3.setText(choices[flag * 4 + 2]);
                    rbb4.setText(choices[flag * 4 + 3]);
                } else {
                    marks = correct;
                    finishQuiz();
                    //reset the score back to 0;
                    correct = Integer.valueOf(0);
                }
                radiogBack.clearCheck();

            }
        });

        quitBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), quizHomePage.class);
                startActivity(intent);
            }
        });
    }

    //small window to set and display results and option to exit or redo quiz
    private void finishQuiz() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(backQuiz.this, R.style.AlertDialogTheme);
        alertDialogBuilder
                .setMessage("You've finished the quiz! You scored " + marks + "/5.")
                .setCancelable(false)
                .setPositiveButton("REDO QUIZ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        startActivity(new Intent(getApplicationContext(), backQuiz.class));
                    }
                })
                .setNeutralButton("CHECK PROGRESS", new DialogInterface.OnClickListener() {
                    // int count = 0;
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        finish();
                        //count++;
                        Intent intent = new Intent(backQuiz.this, backProgress.class);
                        intent.putExtra("marks", marks);
                        //intent.putExtra("count", count);
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
