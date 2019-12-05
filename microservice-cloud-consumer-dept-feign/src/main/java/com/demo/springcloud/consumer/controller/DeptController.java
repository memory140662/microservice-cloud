package com.demo.springcloud.consumer.controller;

import com.demo.springcloud.entities.Dept;
import com.demo.springcloud.service.DeptClientService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@SuppressWarnings({"unchecked"})
public class DeptController {

    @NonNull private DeptClientService deptClientService;


    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable Long id) {
        return deptClientService.get(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        return deptClientService.list();
    }

//    @GetMapping("/consumer/dept/discovery")
////    public Object discovery() {
////    }
}
