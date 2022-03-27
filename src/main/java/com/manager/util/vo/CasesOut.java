package com.manager.util.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 图书出参对象
 */
@Data
public class CasesOut {

    @ApiModelProperty("书籍ID")
    private Integer id;

    @ApiModelProperty("请求方式")
    private String method;

    @ApiModelProperty("用例名称")
    private String name;

    @ApiModelProperty("作者")
    private String author;


    @ApiModelProperty("请求参数")
    private String json;

    @ApiModelProperty("项目")
    private String project;

    @ApiModelProperty("请求地址")
    private String url;

    @ApiModelProperty("分类")
    private String type;

    @ApiModelProperty("创建时间")
    private String createTime;
}
