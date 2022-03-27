package com.manager.dao;

import com.manager.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 报告
 */
@Mapper
@Component
public interface ReportMapper {

    List<Report> findReportDetailListByLike(String keyword);
}