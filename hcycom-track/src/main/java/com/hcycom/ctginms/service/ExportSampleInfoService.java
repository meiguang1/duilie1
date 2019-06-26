package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.ExportSampleInfo;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ExportSampleInfoService
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/25 16:23
 **/
public interface ExportSampleInfoService {

    List<ExportSampleInfo> findEsiByEventcode(String eventcode);

    List<Map<String,?>> findSampleByPointorInfo(String eventcode, String pointname, String entrepotname);

    List<Map<String,?>> findExportsamplemodel(String eventcode,String exportsampleinfocode);
}
