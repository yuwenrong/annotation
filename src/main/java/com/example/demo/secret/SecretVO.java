package com.example.demo.secret;

import com.example.demo.annotation.DecryptField;
import com.example.demo.enums.DecryptModeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ycd0075
 * @date 2024-02-06 11:31
 */
@Data
public class SecretVO implements Serializable {

    private Date data;

    @DecryptField(decryptMode = DecryptModeEnum.RSA)
    private String message;
}
