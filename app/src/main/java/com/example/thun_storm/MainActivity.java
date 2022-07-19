package com.example.thun_storm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thun_storm.Retrofit.APIClient;
import com.example.thun_storm.Retrofit.ApiInterface;
import com.example.thun_storm.Retrofit.Example;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView search;
    TextView Temp,descText,humidityText,pressure;
    EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search);
        Temp = findViewById(R.id.Temp);
        descText = findViewById(R.id.descText);
        humidityText = findViewById(R.id.humidityText);
        pressure = findViewById(R.id.pressure);
        textField = findViewById(R.id.textField);


        search.setOnClickListener(v -> {

            //Here we will call API
            getWeatherData(textField.getText().toString().trim());
        });

    }

    private  void  getWeatherData(String name){

        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NotNull Call<Example> call, @NotNull Response<Example> response){


                //Log.d("DATA",   response.body().getMain().getTemp());
                //assert response.body() != null;
                Temp.setText(response.body().getMain().getTemp());
                descText.setText(response.body().getMain().getFeels_like());
                humidityText.setText(response.body().getMain().getHumidity());
                pressure.setText(response.body().getMain().getPressure());

            }

            @Override
            public void onFailure(@NotNull Call<Example> call, @NotNull Throwable t) {

            }
        });

    }
}