package com.hcycom.ctginms.service.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.domain.User;
import com.hcycom.ctginms.postdomain.PostCheckLogin;
import com.hcycom.ctginms.repository.UserMapper;
import com.hcycom.ctginms.service.TheTimeService;
import com.hcycom.ctginms.service.UserService;
import com.hcycom.ctginms.service.tool.TestMDFive;
import com.hcycom.ctginms.web.rest.vm.CheckLoginReturn;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月16日 下午5:25:14   
 * @name 李硕
 * @Description: 用户表服务层接口,实现类
 */
@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserMapper um;
	
	
	@Autowired
	private TestMDFive md5;
	
	@Autowired
	private TheTimeService tts;
	
	
	
	@Override
	public List<CheckLoginReturn> CheckLogin(PostCheckLogin clogin) {
		// TODO Auto-generated method stub
		
		
		
		List<User> ulist=um.selectUserByUsername(clogin.getUsername());
		
		List<CheckLoginReturn> clist=new ArrayList<>();
		
		
		
		//验证是否账号存在，不存在，返回状态吗checkcode：0
		if(0==ulist.size()){
			CheckLoginReturn clr=new CheckLoginReturn();
			clr.setCheckcode("0");
			clist.add(clr);
		} else{
			//验证是否账号冻结，冻结，返回状态吗checkcode：3
			if(ulist.get(0).getState().equals("2")){
				CheckLoginReturn clr=new CheckLoginReturn();
				clr.setCheckcode("3");
				clist.add(clr);
			}else{
				//验证未冻结账号，密码是否正确，正确，返回状态吗checkcode：1
				if(md5.meMD5(clogin.getPassword()).equals(ulist.get(0).getPassword())){
					CheckLoginReturn clr=new CheckLoginReturn();
					clr.setId(ulist.get(0).getId());
					clr.setUsername(clogin.getUsername());
					clr.setName(ulist.get(0).getName());
					clr.setRole(ulist.get(0).getRole());
					clr.setImage(ulist.get(0).getImage());
					clr.setLogintime(ulist.get(0).getLogintime());
					clr.setCheckcode("1");
					clr.setDescribes(ulist.get(0).getDescribes());
					clist.add(clr);
					tts.getNowTimeAndChangeUserLogintime(ulist.get(0).getId());
					
				}else{
					//验证未冻结账号，密码是否正确，错误，返回状态吗checkcode：2
					CheckLoginReturn clr=new CheckLoginReturn();
					clr.setCheckcode("2");
					clist.add(clr);
				}
				
				
			}
									
			
		}
		
		
		
		
		
		
		return clist;
	}



	@Override
	public int updatePassword(String username, String passworda, String passwordb) {
		// TODO Auto-generated method stub
		
		int a=3;
		
		List<User> ulist=um.selectUserByUsername(username);
		
		if(ulist.get(0).getPassword().equals(md5.meMD5(passworda))){
			passwordb=md5.meMD5(passwordb);
			um.updatePasswordByUsername(username, passwordb);
			a=1;
		}else if(!(ulist.get(0).getPassword().equals(md5.meMD5(passworda)))){
			a=2;
		}
		
		
		
		return a;
	}



	@Override
	public List<User> getOneUserByUsername(String username) {
		// TODO Auto-generated method stub
		
		
		List<User> ulist=um.selectOneByUsernameNoPassword(username);
		
		
		
		return ulist;
	}



	@Override
	public int updateUsermessage(String username, String name, String describes) {
		// TODO Auto-generated method stub
		
		int a=um.updateUserMessageByUsername(username, name, describes);
		
		return a;
	}



	

	
	
	
	
	
	
}
