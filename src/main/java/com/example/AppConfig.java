package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class AppConfig {
	
	@Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}