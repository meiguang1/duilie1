package com.hcycom.ctginms.service.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.domain.Event;
import com.hcycom.ctginms.repository.EventMapper;
import com.hcycom.ctginms.service.EventService;
import com.hcycom.ctginms.web.rest.vm.EventFunctionReturn;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月27日 上午10:56:05   
 * @name 李硕
 * @Description: 事件表的服务层接口实现类
 */
@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventMapper em;
	
	
	
	@Override
	public List<Event> getEventByProject(String projectcode) {
		// TODO Auto-generated method stub
		
		List<Event> list=em.selectEventByProjectcode(projectcode);
		
		
		return list;
	}



	@Override
	public Event addOneEventByProject(String projectcode, String eventname, String eventdescribes,String eventusername) {
		// TODO Auto-generated method stub
		
		
		Event event=new Event();
		
		
		
		event.setProjectcode(projectcode);
		event.setEventname(eventname);
		event.setCreatusername(eventusername);
		event.setEventdescribes(eventdescribes);
		
		
		
		em.insertEventOne(event);
		
		int a=event.getId();
		
//		System.out.println("ID为："+a);
		
		event=em.selectEventById(a);
		
//		System.out.println("新事件的code:"+event.getEventcode());
		
		return event;
	}



	@Override
	public EventFunctionReturn getEventTableAndFunctonTable(String eventcode) {
		// TODO Auto-generated method stub
		
		EventFunctionReturn efr = em.selectEventTableAndFunctonTable(eventcode);
		
		
		return efr;
	}



	
	

}
