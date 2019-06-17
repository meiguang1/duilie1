package com.hcycom.ctginms.service.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.domain.Project;
import com.hcycom.ctginms.domain.User;
import com.hcycom.ctginms.domain.UserProject;
import com.hcycom.ctginms.repository.EventMapper;
import com.hcycom.ctginms.repository.ProjectMapper;
import com.hcycom.ctginms.repository.UserMapper;
import com.hcycom.ctginms.repository.UserProjectMapper;
import com.hcycom.ctginms.service.FunctionService;
import com.hcycom.ctginms.service.ProjectService;
import com.hcycom.ctginms.service.UserService;
import com.hcycom.ctginms.web.rest.vm.ProjectEventListReturn;
import com.hcycom.ctginms.web.rest.vm.UpdateProjectMessage;
import com.hcycom.ctginms.web.rest.vm.UserProjectAndProject;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月27日 上午9:50:54   
 * @name 李硕
 * @Description: 项目的服务层接口实现类
 */
@Service
public class ProjectServiceImpl implements ProjectService{

	
	@Autowired
	private ProjectMapper pm;
	
	@Autowired
	private EventMapper em;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private UserMapper um;
	
	
	@Autowired
	private FunctionService fs;
	
	@Autowired
	private UserProjectMapper upm;
	
	
	@Override
	public List<Project> getProjectAll() {
		// TODO Auto-generated method stub
		
		List<Project> list=pm.selectAllProject();
		
		
		return list;
	}

	
	
	
	
	
	@Override
	public List<ProjectEventListReturn> getProjectEventList(String username) {
		// TODO Auto-generated method stub
		
		List<ProjectEventListReturn> pelrlist=new ArrayList<>();
		List<User> ulist=um.selectOneByUsernameNoPassword(username);
		
		
		
		//分权限，超级管理员权限
		if(ulist.get(0).getRole()==1){
			
		
		
		
			List<Project> plist=pm.selectAllProject();
			
					
			
			
			for (int i = 0; i < plist.size(); i++) {
				
				ProjectEventListReturn perl=new ProjectEventListReturn();
				
				perl.setProjectcode(plist.get(i).getProjectcode());
				perl.setProjectname(plist.get(i).getProjectname());
				perl.setProjecttype(plist.get(i).getProjecttype());
				perl.setProjectdescribes(plist.get(i).getProjectdescribes());
				perl.setCreatusername(plist.get(i).getCreatusername());
				perl.setState(3);//1:自己建立的，2：以他人共享的，3：是数据库不会存3，
				//由于是超级管理员，即使自己建立的，也不会存在共享，本身超级管理员可以做任何操作（为方便前台）
				perl.setCreattime(plist.get(i).getCreattime());
				perl.setElist(em.selectEventByProjectcode(plist.get(i).getProjectcode()));
				
				pelrlist.add(perl);
				
			}
		
		//分权限，普通管理员权限
		}else{
			
			List<UserProjectAndProject> upplist=upm.selectUAndPByUusername(username);
			
			for (int i = 0; i < upplist.size(); i++) {
				
				ProjectEventListReturn perl=new ProjectEventListReturn();
				
				perl.setProjectcode(upplist.get(i).getProjectcode());
				perl.setProjectname(upplist.get(i).getProjectname());
				perl.setProjecttype(upplist.get(i).getProjecttype());
				perl.setProjectdescribes(upplist.get(i).getProjectdescribes());
				perl.setCreatusername(upplist.get(i).getCreatusername());
				perl.setState(upplist.get(i).getState());
				perl.setCreattime(upplist.get(i).getCreattime());
				perl.setElist(em.selectEventByProjectcode(upplist.get(i).getProjectcode()));
				
				pelrlist.add(perl);
				
			}
			
			
		}
		
		
		
		return pelrlist;
	}






	@Override
	public Project addOneProject(Project project,String fivestring) {
		// TODO Auto-generated method stub
		
		
		List<User> ulist=us.getOneUserByUsername(project.getCreatusername());
		Project project1= new Project();
		
		if(ulist.get(0).getRole()==1){
			
			pm.insertProjectOne(project);
			
			
			
			//查询整条新添加的数据
			project1=pm.selectOneProjectById(project.getId());
			
			project1.setProjectstate(3);//这里和数据库没关系，是
			//前台需要检测是否为自己创建的，在userproject表中，有state字段，
			//在project中没有，该字段暂时无实际用途,设立为是否激活的项目，该字段在提取数据
			//结束后，在程序中手动修改，是为了服务前台的，添加成功之后的共享按钮，做一个判断
			//超级管理员不参与任何项目的共享设置，因此，手动赋值为3，普通管理员手动赋值为1
			
			
			
			
			
			//新添加项目的5大功能的设置
			int b=fs.addNewProjectByFunction(fivestring, project1.getProjectcode(), project1.getId());
			
		}else{
			
			pm.insertProjectOne(project);
			
			//查询整条新添加的数据
			project1=pm.selectOneProjectById(project.getId());
			
			project1.setProjectstate(1);//普通管理员手动赋值为1，具体解释，看上方if中的内容
			
			//新添加项目的5大功能的设置
			int b=fs.addNewProjectByFunction(fivestring, project1.getProjectcode(), project1.getId());
			
			//将该用户的用户名和项目id存储到userproject表
			UserProject userproject=new UserProject();
			userproject.setUsername(project1.getCreatusername());
			userproject.setProjectid(project1.getId());
			userproject.setState(1);
			int c=upm.addMessageStateIsOne(userproject);
			
			
			
			
			
		}
		
		
		return project1;
		
		
	}






	@Override
	public int deleteUserProjectByUserArrAndPCode(String projectcode, String[] userarr) {
		// TODO Auto-generated method stub
		
		int a=upm.deleteUserProjectByUsernameAndPcode(projectcode, userarr);
		
		return a;
	}






	@Override
	public int addUserProjectUserAndPCode(String projectcode, String[] userarr) {
		// TODO Auto-generated method stub
		
		int a =upm.insertUserPeojectByUsernameAndPcode(projectcode, userarr);
		
		return a;
	}






	@Override
	public List<User> getPCodeExistenceUserProject(String projectcode) {
		// TODO Auto-generated method stub
		
		List<User> ulist=upm.selectUserByProjectcode(projectcode);
		
		
		
		return ulist;
	}






	@Override
	public List<User> getPCodeNoExistenceUserProject(String projectcode) {
		// TODO Auto-generated method stub
		
		List<User> ulist=upm.selectRoleTwoUserByProjectcode(projectcode);
		
		return ulist;
	}






	@Override
	public UpdateProjectMessage getProjectMessageUpdate(String projectcode) {
		// TODO Auto-generated method stub
		
		
		UpdateProjectMessage upm =pm.selectUpdateProjectMessage(projectcode);
		
		
		return upm;
	}






	@Override
	public Project updateProjectAndFunction(String projectcode, String projectname, String projectdescribes,
			String fivestring) {
		// TODO Auto-generated method stub
		
		
				
		
		Project project=new Project();
		
		project.setProjectcode(projectcode);
		project.setProjectname(projectname);
		project.setProjectdescribes(projectdescribes);
		
		
		int a=pm.updateProject(project);
		
		if(a==1){
			
			int b=fs.updateFunctionByProjectcode(fivestring, projectcode);
			
			if(b==1){
				return project;
			}
			
		}
		
		
		
		return pm.selectOneProjectByProjectcode(projectcode);
	}






	@Override
	public int deleteProject(String projectcode) {
		// TODO Auto-generated method stub
		
		Project project=new Project();
		project.setProjectcode(projectcode);
		project.setProjectstate(2);
		
		int a=pm.updateProjectState(project);
		
		return a;
	}






	@Override
	public int recoveryProject(String projectcode) {
		// TODO Auto-generated method stub
		Project project=new Project();
		project.setProjectcode(projectcode);
		project.setProjectstate(1);
		
		int a=pm.updateProjectState(project);
		
		return a;
	}






	@Override
	public List<ProjectEventListReturn> getIsDeleteProject() {
		// TODO Auto-generated method stub
		
		
		List<ProjectEventListReturn> pelrlist=new ArrayList<>();
		List<Project> plist = pm.selectISDeleteProject();
		
		
		for (int i = 0; i < plist.size(); i++) {
			
			ProjectEventListReturn perl=new ProjectEventListReturn();
			
			perl.setProjectcode(plist.get(i).getProjectcode());
			perl.setProjectname(plist.get(i).getProjectname());
			perl.setProjecttype(plist.get(i).getProjecttype());
			perl.setProjectdescribes(plist.get(i).getProjectdescribes());
			perl.setCreatusername(plist.get(i).getCreatusername());
			perl.setState(3);//1:自己建立的，2：以他人共享的，3：是数据库不会存3，
			//由于是超级管理员，即使自己建立的，也不会存在共享，本身超级管理员可以做任何操作（为方便前台）
			perl.setCreattime(plist.get(i).getCreattime());
			perl.setElist(em.selectEventByProjectcode(plist.get(i).getProjectcode()));
			
			pelrlist.add(perl);
			
		}
		
		
		
		
		return pelrlist;
	}

}
