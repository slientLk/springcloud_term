package com.ljw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.inventory.entity")
public class FundsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FundsApplication.class,args);
    }
}
