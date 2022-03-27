package com.manager.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description 报告实体类
 * @Date 2022/3/25 15:58
 * @Author by 曾辉
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "reports")
public class Reports {

    @ApiModelProperty("主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty("测试计划名称")
    private String name;

    @ApiModelProperty("作者")
    private String author;


    @ApiModelProperty("项目名")
    private String project;


    @ApiModelProperty("关联的测试计划")
    private Integer suiteId;


    @ApiModelProperty("用户")
    private Integer userId;

    @ApiModelProperty("操作人名称")
    private String userName;


    @ApiModelProperty("创建时间")
    private Date createTime;

}