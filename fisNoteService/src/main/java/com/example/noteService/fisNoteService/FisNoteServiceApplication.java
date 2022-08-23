package com.example.noteService.fisNoteService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients(value="com.example.noteService.fisNoteService.service")
@EnableEurekaClient
public class FisNoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FisNoteServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}

}
