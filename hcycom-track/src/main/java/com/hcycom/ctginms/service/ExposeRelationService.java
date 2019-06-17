package com.hcycom.ctginms.service;

import java.util.List;


import com.hcycom.ctginms.domain.ExposeRelation;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午3:44:05   
 * @name 李硕
 * @Description: 暴反关系服务层
 */
public interface ExposeRelationService {

	//通过城市名称获取该城市的死亡率信息
	public List<ExposeRelation> getExposeRelationByArea(String province,String city,String area,String disease);
		
}
