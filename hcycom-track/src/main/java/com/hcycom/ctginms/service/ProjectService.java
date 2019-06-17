package com.hcycom.ctginms.service;

import java.util.List;

import com.hcycom.ctginms.domain.Project;
import com.hcycom.ctginms.domain.User;
import com.hcycom.ctginms.web.rest.vm.ProjectEventListReturn;
import com.hcycom.ctginms.web.rest.vm.UpdateProjectMessage;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月27日 上午9:48:22   
 * @name 李硕
 * @Description: 项目服务层
 */
public interface ProjectService {

	//获取全部已激活状态的项目列表
	List<Project> getProjectAll();
	
	//获取该用户下完整的项目事件列表(分超级和普通管理员权限)
	List<ProjectEventListReturn> getProjectEventList(String username);
	
	//添加一个新项目
	Project addOneProject(Project project,String fivestring);
	
	//删除共享关系（项目创建人删除某些用户与该项目的共享关系）
	int deleteUserProjectByUserArrAndPCode(String projectcode,String []userarr);
	
	//添加共享（项目创建人，添加某些用户共享该项目）
	int addUserProjectUserAndPCode(String projectcode,String []userarr);
	
	//获取某项目下，已共享人员的用户名和名字
	List<User> getPCodeExistenceUserProject(String projectcode);
	
	//获取某项目下，未共享的，所有的普通用户的用户名和名字
	List<User> getPCodeNoExistenceUserProject(String projectcode);
	
	//获取要修改的项目的详细信息
	UpdateProjectMessage getProjectMessageUpdate(String projectcode);
	
	//修改项目内容，包括项目的5个功能
	Project updateProjectAndFunction(String projectcode,String projectname,String projectdescribes,String fivestring);
	
	//删除项目
	int deleteProject(String projectcode);
	
	//恢复项目
	int recoveryProject(String projectcode);
	
	//查询全部已删除的项目
	List<ProjectEventListReturn> getIsDeleteProject();
	
	
}
