package com.hcycom.ctginms.service.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.domain.ExposeRelation;
import com.hcycom.ctginms.repository.ExposeRelationMapper;
import com.hcycom.ctginms.service.ExposeRelationService;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午3:44:51   
 * @name 李硕
 * @Description: 暴反关系服务层实现类
 */
@Service
public class ExposeRelationServiceImpl implements ExposeRelationService{

	@Autowired
	private ExposeRelationMapper erm;
	
	@Override
	public List<ExposeRelation> getExposeRelationByArea(String province, String city, String area,String disease) {
		// TODO Auto-generated method stub
		List<ExposeRelation> list=erm.selectExposeRelationByArea(province, city, area,disease);
		
		return list;
	}

}
