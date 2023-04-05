package com.erikascode.springbootmvc.controllers;

import com.erikascode.springbootmvc.models.Forecast;
import com.erikascode.springbootmvc.models.ForecastModel;
import com.erikascode.springbootmvc.repositories.ForecastRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastRestController {

    @Autowired
    private ForecastRepository forecastRepository;

    @PostMapping(value = "/api/forecast", consumes = "application/json")
    public void forecastRestApi(@RequestBody ForecastModel model) {

        String str = "";
        String firstLetter = model.city.substring(0,1).toUpperCase();
        String endOfAString = model.city.substring(1);
        str = firstLetter + endOfAString;

        Forecast entity = new Forecast(
                model.data,
                String.valueOf(model.temperatura),
                str,
                1);
        forecastRepository.save(entity);

    }

    @PostMapping (value = "/api/delete-my-forecast", consumes = "application/json")
    public void deleteForecast(@RequestBody Forecast forecastEntity) {

        Forecast entityDelete = forecastRepository.findById(forecastEntity.id).get();

        forecastRepository.delete(entityDelete);
    }
}
