package com.manager.service;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.manager.dao.CasesMapper;
import com.manager.entity.Cases;
import com.manager.repos.CasesRepository;
import com.manager.util.vo.CasesOut;
import com.manager.util.vo.PageOut;
import com.manager.util.ro.PageIn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description 用例业务类
 */
@Service
public class CasesService {

    @Autowired
    private CasesRepository bookRepository;

    @Autowired
    private CasesMapper casesMapper;


    /**
     * 添加用户
     * @param Cases 用例
     * @return 返回添加的用例
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
     * 用例详情
     * @param id 主键
     * @return 用例详情
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

    /**
     * 删除用例
     * @param id 主键
     * @return true or false
     */
    public void deleteCase(Integer id) {
        bookRepository.deleteById(id);
    }


    /**
     * 用例搜索查询(mybatis 分页)
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
