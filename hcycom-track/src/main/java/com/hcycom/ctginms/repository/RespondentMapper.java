package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.Respondent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RespondentMapper {

    //查询全部
    List<Respondent> getAll();

    //按照项目编码对调查对象编号以及姓名进行查询(分页)
    List<Respondent> paging(@Param("researchname")String researchname,
                                @Param("researchcode")String researchcode,
                                @Param("projectcode")String projectcode,
                                @Param("countycode")String countycode,
                                @Param("start")String start,
                                @Param("finish")String finish,
                                @Param("page") int page,
                                @Param("pageSize") int pageSize);

    //按照项目编码对调查对象编号以及姓名进行查询(总条数)
    int getLikeTable(@Param("researchname")String researchname,
                     @Param("researchcode")String researchcode,
                     @Param("projectcode")String projectcode,
                     @Param("countycode")String countycode,
                     @Param("start")String start,
                     @Param("finish")String finish);
}
