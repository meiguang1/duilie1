package com.hcycom.ctginms.web.rest;

    import com.alibaba.fastjson.JSON;
    import com.alibaba.fastjson.JSONObject;
    import com.alibaba.fastjson.JSONArray;
    import com.codahale.metrics.annotation.Timed;
    import com.hcycom.ctginms.domain.Fm;
    import com.hcycom.ctginms.service.FmService;
    import com.hcycom.ctginms.service.dto.FmServiceImpl;
    import com.hcycom.ctginms.web.rest.util.FileUtil;
    import com.hcycom.ctginms.web.rest.util.TimeUtil;
    import com.hcycom.ctginms.web.rest.util.ZipUtil;
    import io.swagger.annotations.Api;
    import io.swagger.annotations.ApiImplicitParam;
    import io.swagger.annotations.ApiImplicitParams;
    import io.swagger.annotations.ApiOperation;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpHeaders;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;
    import org.springframework.web.multipart.MultipartHttpServletRequest;
    import org.springframework.web.multipart.commons.CommonsMultipartFile;

    import javax.servlet.ServletContext;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.*;
    import java.net.URLEncoder;
    import java.sql.SQLException;
    import java.util.*;

@RestController
@RequestMapping(value="/api/File-upload-and-file-download")
@Api(tags={"File-upload-and-file-download"},description="点位管理和其他文件管理中的文件上传与下载")
public class FmRest {
    @Autowired
    private FmService fileService;
    @Autowired
    private FmServiceImpl fmServiceimpl;


    @PostMapping("/InsertUpFile")
    @Timed
    @ApiOperation(value = "其它文件管理中的文件上传,(other_files表的操作，在其它文件中进行上传)")
    @ResponseBody
    @ApiImplicitParams({
        @ApiImplicitParam(name = "fmurl", value = "文件名称", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "reportcode", value = "文件类型编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<Fm> InsertUpFile(MultipartFile uploadFile, HttpServletRequest request,String fmurl,String pid,String reportcode) throws IOException {
        //String fileUrl ="/opt/tomcat/apache-tomcat-8.5.23/webapps/file/otherFiles/"+fmurl;
        String url=System.getProperty("user.dir").replaceAll("\\\\", "/");
        System.out.println("------------url---------------"+url);
        String fileUrl =url+File.separator+"other_files"+File.separator+fmurl;
        System.out.println("____________originalFileName_____________" + fmurl);
        //换成  服务器地址+ fileUrl
//        fileUrl = request.getSession().getServletContext().getRealPath(fileUrl);
        FileUtil.writeFileToUrl(uploadFile, fileUrl);
        System.out.println("-------------------"+uploadFile);
        System.out.println("_____________fileUrl____________"+fileUrl);
        System.out.println("fileUrl = " + fileUrl);
        Fm fileInfo = new Fm();
        fileInfo.setPid(pid);
        fileInfo.setReportcode(reportcode);
        fileInfo.setFnName(fmurl);
        fileInfo.setFnUrl(fileUrl);
        fileService.InsertUpFile(fileInfo);
        return new ResponseEntity<Fm>(fileInfo, HttpStatus.OK);
    }




    @GetMapping("/downfile")
    @Timed
    @ApiOperation(value = "其它文件管理中文件下载,(other_files表的操作，在其它文件中进行下载)")
    public String downfile(String filename,String id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println(filename+id);
        //根据id获取文件上传路径
        Fm upFile=fileService.selectFileById(Integer.parseInt(id));
        String fileName = upFile.getFnUrl()+"/"+filename;
        //防止中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        System.out.println(filename);
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;fileName=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
        return "OK";
    }


    @GetMapping("/downfile1")
    @Timed
    @ApiOperation(value ="aaa")
    public static void downloadFile(HttpServletResponse response,String fileName,String path){
        if (fileName != null) {
            //设置文件路径
            File file = new File(path);
            if (file.exists()) {
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                try {
                    response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }





   /* @RequestMapping("/down")
    public void down(HttpServletRequest request,HttpServletResponse response,Integer fileId) throws Exception{
        FmService dao = new FmServiceImpl();

        Fm fileInfo = dao.selectFileById(fileId);
        String fileName1 = fileInfo.getFnName();
        System.out.println("-------fileInfo--------"+fileInfo);
        //模拟文件，myfile.txt为需要下载的文件
        String fileName = request.getSession().getServletContext().getRealPath("upload")+"/"+fileName1;
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        String filename = fileName1;
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }*/




   /* @RequestMapping("/download")
    public ResponseEntity<byte[]> download(Integer fileId){
        FmService dao = new FmServiceImpl();
        try {
            Fm fileInfo = dao.selectFileById(fileId);
            String fileUrl = fileInfo.getFnUrl();
            String fileName = fileInfo.getFnName();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);


            ResponseEntity<byte[]> entity =
                new ResponseEntity<byte[]>(FileUtil.readFileToByteArray(new File(fileUrl)), headers,HttpStatus.CREATED);
            return entity;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }*/







    @GetMapping("/fileDownload")
    @Timed
    @ApiOperation(value = "其它文件管理中文件下载,(other_files表的操作，在其它文件中进行下载)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pid", value = "点位编码", required = true, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "reportcode", value = "文件类型编码", required = true, dataType = "String",paramType="query"),
    })
    public ResponseEntity<List<Fm>> fileDownload(String pid, String reportcode){

        List<Fm> listUsers =fileService.fileDownload(pid, reportcode);
        return new ResponseEntity<List<Fm>>(listUsers, HttpStatus.OK);
    }


    @RequestMapping(value = "/ziploadLogs", method = RequestMethod.POST)
    @ApiOperation(value="其它文件管理中的打包下载(other_files表的打包下载)")
    @ResponseBody
    public JSONObject ziploadLogs( @RequestBody JSONArray jsonArray,HttpServletRequest request,
                                   HttpServletResponse response) {
        //System.out.printf("asdf"+JSONObject.toJSONString(jsonArray));
        JSONObject result=new JSONObject();
        String time=TimeUtil.dateTime2String(TimeUtil.getNewDate(),"yyyyMMddHHmmss");
        //File ZipLog= FileUtil.mkdirFiles("D:"+"/"+time);                        // 创建新的文件夹 空的
        ///opt/tomcat/apache-tomcat-8.5.23/webapps/file/package/
        String url = System.getProperty("user.dir").replaceAll("\\\\", "/");
        File file = new File(url+File.separator+"other_files_package"+File.separator+time);
        if(!file.exists()){
            file.mkdirs();
        }
        // File ZipLog= file.mkdirs("D:"+"\\\\"+time);                        // 创建新的文件夹 空的
        try {
            for(int i=0;i<jsonArray.size();i++){
                String str = JSONObject.toJSONString(jsonArray.get(i));
                JSONObject obj = JSONObject.parseObject(str);/// 遍历JSONArray
                //JSONObject dwtxt = JSONObject.parseObject(jsonArray.getString(i));// jsonArray.getString(i)  获取对象
                String fnUrl=obj.getString("fnUrl");                                     // 获取对应的值
                String fnName=obj.getString("fnName");
                copyFile(fnUrl,url+File.separator+"other_files_package"+File.separator+time+File.separator+fnName);                //拷贝文件 从旧路径到新路径  新路径命名地址/时间/名称
                //copyFile(fnUrl,url+File.separator+"other_files_package"+File.separator+time+"/"+fnName);
                //copyFile(fnUrl,"D:"+File.separator+time+File.separator+fnName);                //拷贝文件 从旧路径到新路径  新路径命名地址/时间/名称
            }
            //boolean zip = ZipUtil.zip("D://" + "/" + time, "D://" + "/" + time + ".zip");// 将拷贝好的文件  进行打包
            boolean zip = ZipUtil.zip(url + File.separator+"other_files_package"+File.separator+time, url + File.separator+"other_files_package"+File.separator+time+ ".zip");// 将拷贝好的文件  进行打包
            if (!zip){
                result.put("code",0);
                result.put("message","打包失败！");
                return result;
            }
//            文件已经打包好了   "D://"+"/"+time+".zip"
//            开始下载
           /* String filepath="D://";
            String filename=time+".zip";
            File file = new File(filepath);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                    "attachment;fileName=" + filename);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
//                    log.info("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return null;*/
            //result.put("fnUrl","D://" + "/" + time + ".zip");
            result.put("fnUrl",url + File.separator+"other_files_package"+File.separator+time + ".zip");
        }catch (Exception e){
            result.put("code",0);
            result.put("message","打包失败！");
            result.put("errorMsg",e);
        }finally {
            if (file!=null&&file.exists()){
                //FileUtil.delFolder("D://"+"/"+time);                                     //删除拷贝过来的文件，不删除*.zip文件
                FileUtil.delFolder(url + File.separator+"other_files_package"+File.separator+time);                                     //删除拷贝过来的文件，不删除*.zip文件
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
               /* File file = new File(newPath);
                if(!file.exists()){
                    file.mkdirs();
                }*/
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
}
