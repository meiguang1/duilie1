package com.hcycom.ctginms.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.DeathRate;
import com.hcycom.ctginms.service.DeathRateService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午3:01:21   
 * @name 李硕
 * @Description: 死亡率的rest
 */
/*@RestController
@RequestMapping(value="/api/deathraterest")
@Api(tags={"人口死亡率表"},description="人口死亡率表的相关操作")
public class DeathRateRest {

	@Autowired
	private DeathRateService drs;
	
	@GetMapping("/findByArea")
	@Timed
	@ApiOperation(value="根据城市名称查询人口死亡率表中的数据", notes="根据城市名称查询人口死亡率表中的数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "province", value = "省", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "city", value = "市", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "area", value = "区县", required = true, dataType = "String",paramType="query")
	})
	public ResponseEntity<List<DeathRate>> findByArea(String province,String city,String area){
		List<DeathRate> list=drs.getDeathRateByArea(province, city, area);
		
		return new ResponseEntity<List<DeathRate>>(list, HttpStatus.OK);
	}
}*/
