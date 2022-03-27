package com.manager.util.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description 报告详细实体类
 * @Date 2022/3/25 15:58
 * @Author by 曾辉
 */
@Data
public class ReportOut {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("运行人")
    private String author;


    @ApiModelProperty("请求方法")
    private String method;

    @ApiModelProperty("用例名称")
    private String name;

    @ApiModelProperty("项目")
    private String project;

    @ApiModelProperty("项目类型")
    private String type;

    @ApiModelProperty("关联的报告")
    private Integer reportId;

    @ApiModelProperty("运行结果")
    private String status;

    @ApiModelProperty("创建时间")
    private String createTime;


    @ApiModelProperty("请求地址")
    private String url;


    @ApiModelProperty("请求入参")
    private String json;

}