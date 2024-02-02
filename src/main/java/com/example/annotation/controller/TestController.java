package com.example.annotation.controller;

import com.example.annotation.annotation.MyAnnotation;
import com.example.annotation.domain.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @MyAnnotation(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"白名单！\"}")
    @RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId) {
        return new UserInfo("user:" + userId, 19, "chengdu");
    }

}
