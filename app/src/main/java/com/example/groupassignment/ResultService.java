package com.example.groupassignment;

import com.example.groupassignment.Entities.Muscle;
import com.example.groupassignment.Entities.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResultService {
    @GET("/api/v2/muscle/?format=json")
    Call<Result> getData();


}
