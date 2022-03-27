package com.manager.controller;
import com.manager.entity.Cases;
import com.manager.service.CasesService;
import com.manager.service.ReportService;
import com.manager.util.R;
import com.manager.util.http.CodeEnum;
import com.manager.util.ro.PageIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 用例管理
 */
@Api(tags = "用例管理")
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @ApiOperation("用例搜索列表")
    @PostMapping("/list")
    public R getReportList(@RequestBody PageIn pageIn) {
        if (pageIn == null) {
            return R.fail(CodeEnum.PARAM_ERROR);
        }
        return R.success(CodeEnum.SUCCESS,reportService.getReportList(pageIn));
    }


    @ApiOperation("报告")
    @PostMapping("/report/list")
    public R getReportDetailList(@RequestBody PageIn pageIn) {
        if (pageIn == null) {
            return R.fail(CodeEnum.PARAM_ERROR);
        }
        return R.success(CodeEnum.SUCCESS,reportService.getReportDetailList(pageIn));
    }


    @ApiOperation("删除")
    @GetMapping("/delete")
    public R delCase(Integer id) {
        reportService.deleteReport(id);
        return R.success(CodeEnum.SUCCESS);
    }

}
