package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月16日 下午6:10:34   
 * @name 李硕
 * @Description: 
 */
@ApiModel(value = "登录验证",description = "登录验证传递参数")
public class PostCheckLogin {

	
	
	@ApiModelProperty(value="用户名",name="username",required=true,example="admin")
	private String username;
	@ApiModelProperty(value="密码",name="password",required=true)
	private String password;
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
	
	
	
	
	
}
