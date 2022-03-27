package com.manager.dao;

import com.manager.entity.Reports;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @Description 报告
 */
@Mapper
@Component
public interface ReportsMapper {
    List<Reports> findReportListByLike(String keyword);

    @Select("select * from reports where user_id = #{userId},name = #{name},author = #{author},project = #{project},suite_id = #{suiteId},user_name = #{userName},create_time = #{createTime}")
    Reports findReports(Reports reports);

    //    @Select("select * from suites where user_id = #{userId} and book_id = #{bookId}")
//    Suites findBorrowByUserIdAndBookId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);
}