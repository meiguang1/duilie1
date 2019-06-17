package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.Fm;
import com.hcycom.ctginms.domain.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FmMapper {

    /*查询某个文件类型下的文件以及总个数*/
    List<Fm> selectAll(@Param("pid")String pid,@Param("reportcode")String reportcode);
    //查询某文件类型的文件总条数
    int eFiles(@Param("pid")String pid,@Param("reportcode")String reportcode);


    /*查看文件未上传条数*/
    int likeSelectfm(String pid);
    /*查看文件总条数条数*/
    int likeSelectOne(String pid);




    /*文件上传*/
    int InsertUpFile(Fm upFile);

    /*文件类型添加*/
    int addOnereport(Report report);

    //通过id，删除单个文件类型
    boolean deleteFile(@Param("id")int id);
    boolean deleteFm(@Param("pid")String pid,@Param("reportcode")String reportcode);


    /*文件下载*/
    List<Fm> fileDownload(@Param("pid")String pid,@Param("reportcode")String reportcode);

    //查询某文件类型下文件的详情
    List<Report> selectReport(String pid);




    //根据事件编码查询全部人员
    //List<Fm> FmselectEventAll(@Param("pid")String pid);


    //根据点位编码查询上传文件是否为空
    //String FmhealthForm(@Param("pid")String pid,@Param("id") int id);
}
