package com.example.annotation.config;


public class ConfigManager {

    private String userStr;

    public ConfigManager(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return this.userStr.split(separatorChar);
    }

}
