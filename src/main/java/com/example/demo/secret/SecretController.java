package com.example.demo.secret;


import cn.hutool.core.bean.BeanUtil;
import com.example.demo.annotation.OpenDecrypt;
import com.example.demo.annotation.OpenEncrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ycd0075
 * @date 2024-02-06 11:29
 */
@RestController
@RequestMapping(value = "/test")
public class SecretController {


    @OpenEncrypt
    @PostMapping("/testEncrypt")
    public SecretVO testEncrypt(@RequestBody SecretDto testDto) {
        SecretVO testVo = new SecretVO();
        BeanUtil.copyProperties(testDto, testVo);
        return testVo;
    }


    @OpenDecrypt
    @PostMapping("/testDecrypt")
    public SecretVO testDecrypt(@RequestBody SecretDto testDto) {
        SecretVO testVo = new SecretVO();
        BeanUtil.copyProperties(testDto, testVo);
        return testVo;
    }
}
