package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月16日 下午5:02:14   
 * @name 李硕
 * @Description: 用户表
 */
@Entity
@Table(name = "user")
public class User {
	
	/*
	 * 
	 `id` varchar(255) NOT NULL,
	  `username` varchar(255) NOT NULL,
	  `password` varchar(255) NOT NULL,
	  `role` int(11) default NULL,
	  `name` varchar(255) default NULL,
	  `state` int(11) default NULL,
	  `creattime` datetime default NULL,
	  `image` varchar(255) default NULL,
	  `logintime` datetime default NULL,
	  PRIMARY KEY  (`id`)
	 * */
	
	@Id
	@Column(name = "id")
	@ApiModelProperty(value="id主键")
	private String id;
	
	@Column(name = "username")
	@ApiModelProperty(value="用户名")
	private String username;
	
	@Column(name = "password")
	@ApiModelProperty(value="密码")
	private String password;
	
	@Column(name = "role")
	@ApiModelProperty(value="角色")
	private int role;
	
	@Column(name = "name")
	@ApiModelProperty(value="姓名")
	private String name;
	
	@Column(name = "state")
	@ApiModelProperty(value="账号状态")
	private String state;
	
	@Column(name = "creattime")
	@ApiModelProperty(value="创建时间")
	private String creattime;
	
	@Column(name = "image")
	@ApiModelProperty(value="头像路径")
	private String image;
	
	@Column(name = "logintime")
	@ApiModelProperty(value="上次登录时间")
	private String logintime;

	@Column(name = "describes")
	@ApiModelProperty(value="个人描述")
	private String describes;
	
	
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	

	

	
	
	
	
	
	

}
