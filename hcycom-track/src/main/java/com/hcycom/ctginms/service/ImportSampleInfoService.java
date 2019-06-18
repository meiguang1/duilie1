package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.ImportSampleInfo;

import java.util.List;

/**
 * @ClassName: ImportSampleInfoService
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/18 16:06
 **/
public interface ImportSampleInfoService {

    int addSampleInfo(ImportSampleInfo importSampleInfo);

    List<ImportSampleInfo> getSampleInfo(String eventCode);
}
