package com.hcycom.ctginms.web.rest;

import com.hcycom.ctginms.domain.AuditSample;
import com.hcycom.ctginms.domain.ExportSampleInfo;
import com.hcycom.ctginms.postdomain.PostAuditSample;
import com.hcycom.ctginms.service.AuditSampleService;
import com.hcycom.ctginms.service.ExportSampleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AuditSampleRest
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/26 16:03
 **/
@RestController
@RequestMapping("/api/auditSampleRest")
@Api(tags = "审核管理",description = "audit_sample表，做审核相关操作")
public class AuditSampleRest {

    @Autowired
    private AuditSampleService auditSampleService;
    @Autowired
    private ExportSampleInfoService exportSampleInfoService;

    @GetMapping("/getAll")
    @ApiOperation(value="获取该所有审核列表", notes="查询所有audit_sample表（已激活状态）")
    public List<PostAuditSample> getAll(){
        List<AuditSample> list=auditSampleService.getAll();
        List<PostAuditSample> listALL=new ArrayList();
        List<AuditSample> list1=new ArrayList<>();
        List<AuditSample> list2=new ArrayList<>();
        List<AuditSample> list3=new ArrayList<>();
        List<AuditSample> list4=new ArrayList<>();
        List<AuditSample> list5=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getAudit_state().equals("0")){
                list1.add(list.get(i));
            }
            if(list.get(i).getAudit_state().equals("1")){
                list2.add(list.get(i));
            }
            if(list.get(i).getAudit_state().equals("2")){
                list3.add(list.get(i));
            }
            if(list.get(i).getAudit_state().equals("-1")){
                list4.add(list.get(i));
            }
            if(list.get(i).getAudit_state().equals("-2")){
                list5.add(list.get(i));
            }
        }
        PostAuditSample pb1=new PostAuditSample();
        pb1.setList(list1);
        pb1.setState("0");
        listALL.add(pb1);
        PostAuditSample pb2=new PostAuditSample();
        pb2.setList(list2);
        pb2.setState("1");
        listALL.add(pb2);
        PostAuditSample pb3=new PostAuditSample();
        pb3.setList(list3);
        pb3.setState("2");
        listALL.add(pb3);
        PostAuditSample pb4=new PostAuditSample();
        pb4.setList(list4);
        pb4.setState("-1");
        listALL.add(pb4);
        PostAuditSample pb5=new PostAuditSample();
        pb5.setList(list5);
        pb5.setState("-2");
        listALL.add(pb5);
        return listALL;
    }

    @GetMapping("/updateAudit")
    @ApiOperation(value="审核样本出库", notes="修改审核表和出库信息表中的审核状态")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "audit_state", value = "审核状态", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "audit_text", value = "审核评论", required = false, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "audit_code", value = "审核编码", required = true, dataType = "String",paramType="query"),
    })
    public int updateAudit(String audit_state,String audit_text,String audit_code){
        AuditSample as = new AuditSample();
        as.setAudit_state(audit_state);
        if(audit_state.equals("1")){
            as.setAudit_text("通过");
        }
        if(audit_state.equals("-1")){
            as.setAudit_text(audit_text);
        }
        as.setAudit_code(audit_code);
        int a = auditSampleService.updateAudit(as);
        if(a!=0){
            AuditSample as1=auditSampleService.findAuditBycode(audit_code);
            ExportSampleInfo esi = new ExportSampleInfo();
            if(audit_state.equals("1")){
                esi.setAudit_state("2");
            }
            if(audit_state.equals("-1")){
                esi.setAudit_state("1");
            }
            esi.setExport_sampleinfo_code(as1.getExport_sampleinfo_code());
            exportSampleInfoService.updateExportsampleinfo(esi);
            return 200;
        }else{

            return 500;
        }
    }
    @GetMapping("/delAudit")
    @ApiOperation(value="删除、还原审核信息", notes="修改当前审核数据的审核状态")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "audit_code", value = "审核编码", required = true, dataType = "String",paramType="query")
    })
    public int delAudit(String audit_code){
        AuditSample auditSample=auditSampleService.findAuditBycode(audit_code);
        String audit_state="";
        if(auditSample.getAudit_state().equals("1")){
            audit_state="2";
        }
        if(auditSample.getAudit_state().equals("-1")){
            audit_state="-2";
        }
        if(auditSample.getAudit_state().equals("2")){
            audit_state="1";
        }
        if(auditSample.getAudit_state().equals("-2")){
            audit_state="-1";
        }
        AuditSample as=new AuditSample();
        as.setAudit_code(audit_code);
        as.setAudit_state(audit_state);
        int a = auditSampleService.updateAudit(as);
        if(a!=0){

            return 200;
        }else{
            return 500;
        }
    }

}
