package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.*;

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

    List<Map<String,?>> findExportsampleorder(String eventcode,String exportsampleinfocode);

    int addExportsampleorder(List<ExportSampleOrder> esoList);

    int addExportsampleinfo(ExportSampleInfo esi);

    int updateExportsampleinfo(ExportSampleInfo esi);

    int deleExportsampleorder(String export_sampleinfo_code);

    int addResearchReport(List<ResearchReport> rrList);

    int addProcedureOfSingle(ProcedureOfSingle pos);

    int addExportSampleFile(ExportSampleFile esf);

    ProcedureOfSingle findPosBycode(String export_sampleinfo_code);

    List<ResearchReport> findResearchReport(String export_sampleinfo_code);

    ExportSampleFile findExportSampleFile(String export_samplefile_code);

    ExportSampleInfo findEsiByCode(String export_sampleinfo_code);

    List<ExportSampleFile> getExportSampleFileAll(String export_sampleinfo_code);

    List<ExportSampleOrder> findExportSampleOrderByesc(String export_sampleinfo_code);
}
