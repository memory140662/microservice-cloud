package com.demo.springcloud;


import com.demo.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
public class DeptConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApplication.class, args);
    }
}
