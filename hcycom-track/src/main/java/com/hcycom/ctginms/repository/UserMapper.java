package com.hcycom.ctginms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.domain.User;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月16日 下午5:10:46   
 * @name 李硕
 * @Description: 用户表数据库操作
 */
@Mapper
public interface UserMapper {

	//通过用户名查询表中字段，登录验证
	List<User> selectUserByUsername(@Param("username")String username);
	
	//通过id修改上次登录时间字段
	int updateLogintimeById(@Param("id")String id,@Param("logintime")String logintime);
	
	//通过username用户名修改密码
	int updatePasswordByUsername(@Param("username")String username,@Param("password")String password);
	
	//通过username用户名，查询该用户的详细信息(该方法不查密码)
	List<User> selectOneByUsernameNoPassword(@Param("username")String username);
	
	//根据username用户名，修改个人信息（仅姓名和个人描述）
	int updateUserMessageByUsername(@Param("username")String username,@Param("name")String name,@Param("describes")String describes);
	
	
}
