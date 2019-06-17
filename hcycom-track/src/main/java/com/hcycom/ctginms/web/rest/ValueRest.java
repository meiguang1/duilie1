package com.hcycom.ctginms.web.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import com.hcycom.ctginms.service.ValueService;
import com.hcycom.ctginms.web.rest.vm.CityPM25AverageAndRisk;
import com.hcycom.ctginms.web.rest.vm.DailyAveragePM25;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午5:25:38   
 * @name 李硕
 * @Description: value表rest
 */
/*@RestController
@RequestMapping(value="/api/valuerest")
@Api(tags={"value表"},description="value表的相关操作")
public class ValueRest {

	@Autowired
	private ValueService vs;
	
	@GetMapping("/findValueByDistrictAndCurrenttime")
	@Timed
	@ApiOperation(value="根据城市名称和日期时段获取pm2.5每日均值", notes="根据城市名称和日期时段获取pm2.5每日均值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "province", value = "省（数组，测试时用逗号隔开）", required = true, dataType = "String[]",paramType="query"),
		@ApiImplicitParam(name = "city", value = "市（数组，测试时用逗号隔开）", required = true, dataType = "String[]",paramType="query"),
		@ApiImplicitParam(name = "district", value = "区县（数组，测试时用逗号隔开）", required = true, dataType = "String[]",paramType="query"),
		@ApiImplicitParam(name = "starttime", value = "开始时间", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "endtime", value = "结束时间", required = true, dataType = "String",paramType="query"),
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<List<List<DailyAveragePM25>>> findValueByDistrictAndCurrenttime(String[] province,String[] city,String[] district,String starttime,String endtime){
		//开始结束时间的格式化
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date sdate=new Date();
		Date edate=new Date();
		try {
			sdate = sDateFormat.parse(starttime);
			edate=sDateFormat.parse(endtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<List<DailyAveragePM25>> list=vs.getValueByDistrictAndCurrenttime(province,city,district,sdate,edate);
		
		return new ResponseEntity<List<List<DailyAveragePM25>>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/findCityPM25AverageAndRisk")
	@Timed
	@ApiOperation(value="根据城市名称和日期时段获取pm2.5该时间段平均值以及超额总死亡人数", notes="根据城市名称和日期时段获取pm2.5该时间段平均值以及超额总死亡人数")
	@ApiImplicitParams({
		//@ApiImplicitParam(name = "province", value = "省（数组，测试时用逗号隔开）", required = true, dataType = "String[]",paramType="query"),
		//@ApiImplicitParam(name = "city", value = "市（数组，测试时用逗号隔开）", required = true, dataType = "String[]",paramType="query"),
		//@ApiImplicitParam(name = "district", value = "区县（数组，测试时用逗号隔开）", required = true, dataType = "String[]",paramType="query"),
		@ApiImplicitParam(name = "disease", value = "疾病类型（非意外总死亡、呼吸系统疾病、循环系统疾病）", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "starttime", value = "开始时间", required = true, dataType = "String",paramType="query"),
		@ApiImplicitParam(name = "endtime", value = "结束时间", required = true, dataType = "String",paramType="query"),
	})
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public ResponseEntity<List<CityPM25AverageAndRisk>> findCityPM25AverageAndRisk(String[] province,String[] city,String[] district,String starttime,String endtime,String disease){
		//开始结束时间的格式化
		
		
		SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date sdate=new Date();
		Date edate=new Date();
		try {
			sdate = sDateFormat.parse(starttime);
			edate=sDateFormat.parse(endtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<CityPM25AverageAndRisk> list=vs.getCityPM25AverageAndRisk(province,city,district,sdate,edate,disease);
		
		return new ResponseEntity<List<CityPM25AverageAndRisk>>(list, HttpStatus.OK);
	}
	
	
}
*/