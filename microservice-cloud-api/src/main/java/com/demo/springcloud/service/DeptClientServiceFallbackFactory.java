package com.demo.springcloud.service;

import com.demo.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("Dept not found from factory")
                        .setDbSource("no this datasource in MySQL");
            }

            @Override
            public List<Dept> list() {
                return Collections.emptyList();
            }
        };
    }
}
