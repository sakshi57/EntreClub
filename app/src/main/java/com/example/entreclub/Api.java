package com.example.entreclub;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("signUp")
    Call<RetrofitClient> registerUser(@Body  RetrofitClient user);
}
