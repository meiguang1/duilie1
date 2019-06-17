package com.hcycom.ctginms.service;
/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月30日 下午2:58:53   
 * @name 李硕
 * @Description: 5大功能服务层
 */
public interface FunctionService {

	//新项目的5个功能开关添加
	int addNewProjectByFunction(String gongnengsting,String projectcode,int projectid);
	
	//修改5大功能
	int updateFunctionByProjectcode(String gongnengsting,String projectcode);
	
	
}
