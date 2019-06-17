package com.hcycom.ctginms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hcycom.ctginms.domain.LinkInfo;


@Mapper
public interface LinkInfoMapper {
	List<LinkInfo> selectLinkInfos(@Param("category")Integer category);

	@Select("select link_id linkid,delay_threshold delaythreshold,device_a_id deviceaid,device_z_id devicezid,link_category linkcategory"
		+ " from hcy_mn_link_info where link_category = ${category}")
	List<LinkInfo> findByCategory(@Param("category")Integer category);

}
