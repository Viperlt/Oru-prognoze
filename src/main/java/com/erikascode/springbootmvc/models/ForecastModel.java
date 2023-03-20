package com.erikascode.springbootmvc.models;

public class ForecastModel {

    public String data;
    public double temperatura;

    public ForecastModel(String data, double temperatura){
        this.data = data;
        this.temperatura = temperatura;
    }
}
