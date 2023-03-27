package com.erikascode.springbootmvc.controllers;

import com.erikascode.springbootmvc.models.Forecast;
import com.erikascode.springbootmvc.models.ForecastModel;
import com.erikascode.springbootmvc.repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ForecastRestController {

    @Autowired
    private ForecastRepository forecastRepository;

    @PostMapping(value = "/api/forecast", consumes = "application/json")
    public void forecastRestApi(@RequestBody ForecastModel model) {

        Forecast entity = new Forecast(
                model.data,
                String.valueOf(model.temperatura),
                "Vilnius",
                1);
        forecastRepository.save(entity);

    }
}
