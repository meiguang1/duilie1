package com.hcycom.ctginms.service;


import com.hcycom.ctginms.domain.Researcher;
import com.hcycom.ctginms.postdomain.PostFm;
import com.hcycom.ctginms.postdomain.PostResearcher;


import java.util.List;


public interface ResearcherService {
    //根据事件编码查询全部人员
    List<Researcher> getEventAll(String eventcode);

    /*分页查询所有数据
    @param page //当前页
    @param pageSize //每页记录数
    List<Researcher> findUserListByPage(int page,int pageSize,String researchname, String researchcode,String eventcode);
    List<Researcher> likeSelect(String eventcode, String researchname, String researchcode,int page,int pageSize);
    */


    //通过id，删除单个人员信息
    boolean delete(int id);

    //新增一个人员（该方法仅单个添加）返回新增人员的id
    int addOnePerson(Researcher researcher);

    //按照事件编码对调查对象编号以及姓名进行查询
    PostResearcher likeSelect(String eventcode, String researchname, String researchcode, int page, int pageSize);

    /*查询文件上传数量以及需要上传的数量*/
    PostFm uploadingAll(String pid,String eventcode,String position);

}
