package com.erikascode.springbootmvc.controllers;

import com.erikascode.springbootmvc.models.Forecast;
import com.erikascode.springbootmvc.models.IndexModel;
import com.erikascode.springbootmvc.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class MyForecastController {

    @Autowired
    private ForecastRepository forecastRepository;

    @GetMapping("/my-forecasts")
    public ModelAndView forecast(@RequestParam(required = false) String cityCode) throws IOException {
        var modelAndView = new ModelAndView("myForecasts");
        var model = forecastRepository.findAll();

        modelAndView.addObject("myForecasts", model);
        return modelAndView;
    }

//    @GetMapping("/delete-my-forecast")
//    public void deleteForecast(@RequestParam(required = false) String cityCode, int id) throws IOException {
//        var modelAndView = new ModelAndView("myForecasts");
//        var model = forecastRepository.delete();
//
//
//    }

}
