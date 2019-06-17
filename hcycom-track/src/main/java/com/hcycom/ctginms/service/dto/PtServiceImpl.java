package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.Pt;
import com.hcycom.ctginms.postdomain.PostFm;
import com.hcycom.ctginms.postdomain.PostFmReport;
import com.hcycom.ctginms.postdomain.PostPt;
import com.hcycom.ctginms.repository.PtMapper;
import com.hcycom.ctginms.service.PtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PtServiceImpl implements PtService {
    @Autowired
    private PtMapper pm;

    @Override
    public List<Pt> getEventAll(String eventcode) {
        List<Pt> plist = pm.selectEventAll(eventcode);
        return plist;
    }

    /*<!--查询已上传文件的路劲和名字-->*/
    @Override
    public List<Pt> healthForm(String pid,String eventcode) {
        List<Pt> list=pm.healthForm(pid, eventcode);
        /*String s = pm.healthForm(pid,eventcode);
        if(s==null){
            return "null";
        }else {
            return  s;
        }*/
       return list;

    }

    //旧的添加方式
    @Override
    public int addPoint(Pt pt) {
        Pt pt1=new Pt();
        pt1.setCountycode(pt.getCountycode());
        pt1.setCountyname(pt.getCountyname());
        pt1.setEventcode(pt.getEventcode());
        pt1.setPersonCount(pt.getPersonCount());
        pt1.setHealthForm(pt.getHealthForm());
        pm.addPoint(pt1);
        int id=pt1.getId();
        return id;
    }

    //按照id进行删除
    @Override
    public boolean delete(int id) {
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

    @Override
    public PostPt likeSelect(String eventcode, String countyname, String countycode, int page, int pageSize) {
        int b=0;
        if (page > 1) {
            b = (page - 1) * pageSize ;
        }
        List<Pt> researchers = pm.likeSelect(eventcode, countyname, countycode, b, pageSize);
        PostPt tada = new PostPt();
        tada.setSelect(researchers);
        int likeTable = pm.getLikeTable(eventcode, countyname, countycode);
        tada.setPages(likeTable);
        return tada;
    }

    /*文件上传*/
    @Override
    public int filesUpload(Pt upFile) {

        upFile.setPid(upFile.getPid());
        upFile.setCountycode(upFile.getCountycode());
        upFile.setCountyname(upFile.getCountyname());
        upFile.setEventcode(upFile.getEventcode());
        upFile.setPersonCount(upFile.getPersonCount());
        upFile.setHealthForm(upFile.getHealthForm());
        int i = pm.filesUpload(upFile);
        return i;
    }

    /*文件下载*/
    @Override
    public List<Pt> selectAllFile(String pid) {
        return pm.selectAllFile(pid);
    }

    /*单个添加对象*/
    @Override
    public int selectByIds(List list) {
        return pm.selectByIds(list);
    }
    /*多个添加对象*/
    @Override
    public void insetPersons(List<Pt> rcList) {
        pm.insetPersons(rcList);
    }


}
