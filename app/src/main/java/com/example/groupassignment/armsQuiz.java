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

public class armsQuiz extends AppCompatActivity {
    private TextView tvArm;
    private Button submitArmBtn, quitArmBtn;
    private RadioGroup radiogArm;
    private RadioButton rba1, rba2, rba3, rba4;

    private String questions[] = {
            "1. Which exercise requires the seat to be adjusted to an upright position with the training arms to come down the lowest position?",
            "2. What best describes the Triceps Extension from High Pulley?",
            "3. What muscle/s is/are used in the triceps pushdown?",
            "4. What grip is used for the triceps pushdown?",
            "5. What exercise focuses on the triceps brachii?"
    };

    private String answers[] = {
            "Cable Arm Curl", "Trainee sits learning forwards as straight bar is held, lower arm is then extended at the elbow",
            "Brachioradialis and Triceps", "Both underhand and overhand", "Standing Push Up"
    };

    private String choices[] = {
            "Triceps Extension", "Cable Arm Curl", "Triceps Pushdown", "Seated Push Up",
            "Trainee is seated upwards holding handles, then curled upwards and back down", "Trainee stands in front of high pullet, with bar pulled down where elbow is locked to the sides", "Trainee sits learning forwards as straight bar is held, lower arm is then extended at the elbow", "Trainee sits in upright position, and extending elbow joint from a 90 degrees position",
            "Biceps and Brachioradials", "Biceps", "Anterior Deltoids and Triceps", "Brachioradialis and Triceps",
            "Underhand", "Overhand", "Both underhand and overhand", "Neither options",
            "Standing Push Up", "Seated Chest Press", "Triceps Pulldown", "Triceps Extension"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms_quiz);
        final TextView score = (TextView) findViewById(R.id.tvNumArms);
        Intent intent = getIntent();

        submitArmBtn = (Button) findViewById(R.id.btnNextArms);
        quitArmBtn = (Button) findViewById(R.id.btnQuitArms);
        tvArm = (TextView) findViewById(R.id.tvQArms);

        radiogArm = (RadioGroup) findViewById(R.id.answersArms);
        rba1 = (RadioButton) findViewById(R.id.rbArms);
        rba2 = (RadioButton) findViewById(R.id.rbArms2);
        rba3 = (RadioButton) findViewById(R.id.rbArms3);
        rba4 = (RadioButton) findViewById(R.id.rbArms4);
        tvArm.setText(questions[flag]);
        rba1.setText(choices[0]);
        rba2.setText(choices[1]);
        rba3.setText(choices[2]);
        rba4.setText(choices[3]);
        submitArmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiogArm.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radiogArm.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if (ansText.equals(answers[flag])) {
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
                    tvArm.setText(questions[flag]);
                    rba1.setText(choices[flag * 4]);
                    rba2.setText(choices[flag * 4 + 1]);
                    rba3.setText(choices[flag * 4 + 2]);
                    rba4.setText(choices[flag * 4 + 3]);
                } else {
                    marks = correct;
                    finishQuiz();

                }
                radiogArm.clearCheck();
            }
        });

        quitArmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), quizHomePage.class);
                startActivity(intent);
            }
        });
    }

    private void finishQuiz() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(armsQuiz.this);
        alertDialogBuilder
                .setMessage("You've finished the quiz! You scored  " + marks + "/5.")
                .setCancelable(false)
                .setPositiveButton("REDO QUIZ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        startActivity(new Intent(getApplicationContext(), armsQuiz.class));
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