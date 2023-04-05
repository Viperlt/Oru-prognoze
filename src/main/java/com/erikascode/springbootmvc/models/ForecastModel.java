package com.erikascode.springbootmvc.models;

public class ForecastModel {

    public String data;
    public double temperatura;
    public String city;

    public ForecastModel(String data, double temperatura, String city){
        this.data = data;
        this.temperatura = temperatura;
        this.city = city;
    }
}
