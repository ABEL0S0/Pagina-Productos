package com.e.comerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.e.comerce.api.model")
public class ComerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComerceApplication.class, args);
    }

}
