package com.j62u63310.server.controller;

import com.j62u63310.server.model.Weather;
import com.j62u63310.server.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class WeatherController {

    @Autowired
    private WeatherService testService;
    @GetMapping("/api/weather")
    public ResponseEntity<Weather> getWeather(@NonNull @RequestParam String city) {
        System.out.println(city);
        Weather weather = testService.getWeather(city);
        return ResponseEntity.status(HttpStatus.OK).body(weather);
    }
}
