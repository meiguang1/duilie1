package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.ExportSampleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ExportSampleInfoMapper
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/25 16:11
 **/
@Mapper
public interface ExportSampleInfoMapper {

    /**
     * 根据事件编码查询本事件下所有样本出库信息
     * @param eventcode
     * @return
     */
    List<ExportSampleInfo> findEsiByEventcode(@Param("eventcode")String eventcode);

    /**
     * 根据点位名称或者入库名称查询当前事件下的样本信息
     * @param eventcode
     * @param pointname
     * @param entrepotname
     * @return
     */
    List<Map<String,?>> findSampleByPointorInfo(@Param("eventcode")String eventcode,@Param("pointname")String pointname,@Param("entrepotname")String entrepotname);

    /**
     * 根据事件编码、入库信息编码、查询出当前出库单数据
     * @param eventcode
     * @param exportsampleinfocode
     * @return
     */
    List<Map<String,?>> findExportsamplemodel(@Param("eventcode")String eventcode,@Param("exportsampleinfocode")String exportsampleinfocode);
}
