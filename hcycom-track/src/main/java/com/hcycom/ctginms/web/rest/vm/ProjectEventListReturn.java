package com.hcycom.ctginms.web.rest.vm;

import java.util.List;

import com.hcycom.ctginms.domain.Event;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月27日 下午3:07:36   
 * @name 李硕
 * @Description: 项目事件返回列表，实体
 */
public class ProjectEventListReturn {

	private String projectcode;//项目编号
	private String projectname;//项目名称
	private int projecttype;//项目类型
	private String projectdescribes;//项目描述
	private String creatusername;//项目创建用户名
	private String creattime;//项目创建时间
	private List<Event> elist;//该项目下所属事件集合
	private int state;//是自己建立的项目，还是与他人共享的项目
	
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
	public String getCreattime() {
		return creattime;
	}
	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}
	public List<Event> getElist() {
		return elist;
	}
	public void setElist(List<Event> elist) {
		this.elist = elist;
	}
	public String getCreatusername() {
		return creatusername;
	}
	public void setCreatusername(String creatusername) {
		this.creatusername = creatusername;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
	
	
	
}
