package com.j62u63310.server.service;

import com.j62u63310.server.model.Weather;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class weatherService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "CWA-621F40F0-AF1A-4F52-B36B-91EE222EB0EC";
    private final String apiUrl = "https://opendata.cwa.gov.tw/api/v1/rest/datastore/F-C0032-001";

    public Weather getWeather(String city) {
        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("Authorization", apiKey)
                .queryParam("locationName", city)
                .build();
        ResponseEntity<Weather> responseEntity = restTemplate.exchange(
                uriBuilder.toUri(),
                HttpMethod.GET,
                null,
                Weather.class);
        return responseEntity.getBody();
    }
}
