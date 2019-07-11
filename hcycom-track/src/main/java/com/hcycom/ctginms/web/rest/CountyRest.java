package com.hcycom.ctginms.web.rest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import com.hcycom.ctginms.domain.County;
import com.hcycom.ctginms.postdomain.PostCounty;
import com.hcycom.ctginms.postdomain.Tada;
import com.hcycom.ctginms.service.CountyService;
import com.hcycom.ctginms.web.rest.util.CsvUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.codahale.metrics.annotation.Timed;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.hcycom.ctginms.web.rest.util.FileUtil.subZeroAndDot;

/**
 * @ClassName: CountyRest
 * @Description: 区县表rest接口
 * @Author: 白敏
 * @Date: 2019/4/17 13:38
 **/
@RestController
@RequestMapping(value="/api/countyrest")
@Api(tags={"区县管理"},description="county表的相关操作，做区县相关操作")
public class CountyRest {

    @Autowired
    private CountyService countyService;

    @GetMapping("/getCountyByProjectCode")
    @Timed
    @ApiOperation(value="获取该项目下的区县列表（已激活状态）", notes="获取该项目下的区县列表（已激活状态）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectcode", value = "项目编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<List<County>> getCountyByProjectCode(String projectcode){
        List<County> countylist=countyService.getCountyByProjectcode(projectcode);
        return new ResponseEntity<List<County>>(countylist, HttpStatus.OK);
    }

    @PostMapping("/addCounty")
    @Timed
    @ApiOperation(value="增加，添加单个，区县信息(返回新增区县的id)",notes="添加单个，区县信息(返回新增区县的id)")
    public ResponseEntity<String> addCounty(@RequestBody PostCounty county){

        int a = countyService.addCounty(county);
        return new ResponseEntity<String>(a+"", HttpStatus.OK);
    }

    @PostMapping("/updateCounty")
    @Timed
    @ApiOperation(value="修改区县信息",notes="修改区县信息")
    public ResponseEntity<String> updateCountyById(@RequestBody PostCounty person){
        int a = countyService.updateCountyById(person);
        return new ResponseEntity<String>(a+"", HttpStatus.OK);
    }

    @GetMapping("/deleteCounty")
    @Timed
    @ApiOperation(value="删除，通过id删除单个区县（逻辑删除，修改状态）", notes="删除，通过id删除单个区县（逻辑删除，修改状态）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "区县id", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<String> deleteCountyById(int id){
        int a = countyService.deleteCountyById(id);
        return new ResponseEntity<String>(a+"", HttpStatus.OK);
    }


    /*查询，按照项目编码对区县编码和区县名称进行模糊查询、分页以及返回总条数(前台返回值为空的时候需为null,不能是空字符串)*/
    @GetMapping("/likeSelect")
    @Timed
    @ApiOperation(value="查询,按照项目编码进行模糊分页以及模糊查询并返回总条数")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectcode", value = "项目编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "countyname", value = "区县名称", required = false, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "countycode", value = "区县编码", required = false, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int",paramType="query"),
        @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "int",paramType="query"),
    })
    public  ResponseEntity<Object> likeSelect(String projectcode,String countyname,String countycode, int page ,int pageSize){
        Tada tada = countyService.likeSelect(projectcode, countyname, countycode, page, pageSize);
        return new ResponseEntity<Object>(tada, HttpStatus.OK);
    }



    @GetMapping("/getCountyBy")
    @Timed
    @ApiOperation(value="对符合条件的区县进行全部查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectcode", value = "项目编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<List<County>> getCountyBy(String projectcode){
        List<County> countylist=countyService.getCountyBy(projectcode);
        return new ResponseEntity<List<County>>(countylist, HttpStatus.OK);
    }

    @GetMapping("/likeCountyBy")
    @Timed
    @ApiOperation(value="对符合条件的区县进行模糊查询并且返回总条数 ")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectcode", value = "项目编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "countyname", value = "区县名称", required = false, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "countycode", value = "区县编码", required = false, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int",paramType="query"),
        @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "int",paramType="query"),
    })
    public  ResponseEntity<Object> likeCountyBy(String projectcode,String countyname,String countycode, int page ,int pageSize){
        Tada tada = countyService.likeCountyBy(projectcode, countyname, countycode, page, pageSize);
        return new ResponseEntity<Object>(tada, HttpStatus.OK);
    }



    /*项目中区县管理文件上传(把数据插入数据库中然后后调用删除方法把上传的文件删除)*/
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
    @ApiOperation(value="项目下区县管理的文件上传", notes="数据库county表的新增数据操作")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectcode", value = "项目编码", required = true, dataType = "String",paramType="query"),
    })
    public List<County> files(@RequestParam(value="multipartFile",required=false) MultipartFile multipartFile, HttpServletRequest request, String projectcode) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String path1 = request.getSession().getServletContext().getRealPath("/upload");
        File filePath = new File(path1);
        System.out.println("文件保存的路径" + path1);
        if (!filePath.exists() && !filePath.isDirectory()) {

            System.out.println("目录不存在，创建路径" + filePath);
            filePath.mkdir();
        }
        //获取原始文件名称
        String originalFileName = multipartFile.getOriginalFilename();
        System.out.println("原始文件的名称" + originalFileName);

        File targerFile = new File(path1, originalFileName);
        multipartFile.transferTo(targerFile);
        String path=path1+File.separator+originalFileName;
        List<County> importList = new ArrayList<County>();
        try {
            //String encoding = "GBK";
            File excel = new File(path);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在
                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb = null;
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else if("csv".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else{
                    System.out.println("文件类型错误！！！");
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: "+firstRowIndex);
                System.out.println("lastRowIndex: "+lastRowIndex);


                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        County county = new County();
                        System.out.println("------------------"+subZeroAndDot(String.valueOf(row.getCell(0))));
                        System.out.println("------------------"+row.getCell(1));
                        System.out.println("------------------"+row.getCell(2));
                        String str= subZeroAndDot(String.valueOf(row.getCell(1)));
                        String countycode=""+str;
                        while (countycode.length()<3) {
                            countycode= "0"+countycode;
                        }
                        if (String.valueOf(row.getCell(2)).equals("null")) {
                            county.setCountyname(String.valueOf(""));
                        }else {
                            county.setCountyname(String.valueOf(row.getCell(2)));
                        }
                        if(countycode.length()==0||countycode.equals("null")){
                            county.setCountycode("");
                        }else{
                            county.setCountycode(countycode);
                        }
                        county.setProjectcode(projectcode);
                        county.setState(1);
                        String creattime=df.format(new Date());
                        county.setCreattime(creattime);
                        importList.add(county);
                        //System.out.println(county);


                       /* for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {
                                System.out.println("数据："+cell.toString());
                            }
                        }*/
                    }
                }
                int aa = countyService.importSample(importList);
                System.out.println("-----------------------------------------" + JSONObject.toJSONString(importList));
                System.out.println("--------------aa-------------------------"+aa);
                wb.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            deleteFile(targerFile);
        }
        return importList;
    }
}
