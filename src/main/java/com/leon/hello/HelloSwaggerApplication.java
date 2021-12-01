package com.leon.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * swagger 访问地址 http://localhost:8080/swagger-ui.html
 */
@SpringBootApplication
public class HelloSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSwaggerApplication.class, args);
    }

}
