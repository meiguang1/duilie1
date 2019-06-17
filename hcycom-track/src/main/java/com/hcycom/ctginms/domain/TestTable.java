package com.hcycom.ctginms.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 *@author 小硕硕
 *@date 2018年3月13日 上午11:08:36
 *
 */
@Entity
@Table(name="hcy_test_table")
public class TestTable {

	/*
  `t_id` varchar(99) NOT NULL COMMENT '测试表的主键',
  `t_name` varchar(99) default NULL COMMENT '姓名',
  `t_age` int(11) default NULL COMMENT '年龄',
  `t_sex` varchar(99) default NULL COMMENT '性别',
  `t_c_id` varchar(99) default NULL COMMENT '与其他测试表的链接',
	 * */





	@Id
	@Column(name = "t_id")
	@ApiModelProperty(value="测试表的主键")
	private String tid;

	@Column(name= "t_name")
	@ApiModelProperty(value="姓名")
	private String tname;


	@Column(name="t_age")
	@ApiModelProperty(value="年龄")
	private Integer tage;


	@Column(name="t_sex")
	@ApiModelProperty(value="性别")
	private String tsex;


	@Column(name="t_c_id")
	@ApiModelProperty(value="与其他测试表的链接")
	private String tcid;


	/*@ManyToOne
	@JoinColumn
	private TestClassTable testclasstable;*/





/*	public TestClassTable getTestclasstable() {
		return testclasstable;
	}


	public void setTestclasstable(TestClassTable testclasstable) {
		this.testclasstable = testclasstable;
	}*/


	public String getTid() {
		return tid;
	}


	public void setTid(String tid) {
		this.tid = tid;
	}


	public String getTname() {
		return tname;
	}


	public void setTname(String tname) {
		this.tname = tname;
	}


	public Integer getTage() {
		return tage;
	}


	public void setTage(Integer tage) {
		this.tage = tage;
	}


	public String getTsex() {
		return tsex;
	}


	public void setTsex(String tsex) {
		this.tsex = tsex;
	}


	public String getTcid() {
		return tcid;
	}


	public void setTcid(String tcid) {
		this.tcid = tcid;
	}


	public TestTable(){
			this.setTid("");
			this.setTname("");
			this.setTage(-1);
			this.setTsex("");
	}







}
