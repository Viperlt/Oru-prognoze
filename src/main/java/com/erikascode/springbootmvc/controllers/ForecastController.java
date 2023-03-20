package com.erikascode.springbootmvc.controllers;

import com.erikascode.springbootmvc.models.ForecastModel;
import com.erikascode.springbootmvc.models.IndexModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ForecastController {


//    @GetMapping("/")
////    public ModelAndView index(){
////        var modelAndView = new ModelAndView("index");
////
////        var indexModel = new IndexModel();
////
////        var cities = new ArrayList<String>();
////        cities.add("Vilnius");
////        cities.add("Kaunas");
////        cities.add("Visaginas");
////        cities.add("Klaipeda");
////
////
////
////        indexModel.cities = cities;
////
////        modelAndView.addObject("IndexModel", indexModel);
////
////        return modelAndView;
////    }
    @GetMapping("/")
    public ModelAndView forecast(){
        var modelAndView = new ModelAndView("index");
        var indexModel = new IndexModel();

        var forecasts = new ArrayList<ForecastModel>();
        forecasts.add(new ForecastModel("2023-03-20",3.4));
        forecasts.add(new ForecastModel("2023-03-21",4));
        forecasts.add(new ForecastModel("2023-03-22",5.6));
        indexModel.forecasts = forecasts;


        modelAndView.addObject("IndexModel", indexModel);

        return modelAndView;
    }


}
