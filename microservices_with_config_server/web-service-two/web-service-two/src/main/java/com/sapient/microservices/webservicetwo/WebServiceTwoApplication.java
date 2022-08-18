package com.sapient.microservices.webservicetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WebServiceTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceTwoApplication.class, args);
	}

}
