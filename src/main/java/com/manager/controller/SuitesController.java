package com.manager.controller;

import com.manager.entity.Suites;
import com.manager.entity.Users;
import com.manager.service.SuitesService;
import com.manager.util.R;
import com.manager.util.consts.Constants;
import com.manager.util.http.CodeEnum;
import com.manager.util.ro.PageIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 测试计划管理
 */
@Api(tags = "测试计划管理")
@RestController
@RequestMapping("/suites")
public class SuitesController {

    @Autowired
    private SuitesService suitesService;


    @ApiOperation("测试计划列表")
    @PostMapping("/list")
    public R getSuiteList(@RequestBody PageIn pageIn) {
        if (pageIn == null) {
            return R.fail(CodeEnum.PARAM_ERROR);
        }
        return R.success(CodeEnum.SUCCESS,suitesService.getSuiteList(pageIn));
    }

    @ApiOperation("添加测试计划")
    @PostMapping("/add")
    public R addSuite(@RequestBody Suites suites) {
        suitesService.addSuite(suites);
        return R.success(CodeEnum.SUCCESS,Constants.OK);
    }

    @ApiOperation("编辑测试计划")
    @PostMapping("/update")
    public R modifySuites(@RequestBody Suites suites) {
        return R.success(CodeEnum.SUCCESS,suitesService.updateSuites(suites));
    }


    @ApiOperation("测试计划详情")
    @GetMapping("/detail")
    public R SuiteDetail(Integer id) {
        return R.success(CodeEnum.SUCCESS,suitesService.findById(id));
    }

    @ApiOperation("删除测试计划")
    @GetMapping("/delete")
    public R deleteSuite(Integer id) {
        suitesService.deleteSuite(id);
        return R.success(CodeEnum.SUCCESS);
    }


    @ApiOperation("删除测试计划")
    @GetMapping("/run")
    public R runSuite(Integer id, Integer userId) {
        suitesService.runSuite(id,userId);
        return R.success(CodeEnum.SUCCESS,Constants.OK);
    }



}
