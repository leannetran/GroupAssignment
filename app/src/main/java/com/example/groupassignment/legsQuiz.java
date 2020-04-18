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

public class legsQuiz extends AppCompatActivity {
    private TextView tv;
    private Button submitBtn, quitBtn;
    private RadioGroup radiog;
    private RadioButton rba1, rba2, rba3, rba4;

    private String questions[] = {
            "1. What exercise requires the participant to be seated, ankles kept hooked behind lower pads, then legs extended horizontally and back?",
            "2. What main muscle/s is/are using in a standing leg curl?",
            "3. Is a leg curl a home exercise? What best describes a leg curl?",
            "4. What is the main difference between a leg extension and a leg curl?",
            "5. What happens if the toe is pointed in a standing leg curl?"
    };

    private String answers[] = {
            "Leg Extension", "Hamstring and gastrocnemius", "Yes, bringing knees into a 90 degrees flexion",
            "Leg extension works out the quadriceps while leg curl works out the hamstring", "The calf muscle gets less worked"
    };

    private String choices[] = {
            "Leg Curl", "Standing Leg Curl", "Leg Extension", "Sitting Leg Curl",
            "Hamstring", "Quadriceps", "Hamstring and quadriceps", "Hamstring and gastrocnemius",
            "Yes, bringing knees into a 90 degrees flexion", "No, bringing knees into a 90 degrees flexion", "Yes, face machine standing on one leg and the other bending up and down", "No, face machine standing on one leg and the other bending up and down",
            "Leg extension works out the hamstring while leg curl works out the quadriceps", "Leg extension works out the quadriceps while leg curl works out the hamstring", "Leg extension works out the quadriceps while leg curl works out the gastrocnemius", "Leg extension works out the gastrocnemius while leg curl works out the hamstring",
            "The calf muscle gets less worked", "The calf muscle gets more worked", "The hamstring muscle gets less worked", "The hamstring muscle gets more worked"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs_quiz);
        final TextView score = (TextView) findViewById(R.id.tvNumLegs);
        Intent intent = getIntent();

        submitBtn = (Button) findViewById(R.id.btnNextLegs);
        quitBtn = (Button) findViewById(R.id.btnQuitLegs);
        tv = (TextView) findViewById(R.id.tvQLegs);

        radiog = (RadioGroup) findViewById(R.id.answersLegs);
        rba1 = (RadioButton) findViewById(R.id.rbLegs);
        rba2 = (RadioButton) findViewById(R.id.rbLegs2);
        rba3 = (RadioButton) findViewById(R.id.rbLegs3);
        rba4 = (RadioButton) findViewById(R.id.rbLegs4);
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
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(legsQuiz.this);
        alertDialogBuilder
                .setMessage("You've finished the quiz! You scored " + marks + "/5.")
                .setCancelable(false)
                .setPositiveButton("REDO QUIZ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        startActivity(new Intent(getApplicationContext(), legsQuiz.class));
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