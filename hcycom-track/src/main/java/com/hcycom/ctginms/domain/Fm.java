package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Fm")
public class Fm {
    @Id
    @Column(name = "id")
    @ApiModelProperty(value="id主键")
    private int id;

    @Column(name = "pid")
    @ApiModelProperty(value="点位编码")
    private String pid;

    @Column(name = "fnName")
    @ApiModelProperty(value="文件名称")
    private String fnName;

    @Column(name = "fnUrl")
    @ApiModelProperty(value="文件路径")
    private String fnUrl;

    @Column(name = "time")
    @ApiModelProperty(value="文件上传时间")
    private String time;

    @Column(name = "reportcode")
    @ApiModelProperty(value="文件所属名称")
    private String reportcode;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFnUrl() {
        return fnUrl;
    }

    public void setFnUrl(String fnUrl) {
        this.fnUrl = fnUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFnName() {
        return fnName;
    }

    public void setFnName(String fnName) {
        this.fnName = fnName;
    }

    public String getReportcode() {
        return reportcode;
    }

    public void setReportcode(String reportcode) {
        this.reportcode = reportcode;
    }

    @Override
    public String toString() {
        return "Fm{" +
            "id=" + id +
            ", pid='" + pid + '\'' +
            ", fnName='" + fnName + '\'' +
            ", fnUrl='" + fnUrl + '\'' +
            ", time='" + time + '\'' +
            ", reportcode='" + reportcode + '\'' +
            '}';
    }
}
