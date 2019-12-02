package com.demo.springcloud.service.impl;

import com.demo.springcloud.entities.Dept;
import com.demo.springcloud.repositories.DeptRepository;
import com.demo.springcloud.service.DeptService;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Data
@RequiredArgsConstructor
@Service("deptService")
@Transactional
public class DeptServiceImpl implements DeptService {

    @NonNull
    private DeptRepository deptRepository;

    @Override
    public boolean add(Dept dept) {
        return deptRepository.addDept(dept) != 0;
    }

    @Override
    public Dept get(Long id) {
        return deptRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dept> list() {
        return deptRepository.findAll();
    }
}
