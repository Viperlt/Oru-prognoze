package com.erikascode.springbootmvc.controllers;

import com.erikascode.springbootmvc.models.ForecastModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ForecastRestController {

    @PostMapping(value = "/api/forecast", consumes = "application/json")
    public void forecastRestApi(@RequestBody ForecastModel model) {

    }
}
