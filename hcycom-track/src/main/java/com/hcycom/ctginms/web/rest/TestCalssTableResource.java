package com.hcycom.ctginms.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.TestClassTable;
import com.hcycom.ctginms.domain.TestTable;
import com.hcycom.ctginms.repository.TestClassTableRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 *@author 小硕硕
 *@date 2018年3月13日 下午4:03:06
 *测试
 */
/*@RestController
@RequestMapping(value="/api/testclasstable")
@Api(tags={"测试班级表"},description="测试班级表的相关操作")
public class TestCalssTableResource {

	
	@Autowired
	private TestClassTableRepository tctrep;
	
	
	
	@GetMapping("/findClassTableByNmae")
	@Timed
	@ApiOperation(value="根据班级名获取表数据", notes="根据班级名获取表数据，使用JPA的@Query自定义的SQL语句")
	@ApiImplicitParam(name = "tcname", value = "测试表的名字", required = true, dataType = "String",paramType="query")
	public ResponseEntity<TestClassTable> findClassTableByNmae(String tcname){
		TestClassTable tc = tctrep.findByTcname(tcname);
		
		return new ResponseEntity<TestClassTable>(tc, HttpStatus.OK);
	}
	
}*/
