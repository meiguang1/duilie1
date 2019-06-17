package com.hcycom.ctginms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.domain.User;
import com.hcycom.ctginms.domain.UserProject;
import com.hcycom.ctginms.web.rest.vm.UserProjectAndProject;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年12月3日 上午11:01:40   
 * @name 李硕
 * @Description: 用户名、项目表持久层，数据库操作
 */
@Mapper
public interface UserProjectMapper {

	
	//通过用户名，查询该用户有权限的项目列表
	List<UserProjectAndProject> selectUAndPByUusername(@Param("username")String username);
	
	//添加单条信息，个人添加或共享项目所使用，state一定为1时为自己新建项目，state为2时为共享给他人项目
	int addMessageStateIsOne(@Param("userproject")UserProject userproject);
	
	//查询某一项目的已共享人员名单：该项目编码的项目，有哪些用户是共享的（但不包括建立项目的本人,也就是state=2）
	List<User> selectUserByProjectcode(@Param("projectcode")String projectcode);
	
	//查询某一项目的未共享人员的名单：该项目的项目编码，查询所有普通用户权限的用户（即role=2）但不包括建项本人以及已经共享了该项目的人员
	List<User> selectRoleTwoUserByProjectcode(@Param("projectcode")String projectcode);
	
	//删除某些用户的共享，通过选定删除的用户名和项目编码，删除该条
	int deleteUserProjectByUsernameAndPcode(@Param("projectcode")String projectcode,@Param("userarr")String []userarr);
	
	//增加共享，添加某些用户与该项目的共享关系
	int insertUserPeojectByUsernameAndPcode(@Param("projectcode")String projectcode,@Param("userarr")String []userarr);
	
	
	
	
	
	
}
