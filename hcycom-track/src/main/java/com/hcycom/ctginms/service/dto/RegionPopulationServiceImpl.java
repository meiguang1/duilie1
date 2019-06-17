package com.hcycom.ctginms.service.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.domain.RegionPopulation;
import com.hcycom.ctginms.repository.RegionPopulationMapper;
import com.hcycom.ctginms.service.RegionPopulationService;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午2:17:58   
 * @name 李硕
 * @Description: 人口数服务层实现类
 */
@Service
public class RegionPopulationServiceImpl implements RegionPopulationService{

	@Autowired
	private RegionPopulationMapper rpm;
	
	@Override
	public List<RegionPopulation> getRegionPopulationByArea(String province, String city, String area) {
		// TODO Auto-generated method stub
		List<RegionPopulation> list=rpm.selectregionpopulationByArea(province, city, area);
		
		return list;
	}

}
