package com.example.groupassignment;

import com.example.groupassignment.Entities.Muscle;
import com.example.groupassignment.Entities.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MuscleService {
    @GET("/api/v2/muscle/?format=json")
    Call<Muscle> getData();


}
