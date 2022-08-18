package com.sapient.microservices.webservicetwo.controller;

import com.sapient.microservices.webservicetwo.model.ServiceConversion;
import com.sapient.microservices.webservicetwo.proxy.FeignProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;
import java.math.BigDecimal;
import java.util.HashMap;

@org.springframework.web.bind.annotation.RestController
public class RestController {

//    @Value("${microservice2-response}")
//    String str;
Logger logger = LoggerFactory.getLogger(RestController.class);
    @Autowired
    Environment environment;

    @Autowired
    FeignProxy feignProxy;

//    @GetMapping("/microservice2")
//    public String api1() {
//        return str;
//    }

    //http://localhost:8000/service-conversion/from/USD/to/INR/quantity/10
    @GetMapping("/service-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ServiceConversion serviceConversion(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        HashMap<String, String> variables = new HashMap<>();
        variables.put("from", from);
        variables.put("to", to);
        ResponseEntity<ServiceConversion> responseEntity = new RestTemplate().getForEntity
                ("http://localhost:8000/service-exchange/from/{from}/to/{to}"
                        , ServiceConversion.class, variables);
        logger.info("service-conversion started-->{}-{}",from,to);
        ServiceConversion conversion = responseEntity.getBody();
        conversion.setQuantity(quantity);
        conversion.setConversionResult(quantity.multiply(conversion.getValue()));
        conversion.setEnvironment(environment.getProperty("server.port")+ " " +"Rest Template");
        conversion.setStatus(HttpStatus.OK.value());
        return conversion;
    }

    //http://localhost:8000/service-exchange-feign/from/USD/to/INR/quantity/10
    @GetMapping("/service-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public ServiceConversion serviceConversionFeign(
            @PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        logger.info("service-conversion-feign started-->{}-{}",from,to);
        ServiceConversion conversion = feignProxy.serviceExchange(from, to);
        conversion.setQuantity(quantity);
        conversion.setConversionResult(quantity.multiply(conversion.getValue()));
        conversion.setEnvironment(environment.getProperty("server.port")+ " " +"Feign");
        conversion.setStatus(HttpStatus.OK.value());
        return conversion;
    }

}
