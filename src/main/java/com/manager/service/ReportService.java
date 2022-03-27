package com.manager.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.dao.ReportMapper;
import com.manager.dao.ReportsMapper;
import com.manager.entity.Report;
import com.manager.entity.Reports;
import com.manager.repos.ReportRepository;
import com.manager.repos.ReportsRepository;
import com.manager.util.ro.PageIn;
import com.manager.util.vo.PageOut;
import com.manager.util.vo.ReportOut;
import com.manager.util.vo.ReportsOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description 测试报告类
 */
@Service
public class ReportService {


    @Autowired
    private ReportsMapper reportsMapper;

    @Autowired
    private ReportMapper reportMapper;


    @Autowired
    private ReportsRepository reportsRepository;

    @Autowired
    private ReportRepository reportRepository;


    /**
     * 图书搜索查询(mybatis 分页)
     * @param pageIn
     * @return
     */
    public PageOut getReportList(PageIn pageIn) {
        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        List<Reports> list = reportsMapper.findReportListByLike(pageIn.getKeyword());
        PageInfo<Reports> pageInfo = new PageInfo<>(list);

        List<ReportsOut> casesOuts = new ArrayList<>();
        for (Reports reports : pageInfo.getList()) {
            ReportsOut out = new ReportsOut();
            BeanUtil.copyProperties(reports,out);
            out.setCreateTime(DateUtil.format(reports.getCreateTime(),"yyyy-MM-dd"));
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


    /**
     * 删除
     */
    public void deleteReport(Integer id) {
        reportsRepository.deleteById(id);
    }

    /**
     * 添加
     */
    public Reports addReports(Reports reports) {
        return reportsRepository.saveAndFlush(reports);
    }

    /**
     * 查找
     */
    public Reports findReports(Reports reports) {
        return reportsMapper.findReports(reports);
    }


    /**
     * 图书搜索查询(mybatis 分页)
     * @param pageIn
     * @return
     */
    public Object getReportDetailList(PageIn pageIn) {
        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        List<Report> list = reportMapper.findReportDetailListByLike(pageIn.getReportId());
        PageInfo<Report> pageInfo = new PageInfo<>(list);

        List<ReportOut> casesOuts = new ArrayList<>();
        for (Report reports : pageInfo.getList()) {
            ReportOut out = new ReportOut();
            BeanUtil.copyProperties(reports,out);
            out.setCreateTime(DateUtil.format(reports.getCreateTime(),"yyyy-MM-dd"));
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



    /**
     * 添加
     */
    public Report addReport(Report report) {
        return reportRepository.saveAndFlush(report);
    }
}
