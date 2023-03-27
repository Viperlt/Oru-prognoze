package com.erikascode.springbootmvc.controllers;

import com.erikascode.springbootmvc.models.ForecastModel;
import com.erikascode.springbootmvc.models.IndexModel;
import com.erikascode.springbootmvc.models.Place;
import com.erikascode.springbootmvc.models.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class ForecastController {

    @GetMapping("/")
    public ModelAndView forecast(@RequestParam(required = false) String cityCode) throws IOException {
        var modelAndView = new ModelAndView("index");
        var indexModel = new IndexModel();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userName;
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        indexModel.userName = userName;

        ArrayList<Place> cities = getCities();
        indexModel.cities = cities;

        if(cityCode != null && !cityCode.equals("")) {
            ArrayList<ForecastModel> forecasts = getForecast(cityCode);
            indexModel.forecasts = forecasts;
        }

        if(cityCode == ""){
            cityCode = null;
        }
        modelAndView.addObject("IndexModel", indexModel);

        indexModel.currentCityCode = cityCode;

        return modelAndView;
    }

    private static String loadDataJson(String apiURL) throws IOException {
        URL url = new URL(apiURL);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        String text = "";
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            text += scanner.nextLine();
        }
        scanner.close();


        return text;
    }

    private static ArrayList<Place> getCities() throws IOException {
        var cities = new ArrayList<Place>();

        var jsons =  loadDataJson("https://api.meteo.lt/v1/places");

        ObjectMapper om = new ObjectMapper();
        Place[] places = om.readValue(jsons, Place[].class);

        for(var place : places){
            var placeCode = new Place();
            placeCode.code = place.code;
            placeCode.name = place.name;
            cities.add(placeCode);
        }

        return cities;
    }

    private static ArrayList<ForecastModel> getForecast(String cityCode) throws IOException {
        var forecasts = new ArrayList<ForecastModel>();

        var jsons =  loadDataJson("https://api.meteo.lt/v1/places/"+ cityCode +"/forecasts/long-term");
        Root obj = createObject(jsons);

        for(var stamp : obj.forecastTimestamps){
            var forecast = new ForecastModel(stamp.forecastTimeUtc, stamp.airTemperature);
            forecasts.add(forecast);
        }

        return forecasts;
    }

    private static Root createObject(String jsons) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Root obj = om.readValue(jsons, Root.class);
        return obj;
    }


}
