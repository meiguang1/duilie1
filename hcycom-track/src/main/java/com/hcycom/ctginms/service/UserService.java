package com.hcycom.ctginms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.domain.User;
import com.hcycom.ctginms.postdomain.PostCheckLogin;
import com.hcycom.ctginms.web.rest.vm.CheckLoginReturn;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月16日 下午5:22:28   
 * @name 李硕
 * @Description: 用户表服务层接口
 */
public interface UserService {

	//登录验证，只传用户名
	List<CheckLoginReturn> CheckLogin(PostCheckLogin clogin);
	
	//修改密码，通过账号，成功返回1，原密码错误返回2，其他错误返回3
	int updatePassword(String username,String passworda,String passwordb);
	
	//通过username用户名获取用户详细信息
	List<User> getOneUserByUsername(String username);
	
	//修改个人姓名及个人描述
	int updateUsermessage(String username,String name,String describes);
	
	
	
	
}
