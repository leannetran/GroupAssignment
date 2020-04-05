package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class coreExerciseLearning extends AppCompatActivity {

    PDFView coreContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_exercise_learning);

        coreContent = findViewById(R.id.coreContent);
        coreContent.fromAsset("core.pdf").load();

        //Button for quick access to quiz for Core
        Button coreBtn = (Button) findViewById(R.id.btntestCore);

        coreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),coreQuiz.class);
                startActivity(intent);
            }
        });

    }
}
