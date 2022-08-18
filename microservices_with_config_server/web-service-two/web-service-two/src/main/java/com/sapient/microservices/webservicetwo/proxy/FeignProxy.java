package com.sapient.microservices.webservicetwo.proxy;

import com.sapient.microservices.webservicetwo.model.ServiceConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "web-service-one", url = "http://localhost:8000")
@FeignClient(name = "web-service-one")
public interface FeignProxy {

    @GetMapping("/service-exchange/from/{from}/to/{to}")
    public ServiceConversion serviceExchange(
            @PathVariable String from,
            @PathVariable String to
    );

}
