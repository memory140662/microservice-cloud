package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EntityScan("com.demo.springcloud.entities")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DeptProviderHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrixApplication.class, args);
    }
}
