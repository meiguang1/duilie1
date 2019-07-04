package com.hcycom.ctginms.postdomain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;


/**     
 * @author: 北京华晨阳通信技术有限责任公司
 * @date: 2019年3月25日 下午2:49:53   
 * @name: 李硕
 * @Description: 
 */
@ApiModel(value = "修改或者增加post方法实体传参",description = "修改或者增加post方法实体传参")
public class PostPerson {

	@ApiModelProperty(value="ID",name="id",required=true)
	private int id;
	
	@ApiModelProperty(value="调查中心编码",name="researchcode",required=true)
	private String researchcode;
	
	@ApiModelProperty(value="调查人员姓名",name="researchname",required=true)
	private String researchname;

    @Column(name = "countycode")
    @ApiModelProperty(value="所属中心编码（位置信息）")
    private String countycode;
	
	@ApiModelProperty(value="点位名称",name="position",required=true)
	private String position;

	@ApiModelProperty(value="项目编码",name="projectcode",required=true)
    private String projectcode;

    @ApiModelProperty(value="性别",name="sex",required=true)
    private String sex;

    @ApiModelProperty(value="性别",name="age",required=true)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResearchcode() {
        return researchcode;
    }

    public void setResearchcode(String researchcode) {
        this.researchcode = researchcode;
    }

    public String getResearchname() {
        return researchname;
    }

    public void setResearchname(String researchname) {
        this.researchname = researchname;
    }

    public String getCountycode() {
        return countycode;
    }

    public void setCountycode(String countycode) {
        this.countycode = countycode;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PostPerson{" +
            "id=" + id +
            ", researchcode='" + researchcode + '\'' +
            ", researchname='" + researchname + '\'' +
            ", countycode='" + countycode + '\'' +
            ", position='" + position + '\'' +
            ", projectcode='" + projectcode + '\'' +
            ", sex='" + sex + '\'' +
            ", age=" + age +
            '}';
    }
}
