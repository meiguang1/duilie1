package com.hcycom.ctginms.web.rest;


import com.hcycom.ctginms.domain.ImportSampleModel;
import com.hcycom.ctginms.domain.OperationLog;
import com.hcycom.ctginms.domain.Person;
import com.hcycom.ctginms.postdomain.PostSample;
import com.hcycom.ctginms.service.SampleService;
import com.hcycom.ctginms.web.rest.util.CsvUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SampleRest
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/11 16:55
 **/
@RestController
@RequestMapping(value="/api/samplerest")
@Api(tags={"样本管理"},description="sample表的相关操作，做样本相关操作")
public class SampleRest {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/getSampleByEventtcode")
    @ApiOperation(value="获取该事件下的样本列表", notes="获取该事件下的样本列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventtcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })
    public List<Map<String,?>> getSampleByEventtcode(String eventtcode){
        List<Map<String,?>> samplelist =sampleService.getSampleByEventtcode(eventtcode);
        return samplelist;
    }

    @GetMapping("/getOperationlog")
    @ApiOperation(value="获取操作人及操作时间", notes="获取操作人及操作时间")
    public OperationLog getOperationlog(){
        String describe="sample";
        OperationLog operationLog =sampleService.getOperationlog(describe);
        return operationLog;
    }

    @PostMapping("/getQueryPage")
    @ApiOperation(value="分页加模糊查询样本列表", notes="分页加模糊查询样本列表")
    public List<Map<String,?>> getQueryPage(@RequestBody PostSample postSample){
        List<String> list = sampleService.getQueryPageone(postSample);
        List<Map<String,?>> samplelist =sampleService.getQueryPagetwo(list,postSample.getEventCode(),postSample.getStarttime(),postSample.getEndtime());
        return samplelist;
    }

    @GetMapping("/getStatistics")
    @ApiOperation(value="查询调查对象的各样本数", notes="查询调查对象的各样本数")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })
    public List<Map<String,?>> getStatistics(String eventcode){
        List<Map<String,?>> samplelist =sampleService.getStatistics(eventcode);
        return samplelist;
    }



}
