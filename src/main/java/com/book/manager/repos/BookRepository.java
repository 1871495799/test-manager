package com.book.manager.repos;

import com.book.manager.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 书籍
 * @Date 2020/7/14 16:12
 * @Author by 尘心
 */
@Repository
public interface BookRepository extends JpaRepository<Cases,Integer> {

    /**
     * ISBN编码查询
     * @param isbn
     * @return
     */
    Cases findByMethod(String isbn);
}
