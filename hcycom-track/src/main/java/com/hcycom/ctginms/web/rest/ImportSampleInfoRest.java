package com.hcycom.ctginms.web.rest;

import com.hcycom.ctginms.domain.ImportSampleInfo;
import com.hcycom.ctginms.service.ImportSampleInfoService;
import com.hcycom.ctginms.service.SampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName: ImportSampleInfoRest
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/18 16:14
 **/
@RestController
@RequestMapping(value="/api/ImportSampleInfoRest")
@Api(tags={"入库信息管理"},description="Import_sample_info表的相关操作，做入库相关操作")
public class ImportSampleInfoRest {

    @Autowired
    private ImportSampleInfoService importSampleInfoService;
    @Autowired
    private SampleService sampleService;

    @GetMapping("/getSampleInfo")
    @ApiOperation(value="根据事件编码查询import_sample_info表", notes="获取入库操作信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })
    public List<ImportSampleInfo> getSampleInfo(String eventcode){
        List<ImportSampleInfo> list =importSampleInfoService.getSampleInfo(eventcode);
        return list;
    }

    public static String getGUID()
    {
        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }

    @PostMapping("/importSample")
    @ApiOperation(value="插入import_sample_info表及import_sample_model表", notes="入库操作")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "entrepot_name", value = "入库名称", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "point_name", value = "点位名称", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "operator_name", value = "操作员姓名", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "import_time", value = "上传时间", required = true, dataType = "String",paramType="query"),
    })
    public boolean importSample(@RequestParam(value="multipartFile",required=false)MultipartFile multipartFile,
                                String entrepot_name,String point_name,String operator_name,String import_time,String eventcode){
        String fileName=multipartFile.getOriginalFilename().substring(0,multipartFile.getOriginalFilename().indexOf("."));
        String uuid=getGUID();
        ImportSampleInfo importSampleInfo=new ImportSampleInfo();
        importSampleInfo.setSample_info_code(uuid);
        importSampleInfo.setEntrepot_name(entrepot_name);
        importSampleInfo.setPoint_name(point_name);
        importSampleInfo.setImport_name(fileName);
        importSampleInfo.setOperator_name(operator_name);
        importSampleInfo.setImport_time(import_time);
        importSampleInfo.setState("0");
        importSampleInfo.setEvent_code(eventcode);
        int a=importSampleInfoService.addSampleInfo(importSampleInfo);
        if(a==1){
            try {
                sampleService.importSample(multipartFile,uuid);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else{

            return false;
        }
    }
}
