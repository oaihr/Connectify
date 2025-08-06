package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
	
	@Bean
	public ObjectMapper objectMapper() {
		
		ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		return objectMapper;
	}
	
	@Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(10000); 
        factory.setReadTimeout(60000);    
        return new RestTemplate(factory);
    }

}
