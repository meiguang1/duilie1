package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.Pt;
import com.hcycom.ctginms.postdomain.PostPt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PtMapper {
    //根据事件编码查询全部人员
    List<Pt> selectEventAll(@Param("eventcode")String eventcode);


    //查询已上传文件的路劲和名字
    List<Pt> healthForm(@Param("pid")String pid,
                      @Param("eventcode") String eventcode);

    //新增一个点位（该方法仅单个添加）返回新增点位的id
    int addPoint(@Param("pt") Pt pt);

    //通过id，删除单个人员信息（逻辑删除，更改状态）
    boolean delete(int id);

    //按照事件编码对点位编号以及姓名进行查询
    List<Pt> likeSelect(@Param("eventcode")String eventcode,
                            @Param("countyname")String countyname,
                            @Param("countycode")String countycode,
                            @Param("page") int page,
                            @Param("pageSize") int pageSize);

    //按照事件编码对点位编号以及姓名进行查询
    int getLikeTable(@Param("eventcode")String eventcode,
                     @Param("countyname")String countyname,
                     @Param("countycode")String countycode);


    /*文件上传*/
    int filesUpload(Pt upFile);
    /*文件下载*/
    List<Pt> selectAllFile(@Param("pid")String pid);

    int selectByIds(@Param("list")List list);

    void insetPersons(@Param("list")List list);
}
