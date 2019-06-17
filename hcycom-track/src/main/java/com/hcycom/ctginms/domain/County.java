package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: County
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/4/17 13:41
 **/
@Entity
@Table(name = "county")
public class County {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountycode() {
        return countycode;
    }

    public void setCountycode(String countycode) {
        this.countycode = countycode;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCountyname() {
        return countyname;
    }

    public void setCountyname(String countyname) {
        this.countyname = countyname;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    @Id
    @Column(name="id")
    @ApiModelProperty(value="id主键")
    private int id;

    @Column(name="countycode")
    @ApiModelProperty(value="区县编码")
    private String countycode;

    @Column(name="projectcode")
    @ApiModelProperty(value="所属项目编码")
    private String projectcode;

    @Column(name="state")
    @ApiModelProperty(value="状态")
    private int state;

    @Column(name="countyname")
    @ApiModelProperty(value="区县名称")
    private String countyname;

    @Column(name="creattime")
    @ApiModelProperty(value="穿件时间")
    private String creattime;
}
