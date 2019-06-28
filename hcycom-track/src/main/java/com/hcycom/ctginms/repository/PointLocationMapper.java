package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.PointLocation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointLocationMapper {
    //根据事件编码查询全部人员
    List<PointLocation> selectEventAll(@Param("eventcode")String eventcode);


    //查询已上传文件的路劲和名字
    List<PointLocation> healthForm(@Param("pid")String pid,
                      @Param("eventcode") String eventcode);

    //新增一个点位（该方法仅单个添加）返回新增点位的id
    int addPoint(@Param("pt") PointLocation pointLocation);

    //通过id，删除单个人员信息
    boolean delete(String pid);
    boolean deleteFile(String pid);
    boolean deleteFm(String pid);

    //按照事件编码对点位编号以及姓名进行查询
    List<PointLocation> likeSelect(@Param("eventcode")String eventcode,
                            @Param("countyname")String countyname,
                            @Param("countycode")String countycode,
                            @Param("page") int page,
                            @Param("pageSize") int pageSize);

    //按照事件编码对点位编号以及姓名进行查询
    int getLikeTable(@Param("eventcode")String eventcode,
                     @Param("countyname")String countyname,
                     @Param("countycode")String countycode);


    /*文件上传*/
    int filesUpload(PointLocation upFile);
    /*文件下载*/
    List<PointLocation> selectAllFile(@Param("pid")String pid);

    int selectByIds(@Param("list")List list);

    void insetPersons(@Param("list")List list);
}
