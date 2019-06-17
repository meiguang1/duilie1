package com.hcycom.ctginms.web.rest.vm;
/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年12月6日 上午9:32:27   
 * @name 李硕
 * @Description: 修改项目，查询要修改项的详细信息
 */
public class UpdateProjectMessage {

	
	private String projectcode;//项目编码
	private String projectname;//项目名称
	private String projectdescribes;//项目描述
	private int ry;//人员
	private int dw;//点位
	private int yb;//样本
	private int rk;//入库
	private int ck;//出库
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
	public String getProjectdescribes() {
		return projectdescribes;
	}
	public void setProjectdescribes(String projectdescribes) {
		this.projectdescribes = projectdescribes;
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
	
	
	
	
	
	
	
}
