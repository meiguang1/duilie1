package com.hcycom.ctginms.web.rest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.Pt;
import com.hcycom.ctginms.domain.Report;
import com.hcycom.ctginms.postdomain.PostFm;
import com.hcycom.ctginms.postdomain.PostFmReport;
import com.hcycom.ctginms.postdomain.PostPt;
import com.hcycom.ctginms.service.dto.FmServiceImpl;
import com.hcycom.ctginms.service.dto.PtServiceImpl;
import com.hcycom.ctginms.web.rest.util.FileUtil;
import com.hcycom.ctginms.web.rest.util.TimeUtil;
import com.hcycom.ctginms.web.rest.util.ZipUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/Pt")
@Api(tags={"pt"},description="pt、fm表的相关操作，做点位管理的相关操作")
public class PtRest {
    @Autowired
    private PtServiceImpl ps;
    @Autowired
    private FmServiceImpl fm;

    @GetMapping("/getEventAll")
    @Timed
    @ApiOperation(value="获取该事件(暂定pt时间表)下的点位列表", notes="获取该事件下的点位列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<List<Pt>> getAll(String eventcode){

        List<Pt> listUsers = ps.getEventAll(eventcode);
        return new ResponseEntity<List<Pt>>(listUsers, HttpStatus.OK);
    }


    @GetMapping("/selectReport")
    @Timed
    @ApiOperation(value="获取所有的文件类型(report文件类型表的操作)")
    public List<Report> selectReport(String pid){
        List<Report> reports=fm.selectReport(pid);
        return reports;
    }

    @GetMapping("/likeSelectfm")
    @Timed
    @ApiOperation(value="获取所有的文件类型总数以及文件上传个数(report文件类型表的操作)")
    public PostFm likeSelect(String pid){
        PostFm postFm = fm.likeSelectfm(pid);
        return postFm;
    }



    @PostMapping("/addOnePerson")
    @Timed
    @ApiOperation(value="增加，(向pt事件表)添加单个以及添加多条",notes="添加单个以及添加多条)")
   /* @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "人员id", required = true, dataType = "rcList",paramType="query"),
    })*/
    public String addOnePerson(@RequestBody List<Pt> rcList){
        ArrayList<String> list = new ArrayList<>();
        try {
            for (Pt pt : rcList) {
                list.add(pt.getCountyname());
            }
            int i1 = ps.selectByIds(list);
            if (i1 >0 && rcList.size()>0) {
//                数据库已经存在添加的名称已存在
                return "no";
            }
            ps.insetPersons(rcList);

//            for (int i=0;i<rcList.size();i++) {
//                int a = ps.addOnePerson(rcList.get(i));
//            }
        }catch (Exception e){
            return "no";
        }
        return "Yes";
    }



    @GetMapping("/delete")
    @Timed
    @ApiOperation(value="删除，通过id删除单个点位(pt事件表的操作)", notes="删除，通过id删除单个点位")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "点位id", required = true, dataType = "int",paramType="query"),
    })
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public boolean deleteUser(@RequestParam(value = "id", required = true) int id) {
        boolean flag=false;
        try{
            ps.delete(id);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }



    //查询，按照事件编码对点位编码以及点位名称进行模糊查询并进行分页
    @GetMapping("/likeSelect")
    @Timed
    @ApiOperation(value="查询，按照事件编码对点位编码以及点位名称进行模糊查询并进行分页以及返回总条数(前台返回值为空的时候需为null,不能是空字符串,pt事件表的操作)")
    public  ResponseEntity<Object> likeSelect(String eventcode,String countyname,String countycode, int page,int pageSize){
        PostPt tada = ps.likeSelect(eventcode, countyname, countycode, page, pageSize);
        return new ResponseEntity<Object>(tada, HttpStatus.OK);
    }




    @PostMapping("/doUploadOne")
    @Timed
    @ApiOperation(value = "文件上传(pt表的文件上传操作)")
    public ResponseEntity<Pt> filesUpload(MultipartFile uploadFile, HttpServletRequest request, String fmurl, String pid, String eventcode,String countycode,String countyname) throws IOException {
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
        String url=System.getProperty("user.dir").replaceAll("\\\\", "/");
        String fileUrl =url+File.separator+"medical_examination_report"+File.separator+fmurl;
        //String fileUrl ="D:\\"+fmurl;
        //String fileUrl="\\\\http://39.98.182.94:8080/file/";
        System.out.println("_________________________" + fmurl);
        //换成  服务器地址+ fileUrl
        //fileUrl = request.getSession().getServletContext().getRealPath(fileUrl);

        System.out.println("fileUrl = " + fileUrl);

        FileUtil.writeFileToUrl(uploadFile, fileUrl);
        Pt fileInfo = new Pt();
        fileInfo.setPersonCount(fmurl);
        fileInfo.setHealthForm(fileUrl);
        fileInfo.setPid(pid);
        fileInfo.setEventcode(eventcode);
        fileInfo.setCountycode(countycode);
        fileInfo.setCountyname(countyname);

        ps.filesUpload(fileInfo);
        return new ResponseEntity<Pt>(fileInfo, HttpStatus.OK);
    }


    @GetMapping("/selectAllFile")
    @Timed
    @ApiOperation(value = "文件下载,(pt表的操作，在其他文件中进行下载)")
    public ResponseEntity<List<Pt>> selectAllFile(String pid){

        List<Pt> listUsers =ps.selectAllFile(pid);
        return new ResponseEntity<List<Pt>>(listUsers, HttpStatus.OK);
    }


    @GetMapping("/selectAll")
    @Timed
    @ApiOperation(value="该文件类型下文件的详情以及总条数(暂定fm其他文件表的操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "reportcode", value = "文件编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<Object> selectAll(String pid, String reportcode){
        PostFmReport listUsers = fm.selectAll(pid,reportcode);
        return new ResponseEntity<Object>(listUsers, HttpStatus.OK);
    }


    @PostMapping("/addOnereport")
    @Timed
    @ApiOperation(value="增加，添加文件类型单个以及添加多条(report文件类型表的操作)")
   /* @ApiImplicitParams({
        @ApiImplicitParam(name = "reportname", value = "文件名称", required = true, dataType = "String",paramType="query"),
    })*/
    public String addOnereport(@RequestBody List<Report> rcList){
        try {
            for (int i=0;i<rcList.size();i++) {
                int a = fm.addOnereport(rcList.get(i));
            }
        }catch (Exception e){
            return "no";
        }
        return "Yes";
    }


    @GetMapping("/deleteFile")
    @Timed
    @ApiOperation(value="删除，通过id删除单个文件类型")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "人员id", required = true, dataType = "String",paramType="query"),
    })
    public boolean deleteFile(int id,String pid,String reportcode) {
        boolean flag=false;
        try{
            fm.deleteFile(id,pid,reportcode);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }


     @GetMapping("/healthForm")
    @Timed
    @ApiOperation(value="查询已上传文件的路劲和名字")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String",paramType="query"),
    })
    public List<Pt> healthForm(String pid,String eventcode){

        List<Pt> list=ps.healthForm(pid, eventcode);
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
