package com.example.annotation.domain;

import lombok.Data;

@Data
public class UserInfo {

    private String code;
    private String info;
    private String name;
    private Integer age;
    private String address;

    public UserInfo() {

    }

    public UserInfo(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public UserInfo(String name, Integer age, String address) {
        this.code = "0000";
        this.info = "success";
        this.name = name;
        this.age = age;
        this.address = address;
    }


}
