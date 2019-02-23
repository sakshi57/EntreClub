package com.example.entreclub;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @POST("signUp")
    Call<RetrofitClient> registerUser(@Body RetrofitClient user);

    @GET("signIn/{id}")
    Call<signInClient> signInUser(@Path("id") String emailid);
}



