package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.Event;
import com.hcycom.ctginms.domain.Researcher;
import com.hcycom.ctginms.postdomain.PostFm;
import com.hcycom.ctginms.postdomain.PostResearcher;
import com.hcycom.ctginms.repository.ResearcherMapper;
import com.hcycom.ctginms.service.ResearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
ResearcherServiceImpl implements ResearcherService{
    @Autowired
    private ResearcherMapper ps;




    //按照事件编码进行查询
    @Override
    public List<Researcher> getEventAll(String eventcode) {
        Event event=new Event();
        System.out.println(event.getEventcode());
        List<Researcher> plist = ps.selectEventAll(eventcode);
        return plist;
    }

  /*  分页,并且按照事件编码
    @Override
    public List<Researcher> findUserListByPage(int page, int pageSize, String researchname, String researchcode,String eventcode) {
        int b=0;
        if (page > 1) {
            b = (page - 1) * pageSize ;
        }
        List<Researcher> findUserListByPage = ps.findUserListByPage(b, pageSize,researchname,researchcode,eventcode);
        return findUserListByPage;
    }*/


    //按照id进行删除
    @Override
    public boolean delete(int id) {
        boolean flag=false;
        try{
            ps.delete(id);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }

    //添加
    @Override
    public int addOnePerson(Researcher researcher) {

        Researcher researcher1=new Researcher();
        researcher1.setEventcode(researcher.getEventcode());
        researcher1.setResearchcode(researcher.getResearchcode());
        researcher1.setAge(researcher.getAge());
        researcher1.setSex(researcher.getSex());
        researcher1.setResearchname(researcher.getResearchname());
        researcher1.setPosition(researcher.getPosition());
        researcher1.setProjectcode(researcher.getProjectcode());

        ps.addOnePerson(researcher1);

        int id = researcher1.getId();
        return id;
    }

    //按照事件编码对调查对象编号以及姓名进行查询
    @Override
    public PostResearcher likeSelect(String eventcode, String researchname, String researchcode, int page, int pageSize) {
        int b=0;
        if (page > 1) {
            b = (page - 1) * pageSize ;
        }
        List<Researcher> researchers = ps.likeSelect(eventcode, researchname, researchcode, b, pageSize);
        PostResearcher tada = new PostResearcher();
        tada.setSelect(researchers);
        int likeTable = ps.getLikeTable(eventcode, researchname, researchcode);
        tada.setPages(likeTable);
        return tada;
    }


    /*查询文件上传数量以及文件需要上传数量*/
    @Override
    public PostFm uploadingAll(String pid,String eventcode,String position) {
        int i = ps.uploadingAll(eventcode,position);
        PostFm postFm=new PostFm();
        postFm.setLikeSelect(i);
        int i1 = ps.uploading(pid);
        postFm.setLikeSelectOne(i1);
        return postFm;
    }
}
