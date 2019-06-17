package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**     
 * @author: 北京华晨阳通信技术有限责任公司
 * @date: 2019年3月22日 上午10:42:58   
 * @name: 李硕
 * @Description: 项目外的人员表
 */
@Entity
@Table(name = "person")
public class Person {

	
	/*
	 * 
	 * `id` int(20) NOT NULL AUTO_INCREMENT,
	  `researchcode` varchar(255) DEFAULT NULL,
	  `researchname` varchar(255) DEFAULT NULL,
	  `position` varchar(255) DEFAULT NULL,
	  `projectcode` varchar(255) DEFAULT NULL,
	 * */
	
	@Id
	@Column(name = "id")
	@ApiModelProperty(value="id主键")
	private int id;
	
	@Column(name = "researchcode")
	@ApiModelProperty(value="研究对象编码")
	private String researchcode;
	
	@Column(name = "researchname")
	@ApiModelProperty(value="研究对象姓名")
	private String researchname;
	
	@Column(name = "position")
	@ApiModelProperty(value="所属中心（位置信息）")
	private String position;
	
	@Column(name = "projectcode")
	@ApiModelProperty(value="所属项目编码")
	private String projectcode;
	
	@Column(name = "state")
	@ApiModelProperty(value="人员状态（1：可用，2：删除）")
	private int state;
	
	@Column(name = "creattime")
	@ApiModelProperty(value="创建时间")
	private String creattime;

    @Column(name = "sex")
    @ApiModelProperty(value="性别")
    private String sex;

    @Column(name = "age")
    @ApiModelProperty(value="年龄")
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}


	//后添加的字段sex,age,toString();
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
        return "Person{" +
            "id=" + id +
            ", researchcode='" + researchcode + '\'' +
            ", researchname='" + researchname + '\'' +
            ", position='" + position + '\'' +
            ", projectcode='" + projectcode + '\'' +
            ", state=" + state +
            ", creattime='" + creattime + '\'' +
            ", sex='" + sex + '\'' +
            ", age=" + age +
            '}';
    }
}
