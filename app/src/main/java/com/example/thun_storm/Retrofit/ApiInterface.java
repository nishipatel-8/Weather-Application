package com.example.thun_storm.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("http://api.openweathermap.org/data/2.5/weather?units=metric&APPID=6cb48eda8ccea9c90a2f829ecc503b1c")
    Call<Example> getWeatherData(@Query("q") String name);
}
