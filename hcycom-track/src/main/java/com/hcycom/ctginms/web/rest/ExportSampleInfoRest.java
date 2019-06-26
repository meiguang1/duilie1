package com.hcycom.ctginms.web.rest;

import com.hcycom.ctginms.domain.County;
import com.hcycom.ctginms.domain.ExportSampleInfo;
import com.hcycom.ctginms.postdomain.PostExportsamplorder;
import com.hcycom.ctginms.service.ExportSampleInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ExportSampleInfoRest
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/25 16:31
 **/
@RestController
@RequestMapping(value="/api/ExportSampleInfoRest")
@Api(tags={"出库信息管理"},description="export_sample_info表的相关操作，做入库相关操作")
public class ExportSampleInfoRest {

    @Autowired
    private ExportSampleInfoService exportSampleInfoService;

    @GetMapping("/findEsiByEventcode")
    @ApiOperation(value="获取出库操作信息", notes="根据事件编码查询export_sample_info表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query")
    })
    public ResponseEntity<List<ExportSampleInfo>> findEsiByEventcode(String eventcode){
        List<ExportSampleInfo> list =exportSampleInfoService.findEsiByEventcode(eventcode);
        return new ResponseEntity<List<ExportSampleInfo>>(list, HttpStatus.OK);
    }

    @GetMapping("/findSampleByPointorInfo")
    @ApiOperation(value="获取出库操作信息", notes="根据事件编码查询export_sample_info表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "pointname", value = "点位名称", required = false, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "entrepotname", value = "入库名称", required = false, dataType = "String",paramType="query")
    })
    public List<Map<String,?>> findSampleByPointorInfo(String eventcode, String pointname, String entrepotname){
        List<Map<String,?>> list =exportSampleInfoService.findSampleByPointorInfo(eventcode,pointname,entrepotname);
        return list;
    }

    @GetMapping("/findExportsamplemodel")
    @ApiOperation(value = "查询出库单",notes = "根据event_code、export_sampleinfo_code查询export_sample_order表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode",value = "事件编码",required = true,dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "exportsampleinfocode",value = "出库信息编码",required = true,dataType = "String",paramType = "query")
    })
    public PostExportsamplorder findExportsamplemodel(String eventcode, String exportsampleinfocode){
        List<Map<String,?>> list=exportSampleInfoService.findExportsamplemodel(eventcode, exportsampleinfocode);
        List<ExportSampleInfo> list2=exportSampleInfoService.findEsiByEventcode(eventcode);
        PostExportsamplorder postExportsamplorder=new PostExportsamplorder();
        postExportsamplorder.setList(list);
        postExportsamplorder.setNotes(list2.get(0).getNotes());
        return postExportsamplorder;
    }
}
