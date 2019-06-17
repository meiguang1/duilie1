package com.hcycom.ctginms.service;
/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月19日 下午3:29:54   
 * @name 李硕
 * @Description: 获取时间，并操作相应程序
 */
public interface TheTimeService {

	//获取当前时间，并且修改user表中，上次登录时间字段，的时间
	void getNowTimeAndChangeUserLogintime(String id);
	
}
