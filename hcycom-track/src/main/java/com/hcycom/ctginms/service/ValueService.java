package com.hcycom.ctginms.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.web.rest.vm.CityPM25AverageAndRisk;
import com.hcycom.ctginms.web.rest.vm.DailyAveragePM25;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午5:21:09   
 * @name 李硕
 * @Description: vlaue表服务层
 */
public interface ValueService {

	//通过城市名称和所选日期段获取日均值
	List<List<DailyAveragePM25>> getValueByDistrictAndCurrenttime(String[] province,String[] city,String[] district,Date starttime,Date endtime);
	
	//通过计算，获取该城市在某段时间内的pm2.5均值，以及超额总死亡人数
	List<CityPM25AverageAndRisk> getCityPM25AverageAndRisk(String[] province,String[] city,String[] district,Date starttime,Date endtime,String disease);
	
	
}
