package com.manager.dao;

import com.manager.entity.Suites;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @Description 测试计划管理
 */
@Mapper
@Component
public interface SuitesMapper {
    @Update("update suites set user_id = #{userId},name = #{name},author = #{author},project = #{project},case_id = #{caseId},update_time = #{updateTime} where id = #{id}")
    int updateSuites(Suites suites);

//    @Select("select * from suites where user_id = #{userId} and book_id = #{bookId}")
//    Suites findBorrowByUserIdAndBookId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    List<Suites> findSuiteListByLike(String keyword);
}