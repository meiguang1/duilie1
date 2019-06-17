package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年12月3日 上午10:53:12   
 * @name 李硕
 * @Description: 用户名、项目表userproject的实体类
 */
@Entity
@Table(name = "userproject")
public class UserProject {
	
	
	/*
	 * 
	 * `id` int(11) NOT NULL auto_increment,
	  `username` varchar(255) default NULL,
	  `projectid` int(11) default NULL,
	  `state` int(11) default NULL,
	  `creatprouser` varchar(255) default NULL,
	  `creattime` datetime default NULL,
	 * 
	 * */
	
	
	@Id
	@Column(name = "id")
	@ApiModelProperty(value="ID主键")
	private int id;
	
	@Column(name = "username")
	@ApiModelProperty(value="用户名")
	private String username;
	
	@Column(name = "projectid")
	@ApiModelProperty(value="项目id")
	private int projectid;
	
	@Column(name = "state")
	@ApiModelProperty(value="辨别该项目是否属于本人建立")
	private int state;
	
	@Column(name = "creattime")
	@ApiModelProperty(value="创建该条时间")
	private String creattime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
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
	
	
	
}
