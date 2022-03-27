package com.manager.repos;

import com.manager.entity.Suites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @Description 测试计划 jpa查询
 * @Date 2022/3/27 16:14
 * @Author by 曾辉
 */
@Repository
public interface SuitesRepository extends JpaRepository<Suites,Integer>{

}
