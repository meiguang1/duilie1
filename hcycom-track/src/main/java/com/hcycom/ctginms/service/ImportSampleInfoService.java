package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.ImportSampleInfo;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ImportSampleInfoService
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/18 16:06
 **/
public interface ImportSampleInfoService {

    int addSampleInfo(ImportSampleInfo importSampleInfo);

    List<ImportSampleInfo> getSampleInfo(String eventCode);

    int delSampleModelByCode(String sampleInfoCode);

    List<Map<String,?>> findSampleByxnCode(String sampleInfoCode);

    int updateSampleInfo(String sampleInfoCode);
}
