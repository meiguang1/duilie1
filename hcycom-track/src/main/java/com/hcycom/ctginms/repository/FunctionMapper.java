package com.hcycom.ctginms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.domain.Function;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月30日 下午2:45:31   
 * @name 李硕
 * @Description: 5大功能表的数据库操作
 */
@Mapper
public interface FunctionMapper {

	
	//通过项目编码查询5大功能的开关
	Function selectOneFunctionByProjectcode(@Param("projectcode")String projectcode);
	
	//通过项目id查询5大功能的开关
	Function selectOneFunctionByProjectid(@Param("projectid")String projectid);
	
	//新增项目，添加新增的项目5个功能的开关
	int insertOneFunctionNewProject(@Param("function")Function function);
	
	//修改内容，项目修改5大功能，通过项目编码projectcode
	int updateFunctionByProjectcode(@Param("function")Function function);
	
}
