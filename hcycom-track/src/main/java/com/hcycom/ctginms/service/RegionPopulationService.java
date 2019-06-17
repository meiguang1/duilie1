package com.hcycom.ctginms.service;

import java.util.List;


import com.hcycom.ctginms.domain.RegionPopulation;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午2:11:29   
 * @name 李硕
 * @Description: 区域人口数服务层
 */
public interface RegionPopulationService {

	//通过城市名称获取该城市的总人口数信息
	public List<RegionPopulation> getRegionPopulationByArea(String province,String city,String area);
	
}
