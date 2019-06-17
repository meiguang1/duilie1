package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.Pt;
import com.hcycom.ctginms.postdomain.PostFm;
import com.hcycom.ctginms.postdomain.PostPt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PtService {
    //根据事件编码查询全部人员
    List<Pt> getEventAll(String eventcode);
    //查询已上传文件的路劲和名字
    List<Pt> healthForm(String pid,String eventcode);

    //新增一个人员（该方法仅单个添加）返回新增人员的id
    int addPoint(Pt pt);

    //通过id，删除单个人员信息（逻辑删除，更改状态）
    boolean delete(int id);


    //按照事件编码对点位编号以及姓名进行查询
    PostPt likeSelect(String eventcode, String countyname, String countycode, int page, int pageSize);

    /*文件上传*/
    int filesUpload(Pt upFile);
    /*文件下载*/
    List<Pt> selectAllFile(String pid);

    //单个添加对象
    int selectByIds(List list);
    //批量添加对象
    void insetPersons(List<Pt> rcList);
}
