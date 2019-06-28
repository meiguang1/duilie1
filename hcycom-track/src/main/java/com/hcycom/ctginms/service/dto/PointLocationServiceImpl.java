package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.PointLocation;
import com.hcycom.ctginms.postdomain.PostPt;
import com.hcycom.ctginms.repository.PointLocationMapper;
import com.hcycom.ctginms.service.PointLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PointLocationServiceImpl implements PointLocationService {
    @Autowired
    private PointLocationMapper pm;

    @Override
    public List<PointLocation> getEventAll(String eventcode) {
        List<PointLocation> plist = pm.selectEventAll(eventcode);
        return plist;
    }

    /*<!--查询已上传文件的路劲和名字-->*/
    @Override
    public List<PointLocation> healthForm(String pid,String eventcode) {
        List<PointLocation> list=pm.healthForm(pid, eventcode);
        /*String s = pm.healthForm(pid,eventcode);
        if(s==null){
            return "null";
        }else {
            return  s;
        }*/
       return list;

    }

    //多文件上传
    @Override
    public int addPoint(PointLocation pt) {
        PointLocation pt1=new PointLocation();
        pt1.setPid(pt.getPid());
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
    @Transactional
    public boolean delete(String pid) {
        boolean flag=false;
        try{
            pm.delete(pid);
            pm.deleteFile(pid);
            pm.deleteFm(pid);
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
        List<PointLocation> researchers = pm.likeSelect(eventcode, countyname, countycode, b, pageSize);
        PostPt tada = new PostPt();
        tada.setSelect(researchers);
        int likeTable = pm.getLikeTable(eventcode, countyname, countycode);
        tada.setPages(likeTable);
        return tada;
    }

    /*文件上传*/
    @Override
    public int filesUpload(PointLocation upFile) {

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
    public List<PointLocation> selectAllFile(String pid) {
        return pm.selectAllFile(pid);
    }

    /*单个添加对象*/
    @Override
    public int selectByIds(List list) {
        return pm.selectByIds(list);
    }
    /*多个添加对象*/
    @Override
    public void insetPersons(List<PointLocation> rcList) {
        pm.insetPersons(rcList);
    }
}
