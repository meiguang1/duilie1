package com.hcycom.ctginms.domain;

import com.hcycom.test.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "researcher")
public class Researcher{
    @Id
    @Column(name = "id")
   // @ApiModelProperty(value="id主键")
    private int id;

    @Column(name = "eventcode")
    @ApiModelProperty(value="事件对象编码")
    private String eventcode;

    @Column(name = "researchcode")
    @ApiModelProperty(value="研究对象编码")
    private String researchcode;

    @Column(name = "age")
    @ApiModelProperty(value="研究对象的年龄")
    private int age;

    @Column(name = "sex")
    @ApiModelProperty(value="研究对象的性别")
    private String sex;

    @Column(name = "researchname")
    @ApiModelProperty(value="研究对象姓名")
    private String researchname;

    @Column(name = "position")
    @ApiModelProperty(value="所属中心（位置信息）")
    private String position;

    @Column(name = "projectcode")
    @ApiModelProperty(value="所属项目编码")
    private String projectcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventcode() {
        return eventcode;
    }

    public void setEventcode(String eventcode) {
        this.eventcode = eventcode;
    }

    public String getResearchcode() {
        return researchcode;
    }

    public void setResearchcode(String researchcode) {
        this.researchcode = researchcode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getResearchname() {
        return researchname;
    }

    public void setResearchname(String researchname) {
        this.researchname = researchname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    @Override
    public String toString() {
        return "Researcher{" +
            "id=" + id +
            ", eventcode='" + eventcode + '\'' +
            ", researchcode='" + researchcode + '\'' +
            ", age=" + age +
            ", sex='" + sex + '\'' +
            ", researchname='" + researchname + '\'' +
            ", position='" + position + '\'' +
            ", projectcode='" + projectcode + '\'' +
            '}';
    }
}
