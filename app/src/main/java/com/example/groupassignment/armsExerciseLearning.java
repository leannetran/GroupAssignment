package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class armsExerciseLearning extends AppCompatActivity {

    PDFView armsContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms_exercise_learning);

        armsContent = findViewById(R.id.armsContent);
        armsContent.fromAsset("arms.pdf").load();

        //Button for quick access to quiz for Arms
        Button armBtn = (Button) findViewById(R.id.btntestArms);

        armBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),armsQuiz.class);
                startActivity(intent);
            }
        });
    }
}
