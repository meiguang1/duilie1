package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.ImportSampleInfo;
import com.hcycom.ctginms.repository.ImportSampleInfoMapper;
import com.hcycom.ctginms.service.ImportSampleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ImportSampleInfoServiceImpl
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/18 16:08
 **/
@Service
public class ImportSampleInfoServiceImpl implements ImportSampleInfoService{

    @Autowired
    private ImportSampleInfoMapper importSampleInfoMapper;

    public int addSampleInfo(ImportSampleInfo importSampleInfo){
        return importSampleInfoMapper.addSampleInfo(importSampleInfo);
    }

    public List<ImportSampleInfo> getSampleInfo(String eventCode){
        return importSampleInfoMapper.getSampleInfo(eventCode);
    }
}
