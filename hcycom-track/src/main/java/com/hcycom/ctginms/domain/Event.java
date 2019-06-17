package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月27日 上午10:39:35   
 * @name 李硕
 * @Description: 事件表event
 */
@Entity
@Table(name = "event")
public class Event {

	
	
	
	
	
	
	/*
	 * `id` int(11) NOT NULL auto_increment,
	  `eventcode` varchar(255) default NULL,
	  `eventname` varchar(255) default NULL,
	  `eventdescribes` varchar(255) default NULL,
	  `projectcode` varchar(255) default NULL,
	  `creatusername` varchar(255) default NULL,
	  `creattime` datetime default NULL,
	 * 
	 * */
	
	@Id
	@Column(name = "id")
	@ApiModelProperty(value="id主键")
	private int id;
	
	@Column(name = "eventcode")
	@ApiModelProperty(value="事件编码")
	private String eventcode;
	
	@Column(name = "eventname")
	@ApiModelProperty(value="事件名称")
	private String eventname;

	@Column(name = "eventdescribes")
	@ApiModelProperty(value="事件描述")
	private String eventdescribes;

	@Column(name = "projectcode")
	@ApiModelProperty(value="事件所属项目")
	private String projectcode;

	@Column(name = "creatusername")
	@ApiModelProperty(value="创建人账号")
	private String creatusername;

	@Column(name = "creattime")
	@ApiModelProperty(value="创建时间")
	private String creattime;

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

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventdescribes() {
		return eventdescribes;
	}

	public void setEventdescribes(String eventdescribes) {
		this.eventdescribes = eventdescribes;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
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
	
	
	
	
}
