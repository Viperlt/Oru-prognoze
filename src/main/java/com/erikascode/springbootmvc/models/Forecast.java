package com.erikascode.springbootmvc.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;
    public String date;
    public String temperature;
    public String city;
    public int userId;

    public Forecast(){

    }

    public Forecast(String date, String temperature, String city, int userId) {
        this.date = date;
        this.temperature = temperature;
        this.city = city;
        this.userId = userId;
    }

}
