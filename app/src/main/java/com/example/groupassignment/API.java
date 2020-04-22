package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.groupassignment.Entities.Exercise;
import com.example.groupassignment.Entities.Result;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API extends AppCompatActivity {
    private Button muscleButton;
    private TextView muscleTv;
    private String TAG = "API";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_p_i);

        muscleButton = findViewById(R.id.buttonMuscle);
        muscleTv = findViewById(R.id.exerciseTv);

        //create Retrofit instance & parse the retrieved JSON using GSON deserializer
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://wger.de").addConverterFactory(GsonConverterFactory.create()).build();

        muscleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get a service and call object for the request
                ExerciseService service = retrofit.create(ExerciseService.class);
                Call<Exercise> exerciseCall = service.getData();
                exerciseCall.enqueue(new Callback<Exercise>() {
                    @Override
                    public void onResponse(Call<Exercise> call, Response<Exercise> response) {
                        Log.d(TAG, "onResponse: SUCCESS");
                        List<Result> results = response.body().getResults();
                        //Call random values of name in Results arraylist
                        Random r = new Random();
                        int index = r.nextInt(results.size());
                        muscleTv.setText(results.get(index). getName());
                    }

                    @Override
                    public void onFailure(Call<Exercise> call, Throwable t) {
                        Log.d(TAG, "onFailure: FAILURE");

                    }
                });
            }
        });
    }
}
