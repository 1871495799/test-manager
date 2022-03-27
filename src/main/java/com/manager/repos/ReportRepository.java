package com.manager.repos;

import com.manager.entity.Report;
import com.manager.entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 书籍
 * @Date 2020/7/14 16:12
 * @Author by 曾辉
 */
@Repository
public interface ReportRepository extends JpaRepository<Report,Integer> {

}
