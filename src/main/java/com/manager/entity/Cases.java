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
 * @Description 用例实体类
 * @Date 2022/3/25 15:58
 * @Author by 曾辉
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "cases")
public class Cases {

    @ApiModelProperty("主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Date createTime;

    // json字符串： {"isbn":"isbn","name":"name","author":"author","pages":"pages","translate":"translate","publish":"publish","price":"price","size":"size","type":"type","publishTime":"publishTime"}
}
