package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.AuditSample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: AuditSampleMapper
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/26 15:21
 **/
@Mapper
public interface AuditSampleMapper {

    /**
     * 查询所有审核数据
     * @return
     */
    List<AuditSample> getAll();

    /**
     * 在预出库操作完成后，添加一条审核数据至审核表
     * @return
     */
    int addAudit(@Param("as")AuditSample as);

    /**
     * 审核未读的审核消息，修改状态为通过或不通过
     * @param as
     * @return
     */
    int updateAudit(@Param("as")AuditSample as);

    /**
     * 根据审核编码查询审核信息
     * @param audit_code
     * @return
     */
    AuditSample findAuditBycode(@Param("audit_code")String audit_code);


    /**
     * 根据出库信息编码查询审核信息
     * @param export_sampleinfo_code
     * @return
     */
    AuditSample findAuditByExportSampleCode(@Param("export_sampleinfo_code")String export_sampleinfo_code);



}
