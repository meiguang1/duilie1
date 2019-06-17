package com.hcycom.ctginms.web.rest;

import com.hcycom.ctginms.domain.County;
import com.hcycom.ctginms.postdomain.PostCounty;
import com.hcycom.ctginms.postdomain.Tada;
import com.hcycom.ctginms.service.CountyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: CountyRest
 * @Description: 区县表rest接口
 * @Author: 白敏
 * @Date: 2019/4/17 13:38
 **/
@RestController
@RequestMapping(value="/api/countyrest")
@Api(tags={"区县管理"},description="county表的相关操作，做区县相关操作")
public class CountyRest {

    @Autowired
    private CountyService countyService;

    @GetMapping("/getCountyByProjectCode")
    @Timed
    @ApiOperation(value="获取该项目下的区县列表（已激活状态）", notes="获取该项目下的区县列表（已激活状态）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectcode", value = "项目编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<List<County>> getCountyByProjectCode(String projectcode){
        List<County> countylist=countyService.getCountyByProjectcode(projectcode);
        return new ResponseEntity<List<County>>(countylist, HttpStatus.OK);
    }

    @PostMapping("/addCounty")
    @Timed
    @ApiOperation(value="增加，添加单个，区县信息(返回新增区县的id)",notes="添加单个，区县信息(返回新增区县的id)")
    public ResponseEntity<String> addCounty(@RequestBody PostCounty county){

        int a = countyService.addCounty(county);
        return new ResponseEntity<String>(a+"", HttpStatus.OK);
    }

    @PostMapping("/updateCounty")
    @Timed
    @ApiOperation(value="修改区县信息",notes="修改区县信息")
    public ResponseEntity<String> updateCountyById(@RequestBody PostCounty person){
        int a = countyService.updateCountyById(person);
        return new ResponseEntity<String>(a+"", HttpStatus.OK);
    }

    @GetMapping("/deleteCounty")
    @Timed
    @ApiOperation(value="删除，通过id删除单个区县（逻辑删除，修改状态）", notes="删除，通过id删除单个区县（逻辑删除，修改状态）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "区县id", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<String> deleteCountyById(int id){
        int a = countyService.deleteCountyById(id);
        return new ResponseEntity<String>(a+"", HttpStatus.OK);
    }


    @GetMapping("/likeSelect")
    @Timed
    @ApiOperation(value="查询，按照项目编码对区县编码和区县名称进行模糊查询、分页以及返回总条数(前台返回值为空的时候需为null,不能是空字符串)")
    public  ResponseEntity<Object> likeSelect(String projectcode,String countyname,String countycode, int page ,int pageSize){
        Tada tada = countyService.likeSelect(projectcode, countyname, countycode, page, pageSize);
        return new ResponseEntity<Object>(tada, HttpStatus.OK);
    }



    @GetMapping("/getCountyBy")
    @Timed
    @ApiOperation(value="对符合条件的区县进行全部查询")
    public ResponseEntity<List<County>> getCountyBy(String projectcode){
        List<County> countylist=countyService.getCountyBy(projectcode);
        return new ResponseEntity<List<County>>(countylist, HttpStatus.OK);
    }

    @GetMapping("/likeCountyBy")
    @Timed
    @ApiOperation(value="对符合条件的区县进行模糊查询并且返回总条数 ")
    public  ResponseEntity<Object> likeCountyBy(String projectcode,String countyname,String countycode, int page ,int pageSize){
        Tada tada = countyService.likeCountyBy(projectcode, countyname, countycode, page, pageSize);
        return new ResponseEntity<Object>(tada, HttpStatus.OK);
    }
}
