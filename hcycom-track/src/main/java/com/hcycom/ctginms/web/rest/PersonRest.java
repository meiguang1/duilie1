package com.hcycom.ctginms.web.rest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.hcycom.ctginms.postdomain.Tada;
import com.hcycom.ctginms.web.rest.util.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.Person;
import com.hcycom.ctginms.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 北京华晨阳通信技术有限责任公司
 * @date: 2019年3月22日 上午11:04:20
 * @name: 李硕
 * @Description: 人员表和人员事件对照表的rest接口
 */
@RestController
@RequestMapping(value="/api/personrest")
@Api(tags={"人员表和人员事件对照表，person、personevent表"},description="person、personevent表的相关操作，做人员和事件导入人员相关操作")
public class PersonRest {


    @Autowired
    private PersonService ps;



    @GetMapping("/getPersonByProjectCode")
    @Timed
    @ApiOperation(value="获取该项目下的人员列表（已激活状态）", notes="获取该项目下的人员列表（已激活状态）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectcode", value = "项目编码", required = true, dataType = "String",paramType="query"),
    })
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public ResponseEntity<List<Person>> getPersonByProjectCode(String projectcode){

        List<Person> plist=ps.getPersonByProjectcode(projectcode);

        return new ResponseEntity<List<Person>>(plist, HttpStatus.OK);
    }


    @GetMapping("/getPersonByEventCode")
    @Timed
    @ApiOperation(value="获取该事件下的人员列表（已激活状态）", notes="获取该事件下的人员列表（已激活状态）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public ResponseEntity<List<Person>> getPersonByEventCode(String eventcode){

        List<Person> plist=ps.getPersonByEventCode(eventcode);

        return new ResponseEntity<List<Person>>(plist, HttpStatus.OK);
    }



    @PostMapping("/updatePerson")
    @Timed
    @ApiOperation(value="修改，修改个人信息",notes="修改个人信息")
    public ResponseEntity<String> updatePerson(@RequestBody Person person){



        int a = ps.updateOnePersonById(person);


        return new ResponseEntity<String>(a+"", HttpStatus.OK);
    }



    @GetMapping("/deleteOnePerson")
    @Timed
    @ApiOperation(value="删除，通过id删除单个人员（逻辑删除，修改状态）", notes="删除，通过id删除单个人员（逻辑删除，修改状态）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "人员id", required = true, dataType = "String",paramType="query"),
    })
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public ResponseEntity<String> deleteOnePerson(int id){

        int a = ps.deleteOnePersonById(id);

        return new ResponseEntity<String>(a+"", HttpStatus.OK);
    }



    @PostMapping("/addOnePerson")
    @Timed
    @ApiOperation(value="增加，添加单个，个人信息(返回新增人员的id)",notes="添加单个，个人信息(返回新增人员的id)")
    public ResponseEntity<String> addOnePerson(@RequestBody Person person){



        int a = ps.addOnePerson(person);


        return new ResponseEntity<String>(a+"", HttpStatus.OK);
    }



    /*分页并且判断项目编号
    @GetMapping("/query")
    @Timed
    @ApiOperation(value="分页,并且以项目编号分页(前台返回值为空的时候需为null,不能是空字符串)",notes="分页,并且以项目编号分页(前台返回值为空的时候需为null,不能是空字符串))")
    public  List<Person> findByPage(String projectcode, int page , int pageSize, HttpServletResponse response){
        //response.setHeader("Access-Control-Allow-Origin","*"); //解决跨域请求
        return ps.findUserListByPage(page,pageSize,projectcode);
    }*/


    @GetMapping("/likeSelect")
    @Timed
    @ApiOperation(value="查询，按照项目编码模糊查询对象编码和对象名称并分页以及返回总条数(前台返回值为空的时候需为null,不能是空字符串)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectcode", value = "项目编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "researchname", value = "人员名称", required = false, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "researchcode", value = "人员编码", required = false, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int",paramType="query"),
        @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "int",paramType="query"),
    })
    public  ResponseEntity<Object> likeSelect(String projectcode,String researchname,String researchcode, int page ,int pageSize){
        //System.out.println("asssssssssssssssssddddddddddddddd");
        Tada tada = ps.likeSelect(projectcode, researchname, researchcode, page, pageSize);
        return new ResponseEntity<Object>(tada, HttpStatus.OK);
    }




    /*项目中人员管理文件上传(把数据插入数据库中以后调用删除方法把上传的文件删除)*/
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
    @ApiOperation(value="项目下人员管理的文件上传", notes="数据库person表的新增数据操作")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectcode", value = "项目编码", required = true, dataType = "String",paramType="query"),
    })
    public List<String> files(@RequestParam(value="multipartFile",required=false) MultipartFile multipartFile, HttpServletRequest request,String projectcode) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
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

        //获取文件的类型，以“.”作为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
        System.out.println("文件类型"+type);
        //在指定的路径下面创建一个新的文件
        File targerFile = new File(path,originalFileName);

        multipartFile.transferTo(targerFile);

        CsvUtils csvUtils=new CsvUtils();
        List<String> samplelist =csvUtils.importCsv(targerFile);
        List<Person> importList=new ArrayList<Person>();
        if(samplelist!=null && !samplelist.isEmpty()){
            for(String data : samplelist){
                System.out.println(data);
                Person person=new Person();
                String[] aa = data.split(",");
                person.setResearchcode(aa[2]);
                person.setResearchname(aa[3]);
                String str=aa[6].toString();
                String countycode=""+str;
                while (countycode.length()<3) {
                    countycode= "0"+countycode;
                }
                person.setCountycode(countycode);
                person.setProjectcode(projectcode);
                person.setState(1);
                String creattime=df.format(new Date());
                person.setCreattime(creattime);
                person.setAge(Integer.parseInt(aa[5]));
                person.setSex(aa[4]);
                importList.add(person);
                System.out.println(person);
            }
        }
        int aa = ps.importSample(importList);
        System.out.println("-----------------------------------------"+ JSONObject.toJSONString(importList));
        System.out.println("--------------aa-------------------------"+aa);
        deleteFile(targerFile);
        return samplelist;
    }
}
