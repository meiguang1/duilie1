package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月27日 上午9:20:20   
 * @name 李硕
 * @Description: 项目实体，project表
 */
@Entity
@Table(name = "project")
public class Project {
	
	
	/*
	 * `id` varchar(255) NOT NULL,
	  `projectcode` varchar(255) default NULL,
	  `projectname` varchar(255) default NULL,
	  `projecttype` int(11) default NULL,
	  `projectdescribes` varchar(255) default NULL,
	  `creatusername` varchar(255) default NULL,
	  `creattime` datetime default NULL,
	 * 
	 * */
	
	@Id
	@Column(name = "id")
	@ApiModelProperty(value="id主键")
	private int id;
	
	@Column(name = "projectcode")
	@ApiModelProperty(value="项目编码")
	private String projectcode;
	
	@Column(name = "projectname")
	@ApiModelProperty(value="项目名称")
	private String projectname;
	
	@Column(name = "projecttype")
	@ApiModelProperty(value="项目类型")
	private int projecttype;
	
	@Column(name = "projectdescribes")
	@ApiModelProperty(value="项目描述")
	private String projectdescribes;
	
	@Column(name = "creatusername")
	@ApiModelProperty(value="创建人姓名")
	private String creatusername;
	
	@Column(name = "creattime")
	@ApiModelProperty(value="创建时间")
	private String creattime;
		
	@Column(name = "projectstate")
	@ApiModelProperty(value="项目状态")
	private int projectstate;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public int getProjecttype() {
		return projecttype;
	}

	public void setProjecttype(int projecttype) {
		this.projecttype = projecttype;
	}

	public String getProjectdescribes() {
		return projectdescribes;
	}

	public void setProjectdescribes(String projectdescribes) {
		this.projectdescribes = projectdescribes;
	}

	public String getCreatusername() {
		return creatusername;
	}

	public void setCreatusername(String creatusername) {
		this.creatusername = creatusername;
	}

	

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime.replace(".0","");
	}

	public int getProjectstate() {
		return projectstate;
	}

	public void setProjectstate(int projectstate) {
		this.projectstate = projectstate;
	}
	
	
	
}
