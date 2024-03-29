package com.example.thun_storm.Retrofit;

import com.google.gson.annotations.SerializedName;
public class Main {

    @SerializedName("temp")
    String temp;

    @SerializedName("feels_like")
    String feels_like;

    @SerializedName("humidity")
    String humidity;

    @SerializedName("pressure")
    String pressure;

    public String getTemp() { return temp; }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) { this.humidity = humidity; }

    public String getPressure() { return pressure; }

    public void setPressure(String pressure) { this.pressure = pressure; }
}
