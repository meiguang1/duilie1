package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.County;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: CountyMapper
 * @Description: 区县表dao
 * @Author: 白敏
 * @Date: 2019/4/17 15:31
 **/
@Mapper
public interface CountyMapper {

    /**
     * 根据项目查询全部区县
     * @param projectcode
     * @return
     */
    List<County> getCountyByProjectcode(@Param("projectcode")String projectcode);

    /**
     * 单个添加区县
     * @param county
     * @return
     */
    int addCounty(@Param("county")County county);

    /**
     * 修改区县信息
     * @param county
     * @return
     */
    int updateCountyById(@Param("county")County county);

    /**
     * 删除区县信息（逻辑删除，更改状态）
     * @param id
     * @return
     */
    int deleteCountyById(@Param("id")int id);


    /**
     * 按照项目编码对区县编号以及姓名进行查询(分页)
     * @param projectcode
     * @param countyname
     * @param countycode
     * @param page
     * @param pageSize
     * @return
     */
    List<County> likeSelect(@Param("projectcode")String projectcode,
                            @Param("countyname")String countyname,
                            @Param("countycode")String countycode,
                            @Param("page") int page ,
                            @Param("pageSize") int pageSize);

    /**
     * 按照项目编码对区县编号以及姓名进行查询(总条数)
     * @param projectcode
     * @param countyname
     * @param countycode
     * @return
     */
    int getLikeTable(@Param("projectcode")String projectcode,
                     @Param("countyname")String countyname,
                     @Param("countycode")String countycode);


    /**
     * 模态框查询符合条件的区县 并且分页
     * @param projectcode
     * @return
     */
    List<County> getCountyBy(@Param("projectcode")String projectcode);

    List<County> likeCountyBy(@Param("projectcode")String projectcode,
                            @Param("countyname")String countyname,
                            @Param("countycode")String countycode,
                            @Param("page") int page ,
                            @Param("pageSize") int pageSize);

    /**
     * 按照项目编码对区县编号以及姓名进行查询(总条数)
     * @param projectcode
     * @param countyname
     * @param countycode
     * @return
     */
    int likegetTable(@Param("projectcode")String projectcode,
                     @Param("countyname")String countyname,
                     @Param("countycode")String countycode);

    /**
     * 项目中区县管理的文件上传
     */
    int  importSample(@Param("payFeeList")List payFeeList);
}
