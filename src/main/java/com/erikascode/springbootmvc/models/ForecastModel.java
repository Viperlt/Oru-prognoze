package com.erikascode.springbootmvc.models;

public class ForecastModel {

    public String placeName;
    public String data;
    public double temperatura;

    public ForecastModel(String placeName, String data, double temperatura){
        this.placeName = placeName;
        this.data = data;
        this.temperatura = temperatura;
    }
}
