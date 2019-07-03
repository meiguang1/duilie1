package com.hcycom.ctginms.web.rest;

import com.hcycom.ctginms.domain.*;
import com.hcycom.ctginms.postdomain.PostOperationLog;
import com.hcycom.ctginms.postdomain.PostSample;
import com.hcycom.ctginms.postdomain.PostSampleOne;
import com.hcycom.ctginms.postdomain.PostSampletwo;
import com.hcycom.ctginms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    @Autowired
    private UserService userService;
    @Autowired
    private OperationlogService operationlogService;
    @Autowired
    private EventService eventService;

    @GetMapping("/getSampleInfo")
    @ApiOperation(value="获取入库操作信息", notes="根据事件编码查询import_sample_info表")
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
    @ApiOperation(value="新建入库操作", notes="插入import_sample_info表及import_sample_model表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "entrepot_name", value = "入库名称", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "point_name", value = "点位名称", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "username", value = "登录名", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "import_time", value = "上传时间", required = true, dataType = "String.",paramType="query"),
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })
    public boolean importSample(@RequestParam(value="multipartFile",required=false)MultipartFile multipartFile,
                                String entrepot_name, String point_name, String username, String import_time, String eventcode) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date import_time1=sdf.parse(import_time);
        String fileName=multipartFile.getOriginalFilename().substring(0,multipartFile.getOriginalFilename().indexOf("."));
        String uuid=getGUID();
        List<User> user=userService.getOneUserByUsername(username);
        ImportSampleInfo importSampleInfo=new ImportSampleInfo();
        importSampleInfo.setSample_info_code(uuid);
        importSampleInfo.setEntrepot_name(entrepot_name);
        importSampleInfo.setPoint_name(point_name);
        importSampleInfo.setImport_name(fileName);
        importSampleInfo.setOperator_name(user.get(0).getName());
        importSampleInfo.setImport_time(import_time1);
        importSampleInfo.setState("0");
        importSampleInfo.setEvent_code(eventcode);
        OperationLog operationLog=getoperationLog(import_time1,user.get(0).getId(),user.get(0).getName(),eventcode);
        operationLog.setDescribe("import_sample_model,import_sample_info");
        operationLog.setOperation_txt("样本预入库");
        int a=sampleService.importSampleModel(multipartFile,uuid);
        if(a!=0){
            int b=importSampleInfoService.addSampleInfo(importSampleInfo);
            if(b!=0){
                operationlogService.addOperationLog(operationLog);
            }
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/findSampleModelByCode")
    @ApiOperation(value="根据入库信息编码查询虚拟库数据", notes="虚拟库import_sample_model数据查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "sampleModeCode", value = "入库信息编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<List<ImportSampleModel>> findSampleModelByCode(String sampleModeCode){
        List<ImportSampleModel> list=sampleService.findSampleModelByCode(sampleModeCode);
        return new ResponseEntity<List<ImportSampleModel>>(list, HttpStatus.OK);
    }

//    @PostMapping("/addSample")
//    @ApiOperation(value="修改上传文件数据，插入数据至正式样本库中", notes="插入数据至sample表中")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "nowtime", value = "当前时间", required = false, dataType = "String",paramType="query"),
//        @ApiImplicitParam(name = "loginname", value = "登录用户名", required = false, dataType = "String",paramType="query"),
//        @ApiImplicitParam(name = "projectcode", value = "项目编码(项目编码和事件编码至少有一个)", required = false, dataType = "String",paramType="query"),
//        @ApiImplicitParam(name = "eventcode", value = "事件编码(项目编码和事件编码至少有一个)", required = false, dataType = "String",paramType="query"),
//        @ApiImplicitParam(name = "notes", value = "备注信息", required = false, dataType = "String",paramType="query"),
//    })
//    public boolean addSample(@RequestBody List<PostSampletwo> sampleList,String nowtime,String loginname,String projectcode,String eventcode,String notes) throws Exception{
//        List<User> user=userService.getOneUserByUsername(loginname);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date import_time1=sdf.parse(nowtime);
//        String usercode=user.get(0).getId();
//        String username=user.get(0).getName();
//        //获取日志信息
//        OperationLog operationLog=getoperationLog(import_time1,usercode,username,eventcode);
//        operationLog.setNotes(notes);
//        operationLog.setOperation_txt("样本正式入库");
//        //添加数据至样本正式库
//        int a=sampleService.addSample(sampleList);
//            if(a!=0){
//            //添加一条日志
//            operationlogService.addOperationLog(operationLog);
//            //从虚拟库中删除已经正式入库的数据
//            importSampleInfoService.delSampleModelByCode(sampleList.get(0).getSample_info_code());
//            return true;
//        }else{
//
//            return false;
//        }
//    }

    @PostMapping("/addSample")
    @ApiOperation(value="修改上传文件数据，插入数据至正式样本库中", notes="插入数据至sample表中")
    public boolean addSample(@RequestBody PostSampleOne sampleList) throws Exception{
        List<User> user=userService.getOneUserByUsername(sampleList.getLoginname());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date import_time1=sdf.parse(sampleList.getNowtime());
        String usercode=user.get(0).getId();
        String username=user.get(0).getName();
        //获取日志信息
        OperationLog operationLog=getoperationLog(import_time1,usercode,username,sampleList.getEventcode());
        operationLog.setNotes(sampleList.getNotes());
        operationLog.setDescribe("sample");
        operationLog.setOperation_txt("样本正式入库");
        //添加数据至样本正式库
        int a=sampleService.addSample(sampleList.getSampleList());
        if(a!=0){
            //修改入库信息表中的状态
            importSampleInfoService.updateSampleInfo(sampleList.getSampleList().get(0).getSample_info_code());
            //添加一条日志
            operationlogService.addOperationLog(operationLog);
            //从虚拟库中删除已经正式入库的数据
            importSampleInfoService.delSampleModelByCode(sampleList.getSampleList().get(0).getSample_info_code());
            return true;
        }else{

            return false;
        }
    }

    @GetMapping("/findSampleByxnCode")
    @ApiOperation(value="根据入库信息编码查询已录入正式库中的数据", notes="根据sample_info_code查询sample表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "sampleInfoCode", value = "入库信息编码", required = true, dataType = "String",paramType="query"),
    })
    public List<Map<String,?>> findSampleByxnCode(String sampleInfoCode){
        System.out.println("__________________________________");
        List<Map<String,?>> samplelist=importSampleInfoService.findSampleByxnCode(sampleInfoCode);
        return samplelist;
    }


    /**
     * 渲染日志信息
     * @return
     */
    public OperationLog getoperationLog(Date time, String userid, String name, String eventcode){
        List<Map<String,?>> list=eventService.findeventAndproject(eventcode);
        OperationLog operationLog=new OperationLog();
        operationLog.setOperation_time(time);
        operationLog.setOperation_code(userid);
        operationLog.setOperation_name(name);
        operationLog.setProject_code(list.get(0).get("projectcode").toString());
        operationLog.setProject_name(list.get(0).get("projectname").toString());
        operationLog.setEvent_code(list.get(0).get("eventcode").toString());
        operationLog.setEvent_name(list.get(0).get("eventname").toString());
        return operationLog;
    }
}
