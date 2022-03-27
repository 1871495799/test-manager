package com.manager.controller;
import com.manager.entity.Cases;
import com.manager.service.CasesService;
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
@RequestMapping("/cases")
public class CasesController {

    @Autowired
    private CasesService bookService;

    @ApiOperation("用例搜索列表")
    @PostMapping("/list")
    public R getCaseList(@RequestBody PageIn pageIn) {
        if (pageIn == null) {
            return R.fail(CodeEnum.PARAM_ERROR);
        }
        return R.success(CodeEnum.SUCCESS,bookService.getCaseList(pageIn));
    }

    @ApiOperation("添加")
    @PostMapping("/add")
    public R addCase(@RequestBody Cases cases) {
        return R.success(CodeEnum.SUCCESS,bookService.addCase(cases));
    }

    @ApiOperation("编辑")
    @PostMapping("/update")
    public R modifyCase(@RequestBody Cases cases) {
        return R.success(CodeEnum.SUCCESS,bookService.updateCase(cases));
    }


    @ApiOperation("详情")
    @GetMapping("/detail")
    public R CaseDetail(Integer id) {
        return R.success(CodeEnum.SUCCESS,bookService.findCaseById(id));
    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    public R delCase(Integer id) {
        bookService.deleteCase(id);
        return R.success(CodeEnum.SUCCESS);
    }

}
