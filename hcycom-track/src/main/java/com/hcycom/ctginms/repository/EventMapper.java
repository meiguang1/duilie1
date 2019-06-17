package com.hcycom.ctginms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.domain.Event;
import com.hcycom.ctginms.web.rest.vm.EventFunctionReturn;


/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月27日 上午10:49:02   
 * @name 李硕
 * @Description: 事件表持久层，操作event表
 */
@Mapper
public interface EventMapper {

	
	//根据项目编码projectcode，查询所属该项目的事件
	List<Event> selectEventByProjectcode(@Param("projectcode")String projectcode);
	
	//根据id查询该条项目
	Event selectEventById(@Param("id")int id);
	
	//新增一个事件（需要依赖该添加事件属于哪一个项目）
	int insertEventOne(@Param("event")Event event);
	
	//点击事件描述遍历5个按钮（跟随项目设置）
	EventFunctionReturn selectEventTableAndFunctonTable(@Param("eventcode")String eventcode);
	
	
	
}
