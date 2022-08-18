package com.sapient.microservices.webserviceone.model;

import java.math.BigDecimal;

public class ServiceExchange {

    String from;
    String to;
    BigDecimal value;
    String environment;
    Integer status;

    public ServiceExchange() {
    }

    public ServiceExchange(String from, String to, BigDecimal value, String environment, Integer status) {
        this.from = from;
        this.to = to;
        this.value = value;
        this.environment = environment;
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
