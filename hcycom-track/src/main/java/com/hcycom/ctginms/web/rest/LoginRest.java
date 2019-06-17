package com.hcycom.ctginms.web.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.hcycom.ctginms.domain.User;
import com.hcycom.ctginms.postdomain.PostCheckLogin;
import com.hcycom.ctginms.postdomain.PostUpdatePassword;
import com.hcycom.ctginms.service.UserService;
import com.hcycom.ctginms.web.rest.vm.CheckLoginReturn;
import com.hcycom.ctginms.web.rest.vm.CityPM25AverageAndRisk;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月16日 上午11:24:45   
 * @name 李硕
 * @Description: 登录的rest接口
 */
@RestController
@RequestMapping(value="/api/loginrest")
@Api(tags={"登录user表"},description="user表的相关操作，做登录验证")
public class LoginRest {

	
	@Autowired
	private UserService us;
	
	
	
	
	
	
	@PostMapping("/CheckLoginRest")
	@Timed
	@ApiOperation(value="登录验证",notes="用户名密码")
	public ResponseEntity<List<CheckLoginReturn>> CheckLoginRest(@RequestBody PostCheckLogin clogin){
		
		
		
		List<CheckLoginReturn> list=us.CheckLogin(clogin);
		
		
		return new ResponseEntity<List<CheckLoginReturn>>(list, HttpStatus.OK);
	}
	
	
	
	
	
	@PostMapping("/updatePasswordRest")
	@Timed
	@ApiOperation(value="修改密码",notes="用户名原密码新密码")
	public ResponseEntity<List<String>> updatePasswordRest(@RequestBody PostUpdatePassword pup){
		
		
		
		
		List<String> list=new ArrayList<>();	
		
		System.out.println(pup.getUsername()+"*****"+pup.getPassworda()+"*****"+pup.getPasswordb());
		
		
		
		int a =us.updatePassword(pup.getUsername(), pup.getPassworda(), pup.getPasswordb());
		
		String code=a+"";
		
		list.add(code);
		
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping("/getUserDetailed")
	@Timed
	@ApiOperation(value="根据用户名查询该用户的详细信息", notes="根据用户名查询该用户的详细信息")
	@ApiImplicitParams({		
		@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String",paramType="query"),		
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<List<User>> getUserDetailed(String username){
	
		List<User> list=us.getOneUserByUsername(username);
		
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	

	@GetMapping("/updateUserDetailed")
	@Timed
	@ApiOperation(value="根据用户名修改用户的详细信息（仅姓名和个人描述）", notes="根据用户名修改用户的详细信息（仅姓名和个人描述）")
	@ApiImplicitParams({		
		@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String",paramType="query"),	
		@ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "describes", value = "个人描述", required = true, dataType = "String",paramType="query"),
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<List<String>> updateUserDetailed(String username, String name, String describes){
	
		List<String> list=new ArrayList<>();
		
		String code=us.updateUsermessage(username, name, describes)+"";
		
		list.add(code);
		
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}
	
	
	
}
