package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class shouldersExerciseLearning extends AppCompatActivity {

    PDFView shouldersContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulders_exercise_learning);

        shouldersContent = findViewById(R.id.shouldersContent);
        shouldersContent.fromAsset("shoulders.pdf").load();

        //Button for quick access to quiz for Shoulders
        Button shoulderBtn = (Button) findViewById(R.id.btntestShoulder);

        shoulderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),shouldersQuiz.class);
                startActivity(intent);
            }
        });

    }
}
