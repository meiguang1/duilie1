package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**     
 * @author: 北京华晨阳通信技术有限责任公司
 * @date: 2019年3月22日 上午10:48:43   
 * @name: 李硕
 * @Description: 人员导入事件对照表
 */

@Entity
@Table(name = "personevent")
public class PersonEvent {

	
	/*`id` int(20) NOT NULL,
  	`pid` int(20) DEFAULT NULL,
  	`researchcode` varchar(255) DEFAULT NULL,
  	`projectcode` varchar(255) DEFAULT NULL,
  	`eventcode` varchar(255) DEFAULT NULL,
  */
	
	@Id
	@Column(name = "id")
	@ApiModelProperty(value="id主键")
	private int id;
	
	@Column(name = "pid")
	@ApiModelProperty(value="人员的id")
	private int pid;
	
	@Column(name = "researchcode")
	@ApiModelProperty(value="研究对象编码")
	private String researchcode;
	
	@Column(name = "projectcode")
	@ApiModelProperty(value="所属项目编码")
	private String projectcode;
	
	@Column(name = "eventcode")
	@ApiModelProperty(value="所属事件编码")
	private String eventcode;
	
	@Column(name = "creattime")
	@ApiModelProperty(value="创建时间")
	private String creattime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getResearchcode() {
		return researchcode;
	}

	public void setResearchcode(String researchcode) {
		this.researchcode = researchcode;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public String getEventcode() {
		return eventcode;
	}

	public void setEventcode(String eventcode) {
		this.eventcode = eventcode;
	}

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}
	
	
	
	
	
	
	
	
}
