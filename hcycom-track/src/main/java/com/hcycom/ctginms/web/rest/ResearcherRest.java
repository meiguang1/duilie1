package com.hcycom.ctginms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.Researcher;
import com.hcycom.ctginms.postdomain.PostFm;
import com.hcycom.ctginms.postdomain.PostResearcher;
import com.hcycom.ctginms.service.ResearcherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value="/api/researcherRest")
@Api(tags={"researcher"},description="researcher表的相关操作,做人员管理的相关操作")
public class ResearcherRest {

    @Autowired
    private ResearcherService pm;

    @GetMapping("/getEventAll")
    @Timed
    @ApiOperation(value="获取人员管理中某事件下的人员列表（已激活状态）", notes="(数据库researcher人员表的相关操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public ResponseEntity<List<Researcher>> getAll(String eventcode){

        List<Researcher> listUsers = pm.getEventAll(eventcode);
       // System.out.println(listUsers);
        return new ResponseEntity<List<Researcher>>(listUsers, HttpStatus.OK);
    }




    @GetMapping("/delete")
    @Timed
    @ApiOperation(value="删除，通过人员id删除单个人员", notes="(researcher表的相关操作)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "人员id", required = true, dataType = "String",paramType="query"),
    })
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public boolean deleteUser(@RequestParam(value = "id", required = true) int id) {
        boolean flag=false;
        try{
            pm.delete(id);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }



    @PostMapping("/addOnePerson")
    @Timed
    @ApiOperation(value="增加，人员管理模块添加单个以及添加多条",notes="(researcher表的相关操作)")
  /*  @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "人员id", required = true, dataType = "rcList",paramType="query"),
    })*/
    public String addOnePerson(@RequestBody List<Researcher> rcList){
        try {
            for (int i=0;i<rcList.size();i++) {
                int a = pm.addOnePerson(rcList.get(i));
            }
        }catch (Exception e){
            return "no";
        }
        return "Yes";
    }



   /* //分页并且判断事件编号
    @GetMapping("/query")
    @Timed
    @ApiOperation(value="分页,并且以事件编号分页",notes="分页,并且以事件编号分页)")
    public  List<Researcher> findByPage( int page ,int pageSize, String researchname, String researchcode,String eventcode,HttpServletResponse response){
        //response.setHeader("Access-Control-Allow-Origin","*"); //解决跨域请求
        return pm.findUserListByPage(page,pageSize,researchname,researchcode,eventcode);
    }*/

    //按照事件编码模糊查询对象编码和对象名称并分页以及返回总条数
    @GetMapping("/likeSelect")
    @Timed
    @ApiOperation(value="查询，在人员管理模块进行模糊查询以及分页并返回总条数",notes ="(数据库researcher表的操作)" )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "researchname", value = "人员名称", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "researchcode", value = "人员编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int",paramType="query"),
        @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "int",paramType="query"),
    })
    public  ResponseEntity<Object> likeSelect(String eventcode,String researchname,String researchcode, int page ,int pageSize){
        PostResearcher tada = pm.likeSelect(eventcode, researchname, researchcode, page, pageSize);
        return new ResponseEntity<Object>(tada, HttpStatus.OK);
    }

    @GetMapping("/uploadingAll")
    @Timed
    @ApiOperation(value="点位管理中体检报告上传状态",notes = "通过researcher表查询某区县下具体人数以及level_management表的文件上传数量来判断体检报告上传状态")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "position", value = "区县名称", required = true, dataType = "String",paramType="query"),
    })
    public PostFm uploadingAll(String pid,String eventcode,String position){
        PostFm postFm = pm.uploadingAll(pid,eventcode,position);
        return postFm;
    }

}
