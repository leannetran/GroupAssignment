package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;

public class chestExerciseLearning extends AppCompatActivity {

    PDFView chestContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_exercise_learning);

        chestContent = findViewById(R.id.chestContent);
        chestContent.fromAsset("chest.pdf").load();

        //Button for quick access to quiz for Chest
        Button chestBtn = (Button) findViewById(R.id.btntestChest);

        chestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),chestQuiz.class);
                startActivity(intent);
            }
        });

    }

}
