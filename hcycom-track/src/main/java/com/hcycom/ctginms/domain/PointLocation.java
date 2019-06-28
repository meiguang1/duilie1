package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PointLocation")
public class PointLocation {
    @Id
    @Column(name = "id")
    @ApiModelProperty(value="id主键")
    private int id;

    @Column(name = "pid")
    @ApiModelProperty(value="点位编码")
    private String pid;

    @Column(name = "countycode")
    @ApiModelProperty(value="区县编码")
    private String countycode;

    @Column(name = "countyname")
    @ApiModelProperty(value="区县名称")
    private String countyname;

    @Column(name = "eventcode")
    @ApiModelProperty(value="事件编码")
    private String eventcode;

    @Column(name = "healthForm")
    @ApiModelProperty(value="体检的上传路径")
    private String healthForm;

    @Column(name = "creattime")
    @ApiModelProperty(value="文件上传时间")
    private String creattime;

    @Column(name = "personCount")
    @ApiModelProperty(value="文件上传名")
    private String personCount;


    @Column(name = "predict_number")
    @ApiModelProperty(value="预计调查人数")
    private int predict_number;

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

    public String getCountycode() {
        return countycode;
    }

    public void setCountycode(String countycode) {
        this.countycode = countycode;
    }

    public String getCountyname() {
        return countyname;
    }

    public void setCountyname(String countyname) {
        this.countyname = countyname;
    }

    public String getEventcode() {
        return eventcode;
    }

    public void setEventcode(String eventcode) {
        this.eventcode = eventcode;
    }

    public String getHealthForm() {
        return healthForm;
    }

    public void setHealthForm(String healthForm) {
        this.healthForm = healthForm;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getPersonCount() {
        return personCount;
    }

    public void setPersonCount(String personCount) {
        this.personCount = personCount;
    }

    public int getPredict_number() {
        return predict_number;
    }

    public void setPredict_number(int predict_number) {
        this.predict_number = predict_number;
    }

    @Override
    public String toString() {
        return "PointLocation{" +
            "id=" + id +
            ", pid='" + pid + '\'' +
            ", countycode='" + countycode + '\'' +
            ", countyname='" + countyname + '\'' +
            ", eventcode='" + eventcode + '\'' +
            ", healthForm='" + healthForm + '\'' +
            ", creattime='" + creattime + '\'' +
            ", personCount='" + personCount + '\'' +
            ", predict_number=" + predict_number +
            '}';
    }
}
