package com.erikascode.springbootmvc.models;

import java.util.ArrayList;

public class Root{
    public String code;
    public String name;
    public String administrativeDivision;
    public String countryCode;
    public Place place;
    public String forecastType;
    public String forecastCreationTimeUtc;
    public ArrayList<ForecastTimestamp> forecastTimestamps;
}
