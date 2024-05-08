package com.example.OnlineLibrarySW2.Entity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}