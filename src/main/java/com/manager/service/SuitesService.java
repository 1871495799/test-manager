package com.manager.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.manager.dao.SuitesMapper;
import com.manager.entity.*;
import com.manager.repos.SuitesRepository;
import com.manager.util.consts.Constants;
import com.manager.util.ro.PageIn;
import com.manager.util.vo.PageOut;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.util.vo.SuitesOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static com.manager.util.http.HttpBase.httpGet;
import static com.manager.util.http.HttpBase.httpPost;

/**
 * @Description 借阅管理
 */
@Service
public class SuitesService {

    @Autowired
    private SuitesRepository suitesRepository;

    @Autowired
    private SuitesMapper suitesMapper;

    @Autowired
    private CasesService casesService;


    @Autowired
    private ReportService reportService;

    @Autowired
    private UserService userService;


    /**
     * 添加
     * （添加事物）
     */
    @Transactional
    public Integer addSuite(Suites suites) {
        suitesRepository.saveAndFlush(suites);
        // 一切正常
        return Constants.OK;
    }


    /**
     * 详情
     */
    public Suites findById(Integer id) {
        Optional<Suites> optional = suitesRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * 编辑
     */
    public boolean updateSuites(Suites suites) {
        return suitesMapper.updateSuites(suites)>0;
    }


    /**
     * 删除
     */
    public void deleteSuite(Integer id) {
        suitesRepository.deleteById(id);
    }


    /**
     * 测试计划搜索查询(mybatis 分页)
     * @param pageIn
     * @return
     */
    public PageOut getSuiteList(PageIn pageIn) {

        PageHelper.startPage(pageIn.getCurrPage(),pageIn.getPageSize());
        List<Suites> list = suitesMapper.findSuiteListByLike(pageIn.getKeyword());
        PageInfo<Suites> pageInfo = new PageInfo<>(list);

        List<SuitesOut> bookOuts = new ArrayList<>();
        for (Suites suites : pageInfo.getList()) {
            SuitesOut out = new SuitesOut();
            BeanUtil.copyProperties(suites,out);
            out.setCreateTime(DateUtil.format(suites.getCreateTime(),"yyyy-MM-dd"));
            bookOuts.add(out);
        }

        // 自定义分页返回对象
        PageOut pageOut = new PageOut();
        pageOut.setList(bookOuts);
        pageOut.setTotal((int)pageInfo.getTotal());
        pageOut.setCurrPage(pageInfo.getPageNum());
        pageOut.setPageSize(pageInfo.getPageSize());
        return pageOut;
    }


    /**
     * 运行测试计划
     * @return
     */
//    @Transactional
    public void runSuite(Integer id, Integer userId) {
        Users user = userService.findUserById(userId);
        Suites suites = findById(id);
        String caseId=suites.getCaseId();
        String arr []=caseId.split(",");

        Reports reports=new Reports();
        BeanUtil.copyProperties(suites,reports);
        reports.setId(null);
        reports.setSuiteId(suites.getId());
        reports.setCreateTime(new Date());
        reports.setUserId(userId);
        reports.setUserName(user.getNickname());
        Reports reportsNew=reportService.addReports(reports);
        System.out.println(reportsNew);

        if(arr!=null){
            for (String idx:arr) {
                Cases cases= casesService.findCase(Integer.parseInt(idx));
                String url=cases.getUrl();
                String methode=cases.getMethod();
                String json=cases.getJson();
                ResponseEntity<String> responseEntity=null;

                Report report=new Report();

                if(methode.equals("POST")){
                    responseEntity= httpPost(url,json);
                }else {
                    responseEntity= httpGet(url);
                }

                int status=responseEntity.getStatusCodeValue();
                if(status==200){
                    String body=responseEntity.getBody();
                    System.out.println(body);
                    report.setStatus("成功");
                }else {
                    report.setStatus("失败");
                }

                BeanUtil.copyProperties(cases,report);
                report.setReportId(reportsNew.getId());
                reportService.addReport(report);
            }

        }


    }
}
