package com.example.monitoringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class MonitoringDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitoringDemoApplication.class, args);
    }
}

