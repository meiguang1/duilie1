package com.hcycom.ctginms.web.rest.vm;
/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年12月3日 下午2:46:37   
 * @name 李硕
 * @Description: 用户项目表与项目表连接的实体
 */
public class UserProjectAndProject {

	
	/*
	 * u.username,
	 * u.state,
	 * p.projectcode,
	 * p.projectname,
	 * p.projecttype,
	 * p.projectdescribes,
	 * p.creatusername,
	 * p.creattime
	 * */
	
	private String username;//用户名
	private int state;//状态识别，是否是自己的项目，或共享的项目
	private String projectcode;//项目编码
	private String projectname;//项目名称
	private int projecttype;//项目类型
	private String projectdescribes;//项目描述
	private String creatusername;//项目创建人用户名
	private String creattime;//项目创建时间
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	
	
	
	
	
	
}
