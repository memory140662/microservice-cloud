package com.demo.springcloud;

import com.demo.springcloud.entities.Dept;
import com.demo.springcloud.service.DeptService;
import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DeptProviderApplicationTest {

    @Autowired
    DeptService deptService;

    @Value("${spring.profiles}")
    String env;

    @Before
    public void before() {
        System.out.println("****************** Env: " + env);
    }

    @Test
    public void save() {
        deptService.add(new Dept(null, "科技部", null));
    }

    @Test
    public void list() {
        val data = deptService.list();
        Assert.assertTrue(data.size() > 0);
    }
}
