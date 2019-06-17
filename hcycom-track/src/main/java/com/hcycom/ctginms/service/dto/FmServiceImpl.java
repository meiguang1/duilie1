package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.Fm;
import com.hcycom.ctginms.domain.Report;
import com.hcycom.ctginms.postdomain.PostFm;
import com.hcycom.ctginms.postdomain.PostFmReport;
import com.hcycom.ctginms.repository.FmMapper;
import com.hcycom.ctginms.service.FmService;
import com.hcycom.ctginms.web.rest.vm.FmReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class  FmServiceImpl implements FmService {

    @Autowired
    private FmMapper fm;

    /*文件上传*/
    @Override
    public int InsertUpFile(Fm upFile) {
        // TODO Auto-generated method stub
        upFile.setPid(upFile.getPid());
        upFile.setFnName(upFile.getFnName());
        upFile.setFnUrl(upFile.getFnUrl());
        upFile.setReportcode(upFile.getReportcode());
        int i = fm.InsertUpFile(upFile);
        return i;
    }

    //文件类型添加 添加到report表
    @Override
    public int addOnereport(Report report) {

        Report pt1=new Report();
        pt1.setReportname(report.getReportname());
        pt1.setPid(report.getPid());
        fm.addOnereport(pt1);
        int id=pt1.getId();
        return id;
    }

    /*文件类型删除 删除report表的问价类型*/
    @Override
    @Transactional
    public boolean deleteFile(int id,String pid,String reportcode) {
        boolean flag=false;
        try{
            fm.deleteFile(id);
            fm.deleteFm(pid,reportcode);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }



    /*文件下载*/
    @Override
    public List<Fm> fileDownload(String pid, String reportcode) {
        return fm.fileDownload(pid,reportcode);
    }

    //查询其他文件中的文件类型
    @Override
    public List<Report> selectReport(String pid) {
        List<Report> reports=fm.selectReport(pid);
        return reports;
    }

    //查询某个文件类型下的文件以及总条数
    @Override
    public PostFmReport selectAll(String pid, String reportcode) {
        List<Fm> plist = fm.selectAll(pid,reportcode);
        PostFmReport postFm=new PostFmReport();
        postFm.setSelectOne(plist);
        int i=fm.eFiles(pid,reportcode);
        postFm.seteFiles(i);
        return postFm;
    }

    @Override
    public PostFm likeSelectfm(String pid) {
        int i = fm.likeSelectfm(pid);
        PostFm postFm=new PostFm();
        postFm.setLikeSelect(i);
        int i1 = fm.likeSelectOne(pid);
        postFm.setLikeSelectOne(i1);
        return postFm;
    }


    //查询全部 按照点位编码
    /*@Override
    public PostFm  FmselectEventAll(String pid) {
        List<Fm> plist = fm.FmselectEventAll(pid);
        PostFm postFm=new PostFm();
        postFm.setSelect(plist);
        int i = fm.likeSelect(pid);
        postFm.setLikeSelect(i);
        int i1 = fm.likeSelectOne(pid);
        postFm.setLikeSelectOne(i1);
        return postFm;
    }*/

    //查询文件是否未空
    /*@Override
    public String FmhealthForm(String pid,int id) {
        String s = fm.FmhealthForm(pid,id);
        if(s==null){
            return "null";
        }else {
            return  s;
        }
    }*/
}
