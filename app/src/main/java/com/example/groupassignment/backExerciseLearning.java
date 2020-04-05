package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class backExerciseLearning extends AppCompatActivity {

    PDFView backContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_exercise_learning);

        backContent = findViewById(R.id.backContent);
        backContent.fromAsset("back.pdf").load();

        //Button for quick access to quiz for Back
        Button backBtn = (Button) findViewById(R.id.btntestBack);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),backQuiz.class);
                startActivity(intent);
            }
        });

    }
}
