package com.example.springarcanjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringArcanjoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringArcanjoApplication.class, args);
    }

}
