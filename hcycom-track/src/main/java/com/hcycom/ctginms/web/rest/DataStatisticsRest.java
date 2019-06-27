package com.hcycom.ctginms.web.rest;



import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.postdomain.PostDataStatistics;
import com.hcycom.ctginms.service.dto.DataStatisticsServiceImpl;
import com.hcycom.ctginms.service.dto.PtServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*数据统计模块功能实现*/
@RestController
@RequestMapping(value="/api/dataStatistics")
@Api(tags={"数据统计"},description="level_management和researcher表的相关操作，数据统计的实现")
public class DataStatisticsRest {
    @Autowired
    private DataStatisticsServiceImpl dataStatistics;

    @GetMapping("/sampleSize")
    @Timed
    @ApiOperation(value="数据统计:调查人数",notes = "(查询level_management表的点位编号、点位名称、预计调查人数,查询researcher表的实际调查人数)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<Object> sampleSize(String eventcode){
        PostDataStatistics list=dataStatistics.sampleSize(eventcode);
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

    @GetMapping("/maleFemaleRatio")
    @Timed
    @ApiOperation(value="数据统计:男女比例树状图",notes = "(查询researcher表各个点位的男女数量以及该事件下男女总数)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<Object> maleFemaleRatio(String eventcode){
        PostDataStatistics list=dataStatistics.maleFemaleRatio(eventcode);
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }


    @GetMapping("/theAgeRatio")
    @Timed
    @ApiOperation(value="数据统计:年龄比例柱状图",notes = "(查询researcher表各点位的年龄段的数据统计以及人数总计)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<Object> theAgeRatio(String eventcode){
        PostDataStatistics list=dataStatistics.theAgeRatio(eventcode);
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

}
