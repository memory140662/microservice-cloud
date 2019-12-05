package com.demo.springcloud.repositories;

import com.demo.springcloud.entities.Dept;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptRepository extends CrudRepository<Dept, Long> {
    List<Dept> findAll();

    @Modifying
    @Query(
            nativeQuery = true,
            value = "INSERT INTO dept (dname, db_source) VALUES (:#{#dept.dname}, DATABASE())"
    )
    int addDept(@Param("dept") Dept dept);
}

