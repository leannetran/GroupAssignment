package com.example.groupassignment;

import com.example.groupassignment.Entities.Exercise;

import com.example.groupassignment.Entities.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExerciseService {
    @GET("/api/v2/exercisecategory/?format=json")
    Call<Exercise> getData();


}
