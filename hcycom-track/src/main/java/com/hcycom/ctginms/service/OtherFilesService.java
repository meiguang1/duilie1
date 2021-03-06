package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.OtherFiles;
import com.hcycom.ctginms.domain.Report;
import com.hcycom.ctginms.postdomain.PostFm;
import com.hcycom.ctginms.postdomain.PostFmReport;

import java.util.List;

public interface OtherFilesService {


    /*文件上传*/
    int InsertUpFile(OtherFiles upFile);

    /*新增一个文件类型*/
    int addOnereport(Report report);

    //通过id，删除单个文件信息
    boolean deleteFile(int id,String pid,String reportcode);

    /*文件下载*/
    List<OtherFiles> fileDownload(String pid,String reportcode);
    //Fm selectFileById(int id);
   /* List<Fm> selectFileById(int id);*/


    /*查询所有文件类型*/
    List<Report> selectReport(String pid);


    /*查询某个文件类型下的文件以及总个数*/
    PostFmReport selectAll(String pid, String reportcode);

    /*查询所有条数以及上传条数*/
    PostFm likeSelectfm(String pid);



    //查询全部按照点位编码
    //PostFm FmselectEventAll(String pid);

    /*获取文件类型下的文件总个数*/
    //int eFiles(String pid,String reportcode);

    //查询上传文件是否为空
    //String FmhealthForm(String pid,int id);


}
