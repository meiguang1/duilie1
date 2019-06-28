package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.PointLocation;
import com.hcycom.ctginms.postdomain.PostPt;


import java.util.List;

public interface PointLocationService {
    //根据事件编码查询全部人员
    List<PointLocation> getEventAll(String eventcode);
    //查询已上传文件的路劲和名字
    List<PointLocation> healthForm(String pid,String eventcode);

    //新增一个人员（该方法仅单个添加）返回新增人员的id
    int addPoint(PointLocation pt);

    //通过id，删除单个人员信息（逻辑删除，更改状态）
    boolean delete(String pid);


    //按照事件编码对点位编号以及姓名进行查询
    PostPt likeSelect(String eventcode, String countyname, String countycode, int page, int pageSize);

    /*文件上传*/
    int filesUpload(PointLocation upFile);
    /*文件下载*/
    List<PointLocation> selectAllFile(String pid);

    //单个添加对象
    int selectByIds(List list);
    //批量添加对象
    void insetPersons(List<PointLocation> rcList);
}
