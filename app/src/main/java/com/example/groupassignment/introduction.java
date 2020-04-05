package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class introduction extends AppCompatActivity {

    PDFView introductionContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        introductionContent = findViewById(R.id.introductionContent);
        introductionContent.fromAsset("introduction.pdf").load();

    }
}
