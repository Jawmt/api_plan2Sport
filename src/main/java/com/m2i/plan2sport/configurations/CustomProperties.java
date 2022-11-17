package com.m2i.plan2sport.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix= "api.football")
@Data
public class CustomProperties {

    private String key;
    private String token;

}
