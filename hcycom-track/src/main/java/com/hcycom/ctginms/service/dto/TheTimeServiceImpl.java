package com.hcycom.ctginms.service.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.repository.UserMapper;
import com.hcycom.ctginms.service.TheTimeService;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月19日 下午3:33:42   
 * @name 李硕
 * @Description: 
 */
@Service
public class TheTimeServiceImpl implements TheTimeService{

	
	@Autowired
	private UserMapper um;
	
	
	
	@Override
	public void getNowTimeAndChangeUserLogintime(String id) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        
        
        String nowTime=df.format(new Date());
        
        int a=um.updateLogintimeById(id, nowTime);
        
        
        
		
		
	}

}
