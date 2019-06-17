package com.hcycom.ctginms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.hcycom.ctginms.domain.ExposeRelation;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午3:30:25   
 * @name 李硕
 * @Description: 
 */
@Mapper
public interface ExposeRelationMapper {

	//通过城市名称查询暴反关系表中的数据
	List<ExposeRelation> selectExposeRelationByArea(@Param("province")String province,@Param("city")String city,@Param("area")String area,@Param("disease")String disease);
		
}
