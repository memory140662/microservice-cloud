package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EntityScan("com.demo.springcloud.entities")
@EnableDiscoveryClient
public class DeptProviderConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderConfigApplication.class, args);
    }
}
