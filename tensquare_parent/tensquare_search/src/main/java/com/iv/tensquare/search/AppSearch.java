package com.iv.tensquare.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import util.IdWorker;

@SpringBootApplication
@EnableEurekaClient
public class AppSearch {

	public static void main(String[] args) {
		SpringApplication.run(AppSearch.class, args);
	}
	
	@Bean
	public IdWorker idWorker () {
		return new IdWorker(1, 1);
	}
}
