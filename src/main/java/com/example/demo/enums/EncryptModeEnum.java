package com.example.demo.enums;

import cn.hutool.core.util.StrUtil;
import com.example.demo.properties.ApiEncryptProperties;
import com.example.demo.properties.RSAProperties;
import com.example.demo.utils.AESUtil;
import com.example.demo.utils.RSAUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum EncryptModeEnum {

    RSA {
        @Override
        public String encrypt(String value, ApiEncryptProperties apiEncryptProperties) {
            RSAProperties rsaProperties = apiEncryptProperties.getRsa();
            String publicKey = rsaProperties.getPublicKey();
            String encryptStr = null;
            try {
                if (StrUtil.isAllBlank(publicKey)) {
                    throw new NullPointerException("publicKey is not null !");
                }
                byte[] data = value.getBytes();
                byte[] encodedData = RSAUtil.encrypt(data, publicKey);
                encryptStr = RSAUtil.encode(encodedData);
            } catch (Exception e) {
                log.error("RSA Encrypt Exception", e);
            }
            return encryptStr;
        }
    },

    AES {
        @Override
        public String encrypt(String value, ApiEncryptProperties apiEncryptProperties) {
            return AESUtil.encryptUtilsFunc(value, apiEncryptProperties.getAes().getKey());
        }

    };

    public abstract String encrypt(String value, ApiEncryptProperties apiEncryptProperties);

}
