package com.m2i.plan2sport.controllers;

import com.m2i.plan2sport.configurations.CustomProperties;
import com.m2i.plan2sport.services.ApiFootBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("competitions")
@ConfigurationProperties(prefix = "")
public class apiFootballController {

    private ApiFootBallService apiFootBallService;

    @Autowired
    private CustomProperties properties;

    @Autowired
    public apiFootballController(ApiFootBallService apiFootBallService){
        this.apiFootBallService = apiFootBallService;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    @GetMapping
    public Object findAll() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.set(properties.getKey(), properties.getToken());
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Map> response = restTemplate.exchange("https://api.football-data.org/v4/competitions/", HttpMethod.GET, entity, Map.class);
        return response.getBody();


    }

}
