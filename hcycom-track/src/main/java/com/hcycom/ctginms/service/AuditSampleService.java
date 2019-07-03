package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.AuditSample;

import java.util.List;

/**
 * @ClassName: AuditSampleService
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/26 16:00
 **/
public interface AuditSampleService {

    List<AuditSample> getAll();

    int addAudit(AuditSample as);

    int updateAudit(AuditSample as);

    AuditSample findAuditBycode(String audit_code);

    AuditSample findAuditByExportSampleCode(String export_sampleinfo_code);
}
