package com.hcycom.ctginms.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.Event;
import com.hcycom.ctginms.domain.Project;
import com.hcycom.ctginms.domain.User;
import com.hcycom.ctginms.postdomain.PostaddUserProjectPCodeAndUserarr;
import com.hcycom.ctginms.service.EventService;
import com.hcycom.ctginms.service.ProjectService;
import com.hcycom.ctginms.web.rest.vm.EventFunctionReturn;
import com.hcycom.ctginms.web.rest.vm.ProjectEventListReturn;
import com.hcycom.ctginms.web.rest.vm.UpdateProjectMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月27日 上午9:52:30   
 * @name 李硕
 * @Description: 项目事件的rest接口
 */
@RestController
@RequestMapping(value="/api/projectrest")
@Api(tags={"项目事件，project、event表"},description="project、event表的相关操作，做项目事件的相关操作")
public class ProjectRest {

	
	@Autowired
	private ProjectService ps;
	
	@Autowired
	private EventService es;
	
	@GetMapping("/getProject")
	@Timed
	@ApiOperation(value="获取全部项目列表（已激活状态）", notes="获取全部项目列表（已激活状态）")
//	@ApiImplicitParams({		
//		@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String",paramType="query"),	
//		@ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String",paramType="query"),
//		@ApiImplicitParam(name = "describes", value = "个人描述", required = true, dataType = "String",paramType="query"),
//	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<List<Project>> getProject(){
	
		List<Project> list=ps.getProjectAll();
		
		return new ResponseEntity<List<Project>>(list, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getEventByProjectcode")
	@Timed
	@ApiOperation(value="获取事件列表", notes="通过项目code获取相应项目的事件列表")
	@ApiImplicitParams({		
		@ApiImplicitParam(name = "projectcode", value = "项目编码", required = true, dataType = "String",paramType="query"),	
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<List<Event>> getEventByProjectcode(String projectcode){
	
		List<Event> list=es.getEventByProject(projectcode);
		
		return new ResponseEntity<List<Event>>(list, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/getProjectEventList")
	@Timed
	@ApiOperation(value="获取项目事件列表", notes="获取完整的项目事件列表")
	@ApiImplicitParams({		
		@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String",paramType="query"),	
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<List<ProjectEventListReturn>> getProjectEventList(String username){
	
		List<ProjectEventListReturn> pelrlist=ps.getProjectEventList(username);
		
		return new ResponseEntity<List<ProjectEventListReturn>>(pelrlist, HttpStatus.OK);
	}
	
	
	@GetMapping("/getDeleteProjectEventList")
	@Timed
	@ApiOperation(value="获取删除的项目事件列表", notes="获取删除的项目事件列表")
//	@ApiImplicitParams({		
//		@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String",paramType="query"),	
//	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<List<ProjectEventListReturn>> getDeleteProjectEventList(){
	
		List<ProjectEventListReturn> pelrlist=ps.getIsDeleteProject();
		
		return new ResponseEntity<List<ProjectEventListReturn>>(pelrlist, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/addOneProjectMessage")
	@Timed
	@ApiOperation(value="添加一个新项目", notes="添加一个新项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "projectname", value = "项目名称", required = true, dataType = "String",paramType="query"),	
		@ApiImplicitParam(name = "projectdescribes", value = "项目描述", required = true, dataType = "String",paramType="query"),	
		@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String",paramType="query"),	
		@ApiImplicitParam(name = "fivestring", value = "5个功能，是否开关的，字符串（人员，点位，样本，入库，出库：0为关，1为开）", required = true, dataType = "String",paramType="query"),	
		
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<Project> addOneProjectMessage(String projectname,String projectdescribes,String username,String fivestring){
		
		Project project=new Project();
		project.setProjectname(projectname);
		project.setProjectdescribes(projectdescribes);
		project.setCreatusername(username);
		
		Project pr=ps.addOneProject(project,fivestring);
		
		return new ResponseEntity<Project>(pr, HttpStatus.OK);
	}
	
	
	@PostMapping("/deleteUserProjectGetPCodeAndUserarr")
	@Timed
	@ApiOperation(value="已共享项目的人员，取消共享", notes="已共享项目的人员，取消共享")
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<String> deleteUserProjectGetPCodeAndUserarr(@RequestBody PostaddUserProjectPCodeAndUserarr puppu){
		
		int a =ps.deleteUserProjectByUserArrAndPCode(puppu.getProjectcode(), puppu.getUserarr());
		
		return new ResponseEntity<String>(a+"", HttpStatus.OK);
	}
	
	
	@PostMapping("/addUserProjectPCodeAndUserarr")
	@Timed
	@ApiOperation(value="未共享项目的人员，添加共享", notes="未共享项目的人员，添加共享")
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<String> addUserProjectPCodeAndUserarr(@RequestBody PostaddUserProjectPCodeAndUserarr puppu){
		
		
		
		
		int a =ps.addUserProjectUserAndPCode(puppu.getProjectcode(), puppu.getUserarr());
		
		return new ResponseEntity<String>(a+"", HttpStatus.OK);

	}
	
	
	
	@GetMapping("/existencePCodeUserProject")
	@Timed
	@ApiOperation(value="某项目，已共享项目的人员（不包括建项本人）", notes="某项目，已共享项目的人员（不包括建项本人）")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "projectcode", value = "项目编码（UUID）", required = true, dataType = "String",paramType="query"),	
		
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<List<User>> existencePCodeUserProject(String projectcode){
		
		List<User> ulist =ps.getPCodeExistenceUserProject(projectcode);
		
		return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping("/noExistencePCodeUserProject")
	@Timed
	@ApiOperation(value="某项目，未共享项目的人员（不包括建项本人，和已共享的）", notes="某项目，未共享项目的人员（不包括建项本人，和已共享的）")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "projectcode", value = "项目编码（UUID）", required = true, dataType = "String",paramType="query"),		
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<List<User>> noExistencePCodeUserProject(String projectcode){
		
		List<User> ulist =ps.getPCodeNoExistenceUserProject(projectcode);
		
		return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/updateProjectAllMessage")
	@Timed
	@ApiOperation(value="修改项目前，获取该项目的全部信息", notes="修改项目前，获取该项目的全部信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "projectcode", value = "项目编码（UUID）", required = true, dataType = "String",paramType="query"),		
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<UpdateProjectMessage> updateProjectAllMessage(String projectcode){
		
		UpdateProjectMessage ump =ps.getProjectMessageUpdate(projectcode);
		
		return new ResponseEntity<UpdateProjectMessage>(ump, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/updateProjectAndFunction")
	@Timed
	@ApiOperation(value="修改项目,并且修改5个功能", notes="修改项目,并且修改5个功能")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "projectcode", value = "项目编码（UUID）", required = true, dataType = "String",paramType="query"),	
		@ApiImplicitParam(name = "projectname", value = "项目名称", required = true, dataType = "String",paramType="query"),		
		@ApiImplicitParam(name = "projectdescribes", value = "项目描述", required = true, dataType = "String",paramType="query"),		
		@ApiImplicitParam(name = "fivestring", value = "5个功能", required = true, dataType = "String",paramType="query"),		
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<Project> updateProjectAndFunction(String projectcode,String projectname,String projectdescribes,String fivestring){
		
		Project project = ps.updateProjectAndFunction(projectcode, projectname, projectdescribes, fivestring);
		
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	
	@GetMapping("/deleteProject")
	@Timed
	@ApiOperation(value="删除项目", notes="删除项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "projectcode", value = "项目编码（UUID）", required = true, dataType = "String",paramType="query"),		
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<String> deleteProject(String projectcode){
		
		int a =ps.deleteProject(projectcode);
		
		return new ResponseEntity<String>(a+"", HttpStatus.OK);
	}
	
	
	
	@GetMapping("/recoveryProject")
	@Timed
	@ApiOperation(value="恢复项目", notes="恢复项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "projectcode", value = "项目编码（UUID）", required = true, dataType = "String",paramType="query"),		
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<String> recoveryProject(String projectcode){
		
		int a =ps.recoveryProject(projectcode);
		
		return new ResponseEntity<String>(a+"", HttpStatus.OK);
	}
	
	
	
	
	
	
	@GetMapping("/addOneEventByProject")
	@Timed
	@ApiOperation(value="添加新事件，加在项目下", notes="添加新事件，加在项目下")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "projectcode", value = "项目编码（UUID）", required = true, dataType = "String",paramType="query"),	
		@ApiImplicitParam(name = "eventname", value = "事件的名称", required = true, dataType = "String",paramType="query"),	
		@ApiImplicitParam(name = "eventdescribes", value = "事件的描述", required = true, dataType = "String",paramType="query"),	
		@ApiImplicitParam(name = "eventusername", value = "事件的创建人", required = true, dataType = "String",paramType="query"),	
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<Event> addOneEventByProject(String projectcode, String eventname, String eventdescribes,String eventusername){
		
		
		Event event = es.addOneEventByProject(projectcode, eventname, eventdescribes,eventusername);
		
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/eventAndFunctionGetFive")
	@Timed
	@ApiOperation(value="点击事件描述，遍历5个按钮，跟随项目配置的", notes="点击事件描述，遍历5个按钮，跟随项目配置的")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "eventcode", value = "事件的code", required = true, dataType = "String",paramType="query"),	
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<EventFunctionReturn> eventAndFunctionGetFive(String eventcode){
		
		
		EventFunctionReturn efr = es.getEventTableAndFunctonTable(eventcode);
		
		return new ResponseEntity<EventFunctionReturn>(efr, HttpStatus.OK);
	}
	
	
	
	
}
