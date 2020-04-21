package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.groupassignment.Entities.Muscle;
import com.example.groupassignment.Entities.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API extends AppCompatActivity {
    private Button muscleButton;
    private TextView muscleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_p_i);

        muscleButton = findViewById(R.id.buttonMuscle);
        muscleTv = findViewById(R.id.textViewMuscle);

        //create Retrofit instance & parse the retrieved JSON using GSON deserializer
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://wger.de").addConverterFactory(GsonConverterFactory.create()).build();

        muscleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get a service and call object for the request
                MuscleService service = retrofit.create(MuscleService.class);
                Call<Muscle> muscleCall = service.getData();
                muscleCall.enqueue(new Callback<Muscle>() {
                    @Override
                    public void onResponse(Call<Muscle> call, Response<Muscle> response) {
                        Muscle m  = response.body();
                        muscleTv.setText(m.getResults().get(0).getName());

                    }

                    @Override
                    public void onFailure(Call<Muscle> call, Throwable t) {
                        System.out.println("failed");

                    }
                });




            }
        });



    }
}
