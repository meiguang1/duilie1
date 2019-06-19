package com.hcycom.ctginms.web.rest.Test;

import com.alibaba.fastjson.JSONObject;
import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.service.FmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@RestController
@RequestMapping(value="/api/TestController")
@Api(tags={"a"},description="点位管理和其他文件管理中的文件上传与下载")
public class TestController {
    @Value("${pointpath}")
    String pointpath;
    @Autowired
    private FmService fileService;

    /* @GetMapping("/downloadLogs2")
    @Timed
    @ApiOperation(value = "aa")
    @ResponseBody
   public String downloadLogs2( @RequestParam JSONObject dwtxt,
                                 HttpServletRequest request,
                                 HttpServletResponse response){

        String filepath=dwtxt.getString("fnUrl");
        String filename=dwtxt.getString("fnName");
        File file = new File(filepath);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition",
                "attachment;fnName=" + filename);// 设置文件名
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
        return null;

    }*/
}
