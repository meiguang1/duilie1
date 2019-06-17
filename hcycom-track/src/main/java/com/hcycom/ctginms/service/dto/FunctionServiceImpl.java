package com.hcycom.ctginms.service.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.domain.Function;
import com.hcycom.ctginms.repository.FunctionMapper;
import com.hcycom.ctginms.service.FunctionService;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年11月30日 下午2:59:21   
 * @name 李硕
 * @Description: 5大功能服务层接口实现类
 */
@Service
public class FunctionServiceImpl implements FunctionService{

	
	
	
	
	@Autowired
	private FunctionMapper fm;
	
	
	@Override
	public int addNewProjectByFunction(String gongnengsting, String projectcode, int projectid) {
		// TODO Auto-generated method stub
		
		String []gnstr=gongnengsting.split(",");
		
		Function fu=new Function();
		
		fu.setRy(Integer.parseInt(gnstr[0]));
		fu.setDw(Integer.parseInt(gnstr[1]));
		fu.setYb(Integer.parseInt(gnstr[2]));
		fu.setRk(Integer.parseInt(gnstr[3]));
		fu.setCk(Integer.parseInt(gnstr[4]));
		fu.setProjectcode(projectcode);
		fu.setProjectid(projectid);
		
		int a =fm.insertOneFunctionNewProject(fu);
		
		return a;
	}


	@Override
	public int updateFunctionByProjectcode(String gongnengsting, String projectcode) {
		// TODO Auto-generated method stub
		
		String []gnstr=gongnengsting.split(",");
		
		Function fu=new Function();
		
		fu.setRy(Integer.parseInt(gnstr[0]));
		fu.setDw(Integer.parseInt(gnstr[1]));
		fu.setYb(Integer.parseInt(gnstr[2]));
		fu.setRk(Integer.parseInt(gnstr[3]));
		fu.setCk(Integer.parseInt(gnstr[4]));
		fu.setProjectcode(projectcode);
		
		int a =fm.updateFunctionByProjectcode(fu);
		
		
		return a;
	}

}
