package com.hcycom.ctginms.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hcycom.ctginms.web.rest.vm.DailyAveragePM25;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午4:35:05   
 * @name 李硕
 * @Description: value表的操作
 */
@Mapper
public interface ValueMapper {

	//通过城市名称计算一段时间内每天的pm2.5日均值
	List<DailyAveragePM25> selectValueByDistrictAndCurrenttime(@Param("province")String province,@Param("city")String city,@Param("district")String district,@Param("starttime")Date starttime,@Param("endtime")Date endtime);
}
