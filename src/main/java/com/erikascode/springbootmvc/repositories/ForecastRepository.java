package com.erikascode.springbootmvc.repositories;
import com.erikascode.springbootmvc.models.Forecast;
import org.springframework.data.repository.CrudRepository;

public interface ForecastRepository extends CrudRepository<Forecast, Integer> {



}
