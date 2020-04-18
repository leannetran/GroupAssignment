package com.example.groupassignment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class progressHomePage extends AppCompatActivity {
    private TextView armTv;
    private TextView learningTv;
    private TextView armsMarkTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_page);

        learningTv = (TextView) findViewById(R.id.learningTv);
        armTv = (TextView) findViewById(R.id.armsTv);
        armsMarkTv = (TextView) findViewById(R.id.armsMark);


    }

    private void getMark() {

    }

}
