package com.hcycom.ctginms.service;

import java.util.List;
import java.util.Map;

import com.hcycom.ctginms.domain.Event;
import com.hcycom.ctginms.web.rest.vm.EventFunctionReturn;

/**
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月27日 上午10:54:13
 * @name 李硕
 * @Description: 事件表服务层的操作
 */
public interface EventService {

	//根据项目编码，获取所属项目的事件列表
	List<Event> getEventByProject(String projectcode);

	//新增事件（某一项目的新增，不可单独新增）
	Event addOneEventByProject(String projectcode,String eventname,String eventdescribes,String eventusername);

	//点击事件描述遍历5个按钮（跟随项目设置）
	EventFunctionReturn getEventTableAndFunctonTable(String eventcode);

    List<Map<String,?>> findeventAndproject(String eventcode);

    //<!--事件设置:事件名称修改-->
    int rename(String eventname,String eventcode,String creatusername);

    //<!--事件设置:事件描述修改-->
    int describe(String eventdescribes,String eventcode,String creatusername);

    //<!--事件设置:事件描述修改-->
    int deleteEvents(String eventcode);


}
