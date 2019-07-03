package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.*;
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
    List<Map<String,?>> findExportsampleorder(@Param("eventcode")String eventcode,@Param("exportsampleinfocode")String exportsampleinfocode);

    /**
     * 批量插入数据至出库单
     * @param esoList
     * @return
     */
    int addExportsampleorder(@Param("esoList")List<ExportSampleOrder> esoList);

    /**
     * 添加一条出库操作信息
     * @param esi
     * @return
     */
    int addExportsampleinfo(@Param("esi")ExportSampleInfo esi);

    /**
     * 在审核完成后，修改出库信息表中的审核状态
     * @param esi
     * @return
     */
    int updateExportsampleinfo(@Param("esi")ExportSampleInfo esi);

    /**
     * 根据出库信息编码删除出库单中的数据
     * @param export_sampleinfo_code
     * @return
     */
    int deleExportsampleorder(@Param("export_sampleinfo_code")String export_sampleinfo_code);

    /**
     * 样品报告上传
     * @param rrList
     * @return
     */
    int addResearchReport(@Param("rrList")List<ResearchReport> rrList);

    /**
     * 添加出库手续单信息
     * @param pos
     * @return
     */
    int addProcedureOfSingle(@Param("pos")ProcedureOfSingle pos);

    /**
     * 上传出库相关文件,保存文件信息
     * @param esf
     * @return
     */
    int addExportSampleFile(@Param("esf")ExportSampleFile esf);

    /**
     * 查询出库手续单信息
     * @param export_sampleinfo_code
     * @return
     */
    ProcedureOfSingle findPosBycode(@Param("export_sampleinfo_code")String export_sampleinfo_code);

    /**
     * 查询当前研究报告信息
     * @param export_sampleinfo_code
     * @return
     */
    List<ResearchReport> findResearchReport(@Param("export_sampleinfo_code")String export_sampleinfo_code);

    /**
     * 查询出库手续单上传信息
     * @param export_samplefile_code
     * @return
     */
    ExportSampleFile findExportSampleFile(@Param("export_samplefile_code")String export_samplefile_code);

    /**
     * 根据出库信息编码查询出库信息
     * @param export_sampleinfo_code
     * @return
     */
    ExportSampleInfo findEsiByCode(@Param("export_sampleinfo_code")String export_sampleinfo_code);

    /**
     * 查询当前出库信息的所有上传文件信息
     * @param export_sampleinfo_code
     * @return
     */
    List<ExportSampleFile> getExportSampleFileAll(@Param("export_sampleinfo_code")String export_sampleinfo_code);
}
