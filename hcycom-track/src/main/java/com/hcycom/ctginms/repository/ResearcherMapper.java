package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.Researcher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ResearcherMapper {
    //根据事件编码查询全部人员
    List<Researcher> selectEventAll(@Param("eventcode")String eventcode);

    //通过id，删除单个人员信息
    boolean delete(int id);

    //新增一个人员（该方法仅单个添加）返回新增人员的id
    int addOnePerson(@Param("researcher") Researcher researcher);

   /* 分页,并且以事件编码进行分页
    List<Researcher>  findUserListByPage(@Param("page") int page ,
                                         @Param("pageSize") int pageSize,
                                         @Param("researchname")String researchname,
                                         @Param("researchcode")String researchcode,
                                         @Param("eventcode") String eventcode);*/

    //按照事件编码对调查对象编号以及姓名进行查询
    List<Researcher> likeSelect(@Param("eventcode")String eventcode,
                                @Param("researchname")String researchname,
                                @Param("researchcode")String researchcode,
                                @Param("page") int page ,
                                @Param("pageSize") int pageSize);

    //按照事件编码对调查对象编号以及姓名进行查询 总条数
    int getLikeTable(@Param("eventcode")String eventcode,
                     @Param("researchname")String researchname,
                     @Param("researchcode")String researchcode);

    //查询人员应该上传文件的总数
    int uploadingAll(@Param("eventcode")String eventcode,@Param("position")String position);
    //查询上传数量
    int uploading(String pid);

}
