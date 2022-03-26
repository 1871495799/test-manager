package com.book.manager.service;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.book.manager.dao.CasesMapper;
import com.book.manager.entity.Cases;
import com.book.manager.repos.BookRepository;
import com.book.manager.util.vo.CasesOut;
import com.book.manager.util.vo.PageOut;
import com.book.manager.util.ro.PageIn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description 图书业务类
 */
@Service
public class CasesService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CasesMapper casesMapper;


    /**
     * 添加用户
     * @param book 图书
     * @return 返回添加的图书
     */
    public Cases addCase(Cases book) {
        return bookRepository.saveAndFlush(book);
    }

    /**
     * 编辑用户
     * @param cases 用例对象
     * @return true or false
     */
    public boolean updateCase(Cases cases) {
        return casesMapper.updateCase(BeanUtil.beanToMap(cases))>0;
    }

    /**
     * 图书详情
     * @param id 主键
     * @return 图书详情
     */
    public CasesOut findCaseById(Integer id) {
        Optional<Cases> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            Cases book = optional.get();
            CasesOut out = new CasesOut();
            BeanUtil.copyProperties(book,out);
            out.setCreateTime(DateUtil.format(book.getCreateTime(),"yyyy-MM-dd"));
            return out;
        }
        return null;
    }

    public Cases findCase(Integer id) {
        Optional<Cases> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
//
//    /**
//     * ISBN查询
//     * @param isbn
//     * @return
//     */
//    public CasesOut findBookByIsbn(String isbn) {
//        Cases book = bookRepository.findByMethod(isbn);
//        CasesOut out = new CasesOut();
//        if (book == null) {
//            return out;
//        }
//        BeanUtil.copyProperties(book,out);
//        out.setCreateTime(DateUtil.format(book.getCreateTime(),"yyyy-MM-dd"));
//        return out;
//    }

    /**
     * 删除图书
     * @param id 主键
     * @return true or false
     */
    public void deleteCase(Integer id) {
        bookRepository.deleteById(id);
    }


    /**
     * 图书搜索查询(mybatis 分页)
     * @param pageIn
     * @return
     */
    public PageOut getCaseList(PageIn pageIn) {

        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        List<Cases> list = casesMapper.findCaseListByLike(pageIn.getKeyword());
        PageInfo<Cases> pageInfo = new PageInfo<>(list);

        List<CasesOut> casesOuts = new ArrayList<>();
        for (Cases book : pageInfo.getList()) {
            CasesOut out = new CasesOut();
            BeanUtil.copyProperties(book,out);
            out.setCreateTime(DateUtil.format(book.getCreateTime(),"yyyy-MM-dd"));
            casesOuts.add(out);
        }

        // 自定义分页返回对象
        PageOut pageOut = new PageOut();
        pageOut.setList(casesOuts);
        pageOut.setTotal((int)pageInfo.getTotal());
        pageOut.setCurrPage(pageInfo.getPageNum());
        pageOut.setPageSize(pageInfo.getPageSize());
        return pageOut;
    }


}
