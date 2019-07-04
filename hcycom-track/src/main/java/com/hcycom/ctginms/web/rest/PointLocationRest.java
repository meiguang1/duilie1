package com.hcycom.ctginms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.PointLocation;
import com.hcycom.ctginms.domain.Report;
import com.hcycom.ctginms.postdomain.PostFm;
import com.hcycom.ctginms.postdomain.PostFmReport;
import com.hcycom.ctginms.postdomain.PostPt;
import com.hcycom.ctginms.service.dto.OtherFilesServiceImpl;
import com.hcycom.ctginms.service.dto.PointLocationServiceImpl;
import com.hcycom.ctginms.web.rest.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/level_management")
@Api(tags={"点位管理"},description="level_management和other_files表的相关操作，做点位管理的相关操作")
public class PointLocationRest {
    @Value("${pointpath}")
    String pointpath;
    @Autowired
    private PointLocationServiceImpl ps;
    @Autowired
    private OtherFilesServiceImpl fm;

    @GetMapping("/getEventAll")
    @Timed
    @ApiOperation(value = "获取点位管理模块中某个事件下的点位列表", notes = "(数据库level_management点位管理表的相关操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String", paramType = "query"),
    })
    public ResponseEntity<List<PointLocation>> getAll(String eventcode) {

        List<PointLocation> listUsers = ps.getEventAll(eventcode);
        return new ResponseEntity<List<PointLocation>>(listUsers, HttpStatus.OK);
    }


    @GetMapping("/selectReport")
    @Timed
    @ApiOperation(value = "获取其他文件管理中所有的文件类型(report文件类型表的操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String", paramType = "query"),
    })
    public List<Report> selectReport(String pid) {
        List<Report> reports = fm.selectReport(pid);
        return reports;
    }

    @GetMapping("/likeSelectfm")
    @Timed
    @ApiOperation(value = "获取其他文件管理中所有的文件类型总数以及文件上传个数(report文件类型表的操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String", paramType = "query"),
    })
    public PostFm likeSelect(String pid) {
        PostFm postFm = fm.likeSelectfm(pid);
        return postFm;
    }


    @PostMapping("/addOnePerson")
    @Timed
    @ApiOperation(value = "增加，点位管理模块添加单个以及添加多条", notes = "(数据库level_management点位管理表的操作)")
   /* @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "人员id", required = true, dataType = "rcList",paramType="query"),
    })*/
    public String addOnePerson(@RequestBody List<PointLocation> rcList) {
        ArrayList<String> list = new ArrayList<>();
        try {
            for (PointLocation pt : rcList) {
                list.add(pt.getCountycode());
            }
            int i1 = ps.selectByIds(list);
            if (i1 > 0 && rcList.size() > 0) {
//                数据库已经存在添加的名称已存在
                return "no";
            }
            ps.insetPersons(rcList);

//            for (int i=0;i<rcList.size();i++) {
//                int a = ps.addOnePerson(rcList.get(i));
//            }
        } catch (Exception e) {
            return "no";
        }
        return "Yes";
    }


    @GetMapping("/delete")
    @Timed
    @ApiOperation(value = "删除，通过pid删除点位管理模块的单个点位", notes = "(level_management点位管理表的操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String", paramType = "query"),
    })
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public boolean deleteUser(@RequestParam(value = "pid", required = true) String pid) {
        boolean flag = false;
        try {
            ps.delete(pid);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }


    //查询，按照事件编码对点位编码以及点位名称进行模糊查询并进行分页
    @GetMapping("/likeSelect")
    @Timed
    @ApiOperation(value = "查询,按照事件编码对点位管理模块进行进行模糊查询以及分页并返回总条数", notes = "(level_management点位管理表的相关操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "countyname", value = "区县名称", required = false, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "countycode", value = "区县编码", required = false, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "pageSize", value = "每页的条数", required = true, dataType = "int", paramType = "query"),
    })
    public ResponseEntity<Object> likeSelect(String eventcode, String countyname, String countycode, int page, int pageSize) {
        PostPt tada = ps.likeSelect(eventcode, countyname, countycode, page, pageSize);
        return new ResponseEntity<Object>(tada, HttpStatus.OK);
    }


    @PostMapping("/doUploadOne")
    @Timed
    @ApiOperation(value = "点位管理模块的单文件上传", notes = "(level_management点位管理表的相关操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "fmurl", value = "文件名称", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "countycode", value = "区县编码", required = true, dataType = "String", paramType = "query"),
    })
    public ResponseEntity<PointLocation> filesUpload(MultipartFile uploadFile, HttpServletRequest request, String fmurl, String pid, String eventcode, String countycode) throws IOException {
        /*System.out.println("uploadFile = " + uploadFile);
        //获得文件
        byte[] buf = uploadFile.getBytes();
        System.out.println("文件长度" + buf.length);
        //文件名
        System.out.println("文件名getName = " + uploadFile.getName());
        System.out.println("文件名getOriginalFilename = "
            + uploadFile.getOriginalFilename());

        //文件名    a.txt
        String originalFileName = uploadFile.getOriginalFilename();*/
        //String url=System.getProperty("user.dir").replaceAll("\\\\", "/");
        String fileUrl = pointpath + File.separator + "medical_examination_report" + File.separator + fmurl;
        //String fileUrl ="D:\\"+fmurl;
        //String fileUrl="\\\\http://39.98.182.94:8080/file/";
        System.out.println("_________________________" + fmurl);
        //换成  服务器地址+ fileUrl
        //fileUrl = request.getSession().getServletContext().getRealPath(fileUrl);

        System.out.println("fileUrl = " + fileUrl);

        FileUtil.writeFileToUrl(uploadFile, fileUrl);
        String fileUrl1 = pointpath + File.separator + "medical_examination_report" + File.separator + fmurl;
        PointLocation fileInfo = new PointLocation();
        fileInfo.setPersonCount(fmurl);
        fileInfo.setHealthForm(fileUrl1);
        fileInfo.setPid(pid);
        fileInfo.setEventcode(eventcode);
        fileInfo.setCountycode(countycode);
        ps.filesUpload(fileInfo);
        return new ResponseEntity<PointLocation>(fileInfo, HttpStatus.OK);
    }


    @GetMapping("/selectAllFile")
    @Timed
    @ApiOperation(value = "点位管理模块的单文件下载", notes = "(level_management表的操作，在其他文件中进行下载)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pid", value = "事件编码", required = true, dataType = "String", paramType = "query"),
    })
    public ResponseEntity<List<PointLocation>> selectAllFile(String pid) {

        List<PointLocation> listUsers = ps.selectAllFile(pid);
        return new ResponseEntity<List<PointLocation>>(listUsers, HttpStatus.OK);
    }


    @GetMapping("/selectAll")
    @Timed
    @ApiOperation(value = "查询其他文件模块中某个文件类型下文件的详情以及总条数", notes = "(other_files其他文件表的操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "reportcode", value = "文件编码", required = true, dataType = "String", paramType = "query"),
    })
    public ResponseEntity<Object> selectAll(String pid, String reportcode) {
        PostFmReport listUsers = fm.selectAll(pid, reportcode);
        return new ResponseEntity<Object>(listUsers, HttpStatus.OK);
    }


    @PostMapping("/addOnereport")
    @Timed
    @ApiOperation(value = "增加，添加文件类型(单个以及添加多条)", notes = "(report文件类型表的操作)")
   /* @ApiImplicitParams({
        @ApiImplicitParam(name = "reportname", value = "文件名称", required = true, dataType = "String",paramType="query"),
    })*/
    public String addOnereport(@RequestBody List<Report> rcList) {
        try {
            for (int i = 0; i < rcList.size(); i++) {
                int a = fm.addOnereport(rcList.get(i));
            }
        } catch (Exception e) {
            return "no";
        }
        return "Yes";
    }


    @GetMapping("/deleteFile")
    @Timed
    @ApiOperation(value = "删除,在其他文件模块中通过id删除单个文件类型", notes = "(report文件类型表的操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "其他文件id", required = true, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "pid", value = "事件编码", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "reportcode", value = "文件类型编码", required = true, dataType = "String", paramType = "query"),
    })
    public boolean deleteFile(int id, String pid, String reportcode) {
        boolean flag = false;
        try {
            fm.deleteFile(id, pid, reportcode);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }


    @GetMapping("/healthForm")
    @Timed
    @ApiOperation(value = "查询点位管理模块已上传文件的路劲和名字")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String", paramType = "query"),
    })
    public List<PointLocation> healthForm(String pid, String eventcode) {

        List<PointLocation> list = ps.healthForm(pid, eventcode);
        //String  listUsers = ps.healthForm(pid,eventcode);
        return list;
    }


    /*@GetMapping("/FmselectEventAll")
    @Timed
    @ApiOperation(value="获取该点位下的其他文件列表（已激活状态）", notes="获取该点位下的其他文件列表（已激活状态）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<Object> FmselectEventAll(String pid){

        PostFm listUsers = fm.FmselectEventAll(pid);
        return new ResponseEntity<Object>(listUsers, HttpStatus.OK);
    }*/


    /*@GetMapping("/FmhealthForm")
    @Timed
    @ApiOperation(value="获取该点位下的其他文档列表中的文档是否上传（已激活状态）", notes="获取该点位下的其他文档分列表中的文档是否上传（已激活状态）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "点位id", required = true, dataType = "int",paramType="query"),
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String",paramType="query"),
    })
    public String FmhealthForm(String pid,int id){

        String  listUsers = fm.FmhealthForm(pid,id);
        return listUsers;
    }*/


}
