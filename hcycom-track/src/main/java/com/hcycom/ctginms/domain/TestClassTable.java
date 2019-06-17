package com.hcycom.ctginms.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;



/**
 *@author 小硕硕
 *@date 2018年3月13日 下午2:56:08
 *
 */
@Entity
@Table(name="hcy_test_calsstable")
public class TestClassTable {

	
	
	@Id
	@Column(name = "t_c_id")
	@ApiModelProperty(value="测试班级表ID")
	private String tcid;
	
	
	@Column(name="t_c_name")
	@ApiModelProperty(value="测试班级表的名字")
	private String tcname;

	
	
/*	@OneToMany(fetch=FetchType.LAZY,mappedBy="tcid")
	private List<TestTable> testtable; */
	
	

/*	public List<TestTable> getTesttable() {
		return testtable;
	}


	public void setTesttable(List<TestTable> testtable) {
		this.testtable = testtable;
	}*/


	public String getTcid() {
		return tcid;
	}


	public void setTcid(String tcid) {
		this.tcid = tcid;
	}


	public String getTcname() {
		return tcname;
	}


	public void setTcname(String tcname) {
		this.tcname = tcname;
	}



	
	
	
	
	
	
}
