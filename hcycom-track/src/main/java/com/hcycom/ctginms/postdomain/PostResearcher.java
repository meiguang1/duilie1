package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;

@ApiModel(value = "修改或者增加post方法实体传参",description = "修改或者增加post方法实体传参")
public class PostResearcher {

    private Object select;
    private int pages;


    public Object getSelect() {
        return select;
    }

    public void setSelect(Object List) {
        this.select = List;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

//  暂时性测试
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
        return "PostResearcher{" +
            "select=" + select +
            ", pages=" + pages +
            ", id=" + id +
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
