package com.demo.springcloud.controller;

import com.demo.springcloud.entities.Dept;
import com.demo.springcloud.service.DeptService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeptController {
    @NonNull
    private DeptService deptService;

    @NonNull
    private DiscoveryClient discoveryClient;

    @PostMapping("dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping("dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.get(id);
    }

    @GetMapping("dept/list")
    public List<Dept> list() {
        return deptService.list();
    }

    @GetMapping("dept/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("************** " + list);

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("microservicecloud-dept");
        for (ServiceInstance serviceInstance: serviceInstances) {
            System.out.println(serviceInstance.getServiceId() +"\t" + serviceInstance.getHost() + "\t" + serviceInstance.getUri());
        }

        return discoveryClient;
    }
}
