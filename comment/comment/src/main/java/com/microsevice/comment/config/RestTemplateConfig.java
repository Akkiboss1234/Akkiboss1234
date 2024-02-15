package com.microsevice.comment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }

}//it help us to intract with one module to another module this class we also made in main class because it have also configuration
