package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月20日 下午2:39:58   
 * @name 李硕
 * @Description: 
 */
@ApiModel(value = "修改密码验证",description = "修改密码时验证传递参数")
public class PostUpdatePassword {
	
	@ApiModelProperty(value="用户名",name="username",required=true,example="admin")
	private String username;
	
	@ApiModelProperty(value="原密码",name="passworda",required=true)
	private String passworda;
	
	@ApiModelProperty(value="新密码",name="passwordb",required=true)
	private String passwordb;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassworda() {
		return passworda;
	}

	public void setPassworda(String passworda) {
		this.passworda = passworda;
	}

	public String getPasswordb() {
		return passwordb;
	}

	public void setPasswordb(String passwordb) {
		this.passwordb = passwordb;
	}
	
	
	
	
	

}
