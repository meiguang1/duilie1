package com.hcycom.ctginms.service;

import java.util.List;

import com.hcycom.ctginms.domain.DeathRate;


/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午2:56:01   
 * @name 李硕
 * @Description: 死亡率服务层
 */
public interface DeathRateService {

	//通过城市名称获取该城市的死亡率信息
	public List<DeathRate> getDeathRateByArea(String province,String city,String area);
		
}
