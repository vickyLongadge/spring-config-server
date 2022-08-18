package com.sapient.microservices.webservicetwo.model;

import java.math.BigDecimal;

public class ServiceConversion {

    String from;
    String to;
    BigDecimal value;
    String environment;
    BigDecimal quantity;
    BigDecimal conversionResult;
    Integer status;

    public ServiceConversion() {
    }

    public ServiceConversion(String from, String to, BigDecimal value, String environment, BigDecimal quantity, BigDecimal conversionResult, Integer status) {
        this.from = from;
        this.to = to;
        this.value = value;
        this.environment = environment;
        this.quantity = quantity;
        this.conversionResult = conversionResult;
        this.status = status;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(BigDecimal conversionResult) {
        this.conversionResult = conversionResult;
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
