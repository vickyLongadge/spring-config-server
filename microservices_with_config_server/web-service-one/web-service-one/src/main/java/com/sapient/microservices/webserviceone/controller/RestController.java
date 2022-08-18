package com.sapient.microservices.webserviceone.controller;

import com.sapient.microservices.webserviceone.configuration.ConfigurationProperties;
import com.sapient.microservices.webserviceone.model.Limits;
import com.sapient.microservices.webserviceone.model.ServiceExchange;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    @Autowired
    ConfigurationProperties properties;

    @Autowired
    Environment environment;

    Logger logger = LoggerFactory.getLogger(RestController.class);

    @GetMapping("/microservice1")
    public Limits api1()
    {
        return new Limits(properties.getMinimum(), properties.getMaximum());
    }

//    http://localhost:8000/service-exchange/from/USD/to/INR
//    @Retry(name = "service-exchange-retry")
    @CircuitBreaker(name = "service-exchange-retry", fallbackMethod = "serviceExchangeFallBack")
//    @RateLimiter(name = "service-exchange-retry")
    @GetMapping("/service-exchange/from/{from}/to/{to}")
    public ServiceExchange serviceExchange(
            @PathVariable String from,
            @PathVariable String to)
    {
        logger.info("service-exchange started-->{}-{}",from,to);
//        int i = 1/0;
        return new ServiceExchange(from,to, BigDecimal.valueOf(65),environment.getProperty("server.port"), HttpStatus.OK.value());
    }

    public ServiceExchange serviceExchangeFallBack(Exception e)
    {
        logger.info("-------------------service-exchange Fallback started-------------------");
        return new ServiceExchange("FallBack","FallBack", BigDecimal.valueOf(65),environment.getProperty("server.port"), HttpStatus.OK.value());

    }
}
