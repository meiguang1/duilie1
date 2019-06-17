package com.hcycom.ctginms.web.rest;


import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hcycom.ctginms.domain.ImportSampleModel;
import com.hcycom.ctginms.domain.OperationLog;
import com.hcycom.ctginms.postdomain.PostSample;
import com.hcycom.ctginms.service.SampleService;
import com.hcycom.ctginms.web.rest.util.CsvUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * 删除
     *
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @PostMapping("/files")
    @ApiOperation(value="查询调查对象的各样本数", notes="查询调查对象的各样本数")
    public List<String> files(@RequestParam(value="multipartFile",required=false)MultipartFile multipartFile,String paths,HttpServletRequest request) throws Exception{
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File filePath = new File(path);
        System.out.println("文件保存的路径"+path);
        if(!filePath.exists()&&!filePath.isDirectory()) {

            System.out.println("目录不存在，创建路径"+filePath);
            filePath.mkdir();
        }
        //获取原始文件名称
        String originalFileName = multipartFile.getOriginalFilename();
        System.out.println("原始文件的名称"+originalFileName);

        System.out.println(paths);

        //获取文件的类型，以“.”作为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
        System.out.println("文件类型"+type);
        //在指定的路径下面创建一个新的文件
        File targerFile = new File(path,originalFileName);

        multipartFile.transferTo(targerFile);

        CsvUtils csvUtils=new CsvUtils();
        List<String> samplelist =csvUtils.importCsv(targerFile);
        List<ImportSampleModel> importList=new ArrayList<ImportSampleModel>();
        if(samplelist!=null && !samplelist.isEmpty()){
            for(String data : samplelist){
                ImportSampleModel importModel=new ImportSampleModel();
                String[] aa = data.split(",");
                importModel.setId(Integer.parseInt(aa[0]));
                importModel.setPerson_code(aa[1]);
                importModel.setPerson_name(aa[2]);
                importModel.setSample_code(aa[3]);
                importModel.setSample_type(aa[4]);
                importModel.setCapacity(aa[5]);
                importModel.setCryopreserved_code(aa[6]);
                importModel.setCryopreserved_line(Integer.parseInt(aa[7]));
                importModel.setCryopreserved_column(Integer.parseInt(aa[8]));
                importModel.setSubpackage_time(aa[9]);
                importModel.setOffset_number(Integer.parseInt(aa[10]));
                importModel.setRefrigerator_code(aa[11]);
                importModel.setRefrigerator_layer(Integer.parseInt(aa[12]));
                importModel.setSample_shelf(aa[13]);
                importModel.setSamplebox_code(aa[14]);
                String bb = (aa[15]+','+aa[16]).replace("\"", "");
                importModel.setBox_place(bb);
                importModel.setHead(aa[17]);
                importList.add(importModel);
                System.out.println(importModel);
            }
        }
        int aa = sampleService.importSample(importList);
        deleteFile(targerFile);
        return samplelist;
    }

}
