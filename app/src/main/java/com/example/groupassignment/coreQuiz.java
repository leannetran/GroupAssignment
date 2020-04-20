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

public class coreQuiz extends AppCompatActivity {

    private TextView tv;
    private Button submitBtn, quitBtn;
    private RadioGroup radiog;
    private RadioButton rba1, rba2, rba3, rba4;

    private String questions[] = {
            "1. What exercise involves hip extension opposite to the shoulder?",
            "2. What best describes Side Bends?",
            "3. Which exercise is also known as the Reverse Crunch?",
            "4. How are the abdominal muscles worked through an Ab Crunch?",
            "5. What muscle/s is/are used in the Bird Cat Exercise?"
    };

    private String answers[] = {
            "Bird Cat Exercise", "Trainee tilts to side pushing handle slightly and holding stationary",
            "Seated Knee Raise", "Crunching to the front and holding that position before moving back up to the start position", "Rectus abdominis, internal and external obliques, and erector muscles of the spine"
    };

    private String choices[] = {
            "Ab Crunch", "Bird Cat Exercise", "Seated Knee Raise", "Side Bends",
            "Trainee is seated, and handles are grasped while legs are extended", "Trainee is seated, with ab strap held over shoulders and crunched", "Trainee tilts to side pushing handle slightly and holding stationary", "Trainee tilts to side and pushes leg to outwards",
            "Bird Cat Exercise", "Ab Crunch", "Seated Knee Raise", "Side Bends",
            "Crunching to the front and holding that position before moving back up to the start position", "Crunching to the side and holding that position before moving back up to the start position", "Tilting to the side and pushing handle slightly", "Pulling ab strap over shoulders while seated",
            "Abdominals and Obliques", "Rectus abdominis, internal and external obliques, and erector muscles of the spine", "Rectus abdominis and erector muscles of the spine", "Abdominals and internal and external obliques"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_quiz);

        final TextView score = (TextView) findViewById(R.id.tvNumCore);
        Intent intent = getIntent();

        submitBtn = (Button) findViewById(R.id.btnNextCore);
        quitBtn = (Button) findViewById(R.id.btnQuitCore);
        tv = (TextView) findViewById(R.id.tvQCore);

        radiog = (RadioGroup) findViewById(R.id.answersCore);
        rba1 = (RadioButton) findViewById(R.id.rbCore);
        rba2 = (RadioButton) findViewById(R.id.rbCore2);
        rba3 = (RadioButton) findViewById(R.id.rbCore3);
        rba4 = (RadioButton) findViewById(R.id.rbCore4);
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
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(coreQuiz.this, R.style.AlertDialogTheme);
        alertDialogBuilder
                .setMessage("You've finished the quiz! You scored " + marks + "/5.")
                .setCancelable(false)
                .setPositiveButton("REDO QUIZ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        startActivity(new Intent(getApplicationContext(), coreQuiz.class));
                    }
                })
                .setNeutralButton("CHECK PROGRESS", new DialogInterface.OnClickListener() {
                    // int count = 0;
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        finish();
                        //count++;
                        Intent intent = new Intent(coreQuiz.this, coreProgress.class);
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


