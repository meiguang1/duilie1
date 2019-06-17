package com.hcycom.ctginms.web.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.LinkInfo;
import com.hcycom.ctginms.repository.LinkInfoMapper;
import com.hcycom.ctginms.repository.LinkInfoRepository;
import com.hcycom.ctginms.web.rest.util.PaginationUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(tags={"链路管理"},description="查询链路相关信息")
public class LinkInfoResource {
	@Autowired private LinkInfoRepository linkInfoRepository;
	@Autowired private LinkInfoMapper linkInfoMapper;
	
	@GetMapping("/findByLinkCategory")
	@Timed
	@ApiOperation(value="根据平台ID获取链路", notes="根据平台ID获取链路，使用JPA")
	@ApiImplicitParam(name = "category", value = "平台ID", required = true, dataType = "int",paramType="query")
	public ResponseEntity<List<LinkInfo>> findByLinkCategory(Integer category){
		List<LinkInfo> linkinfos = linkInfoRepository.findByLinkcategory(category);
		return new ResponseEntity<List<LinkInfo>>(linkinfos, HttpStatus.OK);
	}
	@GetMapping("/findByCategory")
	@Timed
	@ApiOperation(value="根据平台ID获取链路", notes="根据平台ID获取链路，使用mybatis")
	@ApiImplicitParam(name = "category", value = "平台ID", required = true, dataType = "int",paramType="query")
	public ResponseEntity<List<LinkInfo>> findByCategory(Integer category){
		List<LinkInfo> linkinfos = linkInfoMapper.findByCategory(category);
		return new ResponseEntity<List<LinkInfo>>(linkinfos, HttpStatus.OK);
	}
	@GetMapping("/selectByCategory")
	@Timed
	@ApiOperation(value="根据平台ID获取链路", notes="根据平台ID获取链路，使用mybatis")
	@ApiImplicitParam(name = "category", value = "平台ID", required = true, dataType = "int",paramType="query")
	public ResponseEntity<List<LinkInfo>> selectByCategory(Integer category){
		List<LinkInfo> linkinfos = linkInfoMapper.selectLinkInfos(category);
		return new ResponseEntity<List<LinkInfo>>(linkinfos, HttpStatus.OK);
	}
	@GetMapping("/findAll")
	@Timed
	@ApiOperation(value="查询所有链路", notes="查询所有链路，分页")
	public ResponseEntity<List<LinkInfo>> findAll(Pageable pageable){
		Page<LinkInfo> page = linkInfoRepository.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/findAll");
		return new ResponseEntity<List<LinkInfo>>(page.getContent(),headers, HttpStatus.OK);
	}

}
