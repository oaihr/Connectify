package com.app.config;


import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.app.api.service.ApiService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
	
	@Bean
	public ObjectMapper objectMapper() {
		
		ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}
	
	@Bean
    public RestTemplate restTemplate(ObjectMapper objectMapper) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(10000); 
        factory.setReadTimeout(60000);
        
        RestTemplate restTemplate = new RestTemplate(factory);

        // ** 핵심 변경 사항: 커스텀 ObjectMapper를 RestTemplate에 등록 **
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper); // 우리가 만든 ObjectMapper를 컨버터에 설정
        restTemplate.setMessageConverters(Collections.singletonList(converter)); // RestTemplate에 컨버터 등록
        
        return restTemplate;
    }

}
