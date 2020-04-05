package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class legsExerciseLearning extends AppCompatActivity {

    PDFView legs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs_exercise_learning);

        legs = findViewById(R.id.legs);
        legs.fromAsset("legs.pdf").load();

        //Button for quick access to quiz for Legs
        Button legBtn = (Button) findViewById(R.id.btntestLegs);

        legBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),legsQuiz.class);
                startActivity(intent);
            }
        });

    }
}
