package com.example.demo.aspect;

import cn.hutool.core.util.ReflectUtil;
import com.example.demo.annotation.EncryptField;
import com.example.demo.enums.EncryptModeEnum;
import com.example.demo.properties.ApiEncryptProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author dp
 * @Description 解密切面逻辑
 * @date 2023/5/16 9:29
 */
@Slf4j
@Aspect
@Component
public class EncryptAspect {

    @Autowired
    private ApiEncryptProperties apiEncryptProperties;

    @Pointcut("@annotation(com.example.demo.annotation.OpenEncrypt)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        //加密（VO）
        return encrypt(joinPoint);
    }

    public Object encrypt(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            Object obj = joinPoint.proceed();
            if (obj != null) {
                if (obj instanceof Serializable) {
                    result = encryptData(obj);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }

    private Object encryptData(Object obj) throws IllegalAccessException {
        if (Objects.isNull(obj)) {
            return null;
        }
        if (obj instanceof List) {
            encryptList(obj);
        } else {
            encryptObject(obj);
        }
        return obj;
    }

    private void encryptObject(Object object) throws IllegalAccessException {
        Field[] allFields = ReflectUtil.getFields(object.getClass());
        for (Field field : allFields) {
            boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
            if (hasSecureField) {
                field.setAccessible(true);
                String realValue = (String) field.get(object);
                EncryptField encryptField = field.getAnnotation(EncryptField.class);
                EncryptModeEnum encryptModeEnum = encryptField.encryptMode();
                String value = encryptModeEnum.encrypt(realValue, apiEncryptProperties);
                field.set(object, value);
            }
        }
    }

    private void encryptList(Object obj) throws IllegalAccessException {
        List<Object> result = new ArrayList<>();
        if (obj instanceof ArrayList) {
            result.addAll((List<?>) obj);
        }
        for (Object object : result) {
            encryptObject(object);
        }
    }
}
