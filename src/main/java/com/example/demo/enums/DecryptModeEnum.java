package com.example.demo.enums;

import cn.hutool.core.util.StrUtil;
import com.example.demo.properties.ApiEncryptProperties;
import com.example.demo.properties.RSAProperties;
import com.example.demo.utils.AESUtil;
import com.example.demo.utils.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

@Slf4j
public enum DecryptModeEnum {

    RSA {
        @Override
        public String decrypt(String value, ApiEncryptProperties apiEncryptProperties) {
            RSAProperties rsaProperties = apiEncryptProperties.getRsa();
            String privateKey = rsaProperties.getPrivateKey();
            StringBuilder decryptStr = new StringBuilder();
            try {
                if (StrUtil.isAllBlank(privateKey)) {
                    throw new NullPointerException("privateKey is not null !");
                }
                value = value.replaceAll(" ", "+");
                if (!StringUtils.isEmpty(value)) {
                    String[] split = value.split("\\|");
                    for (String item : split) {
                        item = new String(RSAUtil.decrypt(RSAUtil.decode(item), rsaProperties.getPrivateKey()), StandardCharsets.UTF_8);
                        decryptStr.append(item);
                    }
                }
            } catch (Exception e) {
                log.error("RSA Dencrypt Exception", e);
            }
            return decryptStr.toString();
        }
    },

    AES {
        @Override
        public String decrypt(String value, ApiEncryptProperties apiEncryptProperties) {
            return AESUtil.decryptUtilsFunc(value, apiEncryptProperties.getAes().getKey());
        }
    };

    public abstract String decrypt(String value, ApiEncryptProperties apiEncryptProperties);
}
