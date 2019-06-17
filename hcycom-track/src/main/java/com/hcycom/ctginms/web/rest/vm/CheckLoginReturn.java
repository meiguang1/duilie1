package com.hcycom.ctginms.web.rest.vm;


import org.springframework.stereotype.Component;



/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月16日 下午5:36:16   
 * @name 李硕
 * @Description: 登录验证返回参数
 */
@Component
public class CheckLoginReturn {


	private String id;//id
	private String username;//用户名
	private int role;//角色
	private String name;//名字
	private String image;//头像路径
	private String logintime;//上次登录时间
	private String checkcode;//登录验证编码   0：用户名不存在  1：成功   2：密码错误    3：账号冻结
	private String describes;//个人描述
	private String projectcode;//有权限的项目（一个字符串，用逗号隔开的项目id）
	
	
	
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
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public String getProjectcode() {
		return projectcode;
	}
	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}
	
	
	
	
	
	
}
