package com.hcycom.ctginms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.domain.RegionPopulation;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 上午11:47:17   
 * @name 李硕
 * @Description: 区域人口数表regio_pnopulation的操作
 */
@Mapper
public interface RegionPopulationMapper {

	//通过城市名称查询区域人口数表中的数据
	List<RegionPopulation> selectregionpopulationByArea(@Param("province")String province,@Param("city")String city,@Param("area")String area);
	
	
	
}
