package com.hcycom.ctginms.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.ExposeRelation;
import com.hcycom.ctginms.service.ExposeRelationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午3:47:05   
 * @name 李硕
 * @Description: 暴反关系表rest
 */
/*@RestController
@RequestMapping(value="/api/exposerelationrest")
@Api(tags={"暴反关系表"},description="暴反关系表的相关操作")
public class ExposeRelationRest {

	@Autowired
	private ExposeRelationService ers;
	
	@GetMapping("/findByArea")
	@Timed
	@ApiOperation(value="根据城市名称查询暴反关系表中的数据", notes="根据城市名称查询暴反关系表中的数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "province", value = "省", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "city", value = "市", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "area", value = "区县", required = false, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "disease", value = "疾病类型（非意外总死亡、呼吸系统疾病、循环系统疾病）", required = true, dataType = "String",paramType="query")
	})
	public ResponseEntity<List<ExposeRelation>> findByArea(String province,String city,String area,String disease){
		if(area==null||area==""||area==" "){
			area="";
		}
		List<ExposeRelation> list=ers.getExposeRelationByArea(province, city, area,disease);
		
		return new ResponseEntity<List<ExposeRelation>>(list, HttpStatus.OK);
	}
}*/
