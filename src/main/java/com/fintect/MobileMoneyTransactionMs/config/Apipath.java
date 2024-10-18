package com.fintect.MobileMoneyTransactionMs.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "api.microservices")
@Component
public class Apipath {
    private String name ;
    private String baseurl ;
    private String bankCharge;

    public String getBankCharge() {
        return bankCharge;
    }

    public void setBankCharge(String bankCharge) {
        this.bankCharge = bankCharge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }
}
