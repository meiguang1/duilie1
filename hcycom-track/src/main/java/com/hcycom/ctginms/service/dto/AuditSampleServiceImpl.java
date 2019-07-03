package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.AuditSample;
import com.hcycom.ctginms.repository.AuditSampleMapper;
import com.hcycom.ctginms.service.AuditSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: AuditSampleServiceImpl
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/26 16:01
 **/
@Service
public class AuditSampleServiceImpl implements AuditSampleService {

    @Autowired
    private AuditSampleMapper auditSampleMapper;

    @Override
    public List<AuditSample> getAll(){
        return auditSampleMapper.getAll();
    }

    @Override
    public int addAudit(AuditSample as){
        return auditSampleMapper.addAudit(as);
    }

    @Override
    public int updateAudit(AuditSample as){
        return auditSampleMapper.updateAudit(as);
    }

    @Override
    public AuditSample findAuditBycode(String audit_code){
        return auditSampleMapper.findAuditBycode(audit_code);
    }

    @Override
    public AuditSample findAuditByExportSampleCode(String export_sampleinfo_code){ return auditSampleMapper.findAuditByExportSampleCode(export_sampleinfo_code); }

}
