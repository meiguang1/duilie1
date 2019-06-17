package com.hcycom.ctginms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.domain.DeathRate;


/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午2:48:06   
 * @name 李硕
 * @Description: 死亡率表death_rate的操作
 */
@Mapper
public interface DeathRateMapper {

	//通过城市名称查询人口死亡率表中的数据
	List<DeathRate> selectDeathRateByArea(@Param("province")String province,@Param("city")String city,@Param("area")String area);
	
}
