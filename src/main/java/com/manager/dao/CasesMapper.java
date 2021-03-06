package com.manager.dao;
import com.manager.entity.Cases;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

/**
 * @Description 用例
 */
@Mapper
@Component
public interface CasesMapper {

    /**
     * 模糊分页查询用户
     * @param keyword 关键字
     * @return
     */
    List<Cases> findCaseListByLike(String keyword);

    /**
     * 编辑用户
     * @param map
     * @return
     */
    int updateCase(Map<String, Object> map);
}
