package com.hcycom.ctginms.service.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcycom.ctginms.domain.DeathRate;
import com.hcycom.ctginms.repository.DeathRateMapper;
import com.hcycom.ctginms.service.DeathRateService;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午2:58:10   
 * @name 李硕
 * @Description: 死亡率服务层实现类
 */
@Service
public class DeathRateServiceImpl implements DeathRateService{

	
	@Autowired
	private DeathRateMapper deathratemapper;
	
	
	@Override
	public List<DeathRate> getDeathRateByArea(String province, String city, String area) {
		// TODO Auto-generated method stub
		List<DeathRate> list=deathratemapper.selectDeathRateByArea(province, city, area);
		
		return list;
	}

}
