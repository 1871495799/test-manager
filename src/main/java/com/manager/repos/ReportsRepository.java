package com.manager.repos;

import com.manager.entity.Cases;
import com.manager.entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 书籍
 * @Date 2020/7/14 16:12
 * @Author by 尘心
 */
@Repository
public interface ReportsRepository extends JpaRepository<Reports,Integer> {

}
