package com.example.annotation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("yuwenrong.annotation")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

}
