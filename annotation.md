---
title: annotation
emoji: 💼
category: /小书匠/工作
createDate: 2024-01-30
---


# 一、注解的使用

### *   自定义注解来标记某一些场景，作用到方法或者类
#### 1 记录日志
#### 2 权限控制
#### 3 返回指定的类型
  
举例：
```
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {

    String key() default "";

    String returnJson() default "";

}
```

# 二、切面

*   AOP方式做控制逻辑



# 三、记录日志

#### 1 记录特定注解的操作日志

  

# 四、权限管理
#### 1 加载配置
#### 2 读取配置

