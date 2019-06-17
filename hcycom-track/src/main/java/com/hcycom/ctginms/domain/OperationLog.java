package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: operationLog
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/11 16:43
 **/
@Entity
@Table(name = "operation_log")
public class OperationLog {

    @Id
    @Column(name="id")
    @ApiModelProperty(value="id主键")
    private int id;

    @Column(name="describe")
    @ApiModelProperty(value="操作的表名")
    private String describe;

    @Column(name="operation_time")
    @ApiModelProperty(value="操作时间")
    private String operation_time;

    @Column(name="operation_code")
    @ApiModelProperty(value="操作员编号")
    private String operation_code;

    @Column(name="operation_txt")
    @ApiModelProperty(value="操作描述")
    private String operation_txt;

    @Column(name="operation_name")
    @ApiModelProperty(value="操作员姓名")
    private String operation_name;

    @Column(name="project_code")
    @ApiModelProperty(value="项目编码")
    private String project_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getOperation_time() {
        return operation_time;
    }

    public void setOperation_time(String operation_time) {
        this.operation_time = operation_time;
    }

    public String getOperation_code() {
        return operation_code;
    }

    public void setOperation_code(String operation_code) {
        this.operation_code = operation_code;
    }

    public String getOperation_txt() {
        return operation_txt;
    }

    public void setOperation_txt(String operation_txt) {
        this.operation_txt = operation_txt;
    }

    public String getOperation_name() {
        return operation_name;
    }

    public void setOperation_name(String operation_name) {
        this.operation_name = operation_name;
    }

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getEvent_code() {
        return event_code;
    }

    public void setEvent_code(String event_code) {
        this.event_code = event_code;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    @Column(name="project_name")
    @ApiModelProperty(value="项目名称")
    private String project_name;

    @Column(name="event_code")
    @ApiModelProperty(value="事件编码")
    private String event_code;

    @Column(name="event_name")
    @ApiModelProperty(value="事件名称")
    private String event_name;

}
