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
    @ApiOperation(value="获取该事件下的人员列表（已激活状态）", notes="获取该事件下的人员列表（已激活状态）")
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
    @ApiOperation(value="删除，通过id删除单个人员", notes="删除，通过id删除单个人员")
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
    @ApiOperation(value="增加，添加单个以及添加多条",notes="添加单个以及添加多条)")
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
    @ApiOperation(value="查询，按照事件编码模糊查询对象编码和对象名称并分页以及返回总条数(前台返回值为空的时候需为null,不能是空字符串)")
    public  ResponseEntity<Object> likeSelect(String eventcode,String researchname,String researchcode, int page ,int pageSize){
        PostResearcher tada = pm.likeSelect(eventcode, researchname, researchcode, page, pageSize);
        return new ResponseEntity<Object>(tada, HttpStatus.OK);
    }

    @GetMapping("/uploadingAll")
    @Timed
    @ApiOperation(value="获取所有的文件类型总数以及文件上传个数(pt点位管理表的操作)")
    public PostFm uploadingAll(String pid,String eventcode,String position){
        PostFm postFm = pm.uploadingAll(pid,eventcode,position);
        return postFm;
    }

}
