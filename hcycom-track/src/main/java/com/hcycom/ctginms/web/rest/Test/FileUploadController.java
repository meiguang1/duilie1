package com.hcycom.ctginms.web.rest.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.Pt;
import com.hcycom.ctginms.service.dto.PtServiceImpl;
import com.hcycom.ctginms.web.rest.util.FileUtil;
import com.hcycom.ctginms.web.rest.util.TimeUtil;
import com.hcycom.ctginms.web.rest.util.ZipUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.zip.ZipFile;

@RestController
@RequestMapping(value="/api/File-upload-and-file-download")
@Api(tags={"File-upload-and-file-download"},description="fm表的文件上传功能和文件下载功能")
public class FileUploadController {
    @Autowired
    private PtServiceImpl ps;



    @PostMapping("/InsertUpFileAll")
    @Timed
    @ApiOperation(value = "多文件上传,(pt表的操作，在其他文件中进行上传)")
    @ResponseBody
    public ResponseEntity<Pt> InsertUpFileAll(@RequestParam("uploadFiles")List<MultipartFile> uploadFiles,@RequestParam("fmurl")List<String> fmurl,String pid,String eventcode, String countyname, String countycode) throws IOException {
        //时间戳
        List<Pt> list = new ArrayList<>();

        System.out.printf("fmurl",JSONObject.toJSONString(fmurl));
        String url = System.getProperty("user.dir").replaceAll("\\\\", "/");
        String fileUrl = url+File.separator+"medical_examination_report";
        System.out.println("------------文件所在路劲-----------------"+fileUrl);
        File dir = new File(fileUrl);
        if(!dir.exists()){
            dir.mkdirs();
        }

        for(int i=0;i<uploadFiles.size();i++){
            String time = FileUtil.createFileTimestamp();
            String fileName = fmurl.get(i);
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("----------------源文件名-------------------------"+uploadFiles.get(i).getOriginalFilename());
            //if (StringUtils.hasText(file.getOriginalFilename())) {
            File newFile = new File(fileUrl +File.separator+time+fileType);
            String fnUrl=fileUrl +File.separator+time+fileType;
            System.out.println("----------文件路劲------------"+fnUrl);
            uploadFiles.get(i).transferTo(newFile);
            Pt fileInfo = new Pt();
            fileInfo.setPersonCount(fmurl.get(i));
            fileInfo.setHealthForm(fnUrl);
            fileInfo.setPid(pid);
            fileInfo.setCountycode(countycode);
            fileInfo.setCountyname(countyname);
            fileInfo.setEventcode(eventcode);
            list.add(fileInfo);
            // }
        }
        /*for(String file:fmurl){
            list.add(file);
            fileInfo.setPersonCount(file);
            System.out.println("------------------前台传的名---------------------"+file);
        }*/
        for (int i=0;i<list.size();i++) {
            int a = ps.addPoint(list.get(i));
        }
        System.out.println("------------------------------"+list);
        //ps.insetPersons(list);
        //ps.addPoint(fileInfo);
        return null;
    }



    @RequestMapping(value = "/packTodownload", method = RequestMethod.POST)
    @ApiOperation(value="pt表的打包下载")
    @ResponseBody
    public JSONObject packTodownload(@RequestBody JSONArray jsonArray, HttpServletRequest request,
                                     HttpServletResponse response) {
        JSONObject result=new JSONObject();
        String time= TimeUtil.dateTime2String(TimeUtil.getNewDate(),"yyyyMMddHHmmss");
        ///opt/tomcat/apache-tomcat-8.5.23/webapps/file/package/
        String url = System.getProperty("user.dir").replaceAll("\\\\", "/");
        File file = new File(url+File.separator+"medical_examination_report_package"+File.separator+time);
        //File file = new File("/opt/tomcat/apache-tomcat-8.5.23/webapps/file/package/"+time);
        if(!file.exists()){
            file.mkdirs();
        }
        // File ZipLog= file.mkdirs("D:"+"\\\\"+time);                        // 创建新的文件夹 空的
        try {
            for(int i=0;i<jsonArray.size();i++){
                String str = JSONObject.toJSONString(jsonArray.get(i));
                JSONObject obj = JSONObject.parseObject(str);/// 遍历JSONArray
                //JSONObject dwtxt = JSONObject.parseObject(jsonArray.getString(i));// jsonArray.getString(i)  获取对象
                String healthForm=obj.getString("healthForm");                                     // 获取对应的值
                String personCount=obj.getString("personCount");
                //copyFile(fnUrl,"D://"+"/"+time+"/"+fnName);                //拷贝文件 从旧路径到新路径  新路径命名地址/时间/名称
                //copyFile(healthForm,"D:"+File.separator+time+File.separator+personCount);                //拷贝文件 从旧路径到新路径  新路径命名地址/时间/名称
                copyFile(healthForm,url+File.separator+"medical_examination_report_package"+File.separator+time+File.separator+personCount);                //拷贝文件 从旧路径到新路径  新路径命名地址/时间/名称
                //copyFile(healthForm,"D:"+File.separator+time+File.separator+personCount);                //拷贝文件 从旧路径到新路径  新路径命名地址/时间/名称
            }
            //boolean zip = ZipUtil.zip("D:" + "\\" + time, "D:" + "\\" + time + ".zip");// 将拷贝好的文件  进行打包
            boolean zip = ZipUtil.zip(url + File.separator+"medical_examination_report_package"+File.separator+time, url + File.separator+"medical_examination_report_package"+File.separator+time+ ".zip");// 将拷贝好的文件  进行打包
            //boolean zip = ZipUtil.zip("/opt/tomcat/apache-tomcat-8.5.23/webapps/file/package/" + time, "/opt/tomcat/apache-tomcat-8.5.23/webapps/file/package/" + time + ".zip");// 将拷贝好的文件  进行打包
            if (!zip){
                result.put("code",0);
                result.put("message","打包失败！");
                return result;
            }
            //result.put("fnUrl","D:" + "\\" + time + ".zip");
            result.put("fnUrl",url + File.separator+"medical_examination_report_package"+File.separator+time + ".zip");
            //result.put("fnUrl","/opt/tomcat/apache-tomcat-8.5.23/webapps/file/package/" + time + ".zip");
        }catch (Exception e){
            result.put("code",0);
            result.put("message","打包失败！");
            result.put("errorMsg",e);
        }finally {
            if (file!=null&&file.exists()){
                //FileUtil.delFolder("D://"+"/"+time);                                     //删除拷贝过来的文件，不删除*.zip文件
                //FileUtil.delFolder("D:"+"\\"+time);                                     //删除拷贝过来的文件，不删除*.zip文件
                FileUtil.delFolder(url + File.separator+"medical_examination_report_package"+File.separator+time);                                     //删除拷贝过来的文件，不删除*.zip文件
                //FileUtil.delFolder("/opt/tomcat/apache-tomcat-8.5.23/webapps/file/package/"+time);                                     //删除拷贝过来的文件，不删除*.zip文件
            }
        }
        return result;
    }

    public void copyFile(String oldPath, String newPath) {
        System.out.println("__________________"+newPath);
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ( (byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        }
        catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }

    }



    /*public static void main(String[] args) {
        ZipFile zf = null;
        try {
            zf = new ZipFile("D:\\aaa.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int c= zf.size();     //返回zip文件中的条目数

        System.out.print(c-1);
    }*/

}
