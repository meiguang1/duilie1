package com.hcycom.ctginms.web.rest;

import com.alibaba.fastjson.JSON;
import com.hcycom.ctginms.domain.*;
import com.hcycom.ctginms.postdomain.PostExportSample;
import com.hcycom.ctginms.postdomain.PostExportSampleTwo;
import com.hcycom.ctginms.postdomain.PostExportsamplorder;
import com.hcycom.ctginms.service.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import io.swagger.annotations.*;
import io.swagger.models.Response;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;
    @Autowired
    private OperationlogService operationlogService;
    @Autowired
    private AuditSampleService auditSampleService;
    @Value("${ExportSampleUrl}")
    private String ExportSampleUrl;
    @Value("${tomcatUrl}")
    private String tomcatUrl;

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
    @ApiOperation(value="查询点位或入库名称下包含的样本信息", notes="根据事件编码、点位名称或入库名称查询sample表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "pointname", value = "点位名称", required = false, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "entrepotname", value = "入库名称", required = false, dataType = "String",paramType="query")
    })
    public List<Map<String,?>> findSampleByPointorInfo(String eventcode, String pointname, String entrepotname){
        List<Map<String,?>> list =exportSampleInfoService.findSampleByPointorInfo(eventcode,pointname,entrepotname);
        return list;
    }

    @GetMapping("/findExportsampleorder")
    @ApiOperation(value = "查询出库单",notes = "根据event_code、export_sampleinfo_code查询export_sample_order表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode",value = "事件编码",required = true,dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "exportsampleinfocode",value = "出库信息编码",required = true,dataType = "String",paramType = "query")
    })
    public PostExportsamplorder findExportsampleorder(String eventcode, String exportsampleinfocode){
        List<Map<String,?>> list=exportSampleInfoService.findExportsampleorder(eventcode, exportsampleinfocode);
        List<ExportSampleInfo> list2=exportSampleInfoService.findEsiByEventcode(eventcode);
        AuditSample auditSample=auditSampleService.findAuditByExportSampleCode(exportsampleinfocode);
        PostExportsamplorder postExportsamplorder=new PostExportsamplorder();
        postExportsamplorder.setList(list);
        postExportsamplorder.setNotes(list2.get(0).getNotes());
        postExportsamplorder.setAudit_text(auditSample.getAudit_text());
        return postExportsamplorder;
    }

    public static String getGUID()
    {
        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }

    @PostMapping("/saveExportSample")
    @ApiOperation(value = "出库确认操作",notes = "插入样本数据至入库单，同时插入出库信息和日志记录")
    public int saveExportSample(@RequestBody PostExportSample postExportSample){
        ExportSampleInfo esi=new ExportSampleInfo();
        String uuid=getGUID();
        esi.setExport_sampleinfo_code(uuid);
        esi.setExport_sample_name(postExportSample.getExport_sample_name());
        esi.setPoint_code(postExportSample.getPoint_code());
        esi.setPoint_name(postExportSample.getPoint_name());
        esi.setNotes(postExportSample.getNotes());
        List<User> user=userService.getOneUserByUsername(postExportSample.getLogin_name());
        esi.setOperator_name(user.get(0).getName());
        esi.setOperator_time(new Date());
        esi.setExport_sample_state("0");
        esi.setDetection_report_state("0");
        esi.setAudit_state("0");
        esi.setExport_file_state("0");
        esi.setEvent_code(postExportSample.getEventcode());
        int a = exportSampleInfoService.addExportsampleinfo(esi);
        for(int i=0;i<postExportSample.getList().size();i++){
            postExportSample.getList().get(i).setExport_sampleinfo_code(uuid);
        }
        if(a!=0){
            int b = exportSampleInfoService.addExportsampleorder(postExportSample.getList());
            if(b!=0){
                //获取日志信息
                OperationLog operationLog=getoperationLog(user.get(0).getId(),user.get(0).getName(),postExportSample.getEventcode());
                operationLog.setDescribe("export_sample_order,export_sample_info");
                operationLog.setOperation_txt("样本预出库");
                operationLog.setNotes(postExportSample.getNotes());
                //插入日志信息
                operationlogService.addOperationLog(operationLog);
                //获取审核信息
                AuditSample auditSample=new AuditSample();
                auditSample.setAudit_name(operationLog.getProject_name()+","+operationLog.getEvent_name()+","+postExportSample.getNotes());
                auditSample.setExport_sampleinfo_code(uuid);
                auditSample.setCreate_time(new Date());
                //插入审核信息
                auditSampleService.addAudit(auditSample);
                return 200;
            }else{
                return 500;
            }
        }else{
            return 500;
        }
    }

    @RequestMapping(value = "/readPdf", method = RequestMethod.GET)
    @ApiOperation(value = "预览当前上传的出库手续单PDF",notes = "查看单一pdf")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "export_samplefile_code",value = "上传文件编码",required = true,dataType = "String",paramType = "query")
    })
    public String readPdf(String export_samplefile_code){
        ExportSampleFile exportSampleFile = exportSampleInfoService.findExportSampleFile(export_samplefile_code);
        String url = tomcatUrl+exportSampleFile.getFile_name();
        return url;
    }
    //未完成的依赖pdf.js工具
//    @RequestMapping(value = "/readPdf", method = RequestMethod.GET)
//    @ApiOperation(value = "查看pdf",notes = "查看pdf")
//        public void readPdf(HttpServletResponse response, HttpServletRequest request){
//        String dir="H:\\cdcGit\\duilie1\\hcycom-track\\exportsample\\201906179182610.pdf";
//        File file=new File(dir);
//        if (file.exists()){
//            byte[] data = null;
//            try {
//                FileInputStream input = new FileInputStream(file);
//                data = new byte[input.available()];
//                input.read(data);
//                response.getOutputStream().write(data);
//                input.close();
//            } catch (Exception e) {
//                //logger.error("pdf文件处理异常：" + e.getMessage());
//            }
//        }else{
//            return;
//        }
//    }

    @PostMapping("/afreshExportsample")
    @ApiOperation(value = "重新出库",notes = "修改出库信息表和审核表的审核状态")
    public int afreshExportsample(@RequestBody PostExportSampleTwo postExportSampleTwo){
        //修改出库信息中的审核状态
        ExportSampleInfo esi= new ExportSampleInfo();
        esi.setAudit_state("0");
        esi.setNotes(postExportSampleTwo.getNotes());
        esi.setExport_sampleinfo_code(postExportSampleTwo.getExport_sampleinfo_code());
        int a = exportSampleInfoService.updateExportsampleinfo(esi);
        //删除出库当中的历史旧数据
        int b= exportSampleInfoService.deleExportsampleorder(postExportSampleTwo.getExport_sampleinfo_code());
        for(int i=0;i<postExportSampleTwo.getList().size();i++){
            postExportSampleTwo.getList().get(i).setExport_sampleinfo_code(postExportSampleTwo.getExport_sampleinfo_code());
        }
        //根据当前出库信息编码重新插入修改后的新数据至出库单
        int c = exportSampleInfoService.addExportsampleorder(postExportSampleTwo.getList());
        //根据出库信息编码修改审核表中的审核状态
        AuditSample as = auditSampleService.findAuditByExportSampleCode(postExportSampleTwo.getExport_sampleinfo_code());
        as.setAudit_state("0");
        as.setAudit_text("待审核");
        int d = auditSampleService.updateAudit(as);
        return 1;
    }

    @PostMapping("/lastExportsample")
    @ApiOperation(value = "最终出库操作",notes = "在审核通过后，上传出库手续单，进行最终的出库操作")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "code",value = "手续单编码",required = true,dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "name",value = "手续单名称",required = true,dataType = "String",paramType = "query"),
        @ApiImplicitParam(name = "export_sampleinfo_code",value = "出库信息编码",required = true,dataType = "String",paramType = "query")
    })
    public int lastExportsample(MultipartFile multipartFile, String code, String name, String export_sampleinfo_code) throws Exception{
        String uuid=getGUID();
        //插入出库手续单数据
        ProcedureOfSingle pos = new ProcedureOfSingle();
        pos.setCode(code);
        pos.setName(name);
        pos.setUpload_time(new Date());
        pos.setExport_sampleinfo_code(export_sampleinfo_code);
        pos.setExport_samplefile_code(uuid);
        int a = exportSampleInfoService.addProcedureOfSingle(pos);
        ExportSampleInfo esi = new ExportSampleInfo();
        esi.setExport_sampleinfo_code(export_sampleinfo_code);
        esi.setExport_sample_state("1");
        esi.setExport_file_state("1");
        esi.setDetection_report_state("1");
        //修改出库信息的出库状态和出库相关文件状态
        int b = exportSampleInfoService.updateExportsampleinfo(esi);
        //上传出库相关文件至服务器
        File directory = new File(ExportSampleUrl+"/exportsample");
        String path = directory.getCanonicalPath();
        System.out.println("文件保存的路径"+path);
        File filePath = new File(path);
        if(!filePath.exists()&&!filePath.isDirectory()) {
            System.out.println("目录不存在，创建路径"+filePath);
            filePath.mkdir();
        }
        //获取原始文件名称
        String originalFileName = multipartFile.getOriginalFilename();
        //转义拆分重命名文件
        System.out.println("原始文件的名称"+originalFileName);
        String[] strArr=originalFileName.split("\\.");
        SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMDDHHmmss");
        String strName=sdf.format(new Date());
        originalFileName=strName+"."+strArr[1];
        System.out.println("重命名文件的名称"+originalFileName);
        System.out.println(path);
        //获取文件的类型，以“.”作为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
        System.out.println("文件类型"+type);
        //在指定的路径下面创建一个新的文件
        File targerFile = new File(path,originalFileName);
        multipartFile.transferTo(targerFile);
        //插入上传文件信息至数据库
        ExportSampleFile esf = new ExportSampleFile();
        esf.setExport_samplefile_code(uuid);
        esf.setFile_name(originalFileName);
        esf.setFile_path(path);
        esf.setExport_sampleinfo_code(export_sampleinfo_code);
        exportSampleInfoService.addExportSampleFile(esf);
        return 1;
    }

    @GetMapping("/findPosBycode")
    @ApiOperation(value = "出库手续单信息获取",notes = "在上传出库手续单后，查询手续单表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "export_sampleinfo_code",value = "出库信息编码",required = true,dataType = "String",paramType = "query")
    })
    public ProcedureOfSingle findPosBycode(String export_sampleinfo_code){
        ProcedureOfSingle pos = exportSampleInfoService.findPosBycode(export_sampleinfo_code);
        return pos;
    }


    @PostMapping(value = "/uploadExportsample")
    @ApiOperation(value = "上传出库相关文件",notes = "上传文件至出库相关文件表，更新出库信息表中文件状态")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "export_sampleinfo_code",value = "出库信息编码",required = true,dataType = "String",paramType = "query")
    })
    public int uploadExportsample(MultipartFile multipartFile,String export_sampleinfo_code) throws Exception{
        String uuid=getGUID();
        //上传出库相关文件至服务器
        File directory = new File(ExportSampleUrl+"exportsample");
        String path = directory.getCanonicalPath();
        System.out.println("文件保存的路径"+path);
        File filePath = new File(path);
        if(!filePath.exists()&&!filePath.isDirectory()) {
            System.out.println("目录不存在，创建路径"+filePath);
            filePath.mkdir();
        }
        //获取原始文件名称
        String originalFileName = multipartFile.getOriginalFilename();
        //转义拆分重命名文件
        System.out.println("原始文件的名称"+originalFileName);
        String[] strArr=originalFileName.split("\\.");
        SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMDDHHmmss");
        String strName=sdf.format(new Date());
        originalFileName=strName+"."+strArr[1];
        System.out.println("重命名文件的名称"+originalFileName);
        System.out.println(path);
        //获取文件的类型，以“.”作为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
        System.out.println("文件类型"+type);
        //在指定的路径下面创建一个新的文件
        File targerFile = new File(path,originalFileName);
        multipartFile.transferTo(targerFile);
        //插入上传文件信息至数据库
        ExportSampleFile esf = new ExportSampleFile();
        esf.setExport_samplefile_code(uuid);
        esf.setFile_name(originalFileName);
        esf.setFile_path(path);
        esf.setExport_sampleinfo_code(export_sampleinfo_code);
        exportSampleInfoService.addExportSampleFile(esf);
        //修改出库信息中的文件上传状态
        ExportSampleInfo esi = exportSampleInfoService.findEsiByCode(export_sampleinfo_code);
        int a = Integer.parseInt(esi.getExport_file_state())+1;
        esi.setExport_file_state(String.valueOf(a));
        exportSampleInfoService.updateExportsampleinfo(esi);
        return 1;
    }



    @PostMapping("/addResearchReport")
    @ApiOperation(value = "样品研究报告上传",notes = "在样本出库后，上传研究报告，添加数据至报告表")
    public int addResearchReport(@RequestBody List<ResearchReport> rrlist){
        int a = exportSampleInfoService.addResearchReport(rrlist);
        if(a!=0){
            String export_sampleinfo_code = rrlist.get(0).getExport_sampleinfo_code();
            ExportSampleInfo esi = exportSampleInfoService.findEsiByCode(export_sampleinfo_code);
            esi.setDetection_report_state("2");
            int b = exportSampleInfoService.updateExportsampleinfo(esi);
            return 200;
        }else{
            return 500;
        }
    }

    @GetMapping("/findResearchReport")
    @ApiOperation(value = "样品研究报告查看",notes = "在成功上传研究报告后，根据当前出库信息编码查询报告信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "export_sampleinfo_code",value = "出库信息编码",required = true,dataType = "String",paramType = "query")
    })
    public ResponseEntity<List<ResearchReport>> findResearchReport(String export_sampleinfo_code){
        List<ResearchReport> list= exportSampleInfoService.findResearchReport(export_sampleinfo_code);
        return new ResponseEntity<List<ResearchReport>>(list, HttpStatus.OK);
    }

    @GetMapping("/combinePdf")
    @ApiOperation(value = "查看出库相关文件",notes = "将上传的pdf文件合并展示")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "export_sampleinfo_code",value = "出库信息编码",required = true,dataType = "String",paramType = "query")
    })
    public String combinePdf(String export_sampleinfo_code) throws Exception {
            List<ExportSampleFile> listEsf=exportSampleInfoService.getExportSampleFileAll(export_sampleinfo_code);
            int length=listEsf.size();
            String[] pdfFilenames=new String[length];
            for(int i=0;i<length;i++){
                String path=listEsf.get(i).getFile_path();
                String name=listEsf.get(i).getFile_name();
                pdfFilenames[i]=path+"\\"+name;
            }
//            String aa = "H:\\apache-tomcat-7.0.90\\webapps\\exportsample\\201907183165517.pdf";
//            String bb = "H:\\apache-tomcat-7.0.90\\webapps\\exportsample\\201907183182221.pdf";
            String targetFilename=ExportSampleUrl+"exportsample\\hebing.pdf";
            combinPdf(pdfFilenames,targetFilename);
            String tomcatUrlTwo = tomcatUrl+"/hebing.pdf";
            return tomcatUrlTwo;
    }

    // *********合并 pdfFilenames为文件路径数组，targetFileName为目标pdf路径
    public static void combinPdf(String[] pdfFilenames, String targetFilename) throws Exception {
        PdfReader reader = null;
        Document doc = new Document();
        PdfCopy pdfCopy = new PdfCopy(doc, new FileOutputStream(targetFilename));
        int pageCount = 0;
        doc.open();
        for (int i = 0; i < pdfFilenames.length; ++i) {
            System.out.println(pdfFilenames[i]);
            reader = new PdfReader(pdfFilenames[i]);
            pageCount = reader.getNumberOfPages();
            for (int j = 1; j <= pageCount; ++j) {
                pdfCopy.addPage(pdfCopy.getImportedPage(reader, j));
            }
        }
        doc.close();
    }

    /**
     * 渲染日志信息
     * @return
     */
    public OperationLog getoperationLog(String userid, String name, String eventcode){
        List<Map<String,?>> list=eventService.findeventAndproject(eventcode);
        OperationLog operationLog=new OperationLog();
        operationLog.setOperation_time(new Date());
        operationLog.setOperation_code(userid);
        operationLog.setOperation_name(name);
        operationLog.setProject_code(list.get(0).get("projectcode").toString());
        operationLog.setProject_name(list.get(0).get("projectname").toString());
        operationLog.setEvent_code(list.get(0).get("eventcode").toString());
        operationLog.setEvent_name(list.get(0).get("eventname").toString());
        return operationLog;
    }
}
