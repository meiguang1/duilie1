package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年12月4日 下午6:19:40   
 * @name 李硕
 * @Description: 
 */
@ApiModel(value = "项目共享",description = "项目共享")
public class PostaddUserProjectPCodeAndUserarr {

	
	@ApiModelProperty(value="项目编码",name="projectcode",required=true)
	private String projectcode;
	
	@ApiModelProperty(value="用户名数组",name="userarr",required=true)
	private String []userarr;

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public String[] getUserarr() {
		return userarr;
	}

	public void setUserarr(String[] userarr) {
		this.userarr = userarr;
	}
	
	
	
}
