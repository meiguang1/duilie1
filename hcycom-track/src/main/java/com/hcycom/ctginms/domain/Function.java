package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月30日 下午2:40:30   
 * @name 李硕
 * @Description: 5大功能表
 */
@Entity
@Table(name = "function")
public class Function {

	
	/*
	 * 
	 * `id` int(11) NOT NULL auto_increment,
	  `ry` int(11) default NULL,
	  `dw` int(11) default NULL,
	  `yb` int(11) default NULL,
	  `rk` int(11) default NULL,
	  `ck` int(11) default NULL,
	  `projectcode` varchar(255) default NULL,
	  `projectid` int(11) default NULL,
	 * 
	 * */
	
	@Id
	@Column(name = "id")
	@ApiModelProperty(value="id主键")
	private int id;
	
	@Column(name = "ry")
	@ApiModelProperty(value="人员管理")
	private int ry;
	
	@Column(name = "dw")
	@ApiModelProperty(value="点位管理")
	private int dw;
	
	@Column(name = "yb")
	@ApiModelProperty(value="样本管理")
	private int yb;
	
	@Column(name = "rk")
	@ApiModelProperty(value="入库管理")
	private int rk;
	
	@Column(name = "ck")
	@ApiModelProperty(value="出库管理")
	private int ck;
	
	@Column(name = "projectcode")
	@ApiModelProperty(value="项目编码")
	private String projectcode;
	
	@Column(name = "projectid")
	@ApiModelProperty(value="项目id")
	private int projectid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRy() {
		return ry;
	}

	public void setRy(int ry) {
		this.ry = ry;
	}

	public int getDw() {
		return dw;
	}

	public void setDw(int dw) {
		this.dw = dw;
	}

	public int getYb() {
		return yb;
	}

	public void setYb(int yb) {
		this.yb = yb;
	}

	public int getRk() {
		return rk;
	}

	public void setRk(int rk) {
		this.rk = rk;
	}

	public int getCk() {
		return ck;
	}

	public void setCk(int ck) {
		this.ck = ck;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
