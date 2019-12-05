package com.demo.springcloud.controller;

import com.demo.springcloud.entities.Dept;
import com.demo.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeptController {
    @NonNull private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "getFallbackMethod")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("Dept not found.");
        }
        return dept;
    }

    public Dept getFallbackMethod(Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("Dept not found")
                .setDbSource("no this datasource in MySQL");
    }


    @GetMapping("/dept/list")
    @HystrixCommand(fallbackMethod = "listFallbackMethod")
    public List<Dept> list() {
        return deptService.list();
    }

    public List<Dept> listFallbackMethod() {
        return Collections.emptyList();
    }


    @PostMapping("/dept/add")
    @HystrixCommand(fallbackMethod = "addFallbackMethod")
    public boolean add(Dept dept) {
        return deptService.add(dept);
    }

    public boolean addFallbackMethod(Dept dept) {
        return false;
    }

}
