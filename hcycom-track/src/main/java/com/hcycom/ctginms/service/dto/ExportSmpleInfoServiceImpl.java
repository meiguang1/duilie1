package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.*;
import com.hcycom.ctginms.repository.ExportSampleInfoMapper;
import com.hcycom.ctginms.service.ExportSampleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ExportSmpleInfoServiceImpl
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/25 16:28
 **/
@Service
public class ExportSmpleInfoServiceImpl implements ExportSampleInfoService{

    @Autowired
    private ExportSampleInfoMapper exportSampleInfoMapper;

    @Override
    public List<ExportSampleInfo> findEsiByEventcode(String eventcode){
        return exportSampleInfoMapper.findEsiByEventcode(eventcode);
    }

    @Override
    public List<Map<String,?>> findSampleByPointorInfo(String eventcode, String pointname, String entrepotname){
        return exportSampleInfoMapper.findSampleByPointorInfo(eventcode,pointname,entrepotname);
    }

    @Override
    public  List<Map<String,?>> findExportsampleorder(String eventcode,String exportsampleinfocode){
        return exportSampleInfoMapper.findExportsampleorder(eventcode,exportsampleinfocode);
    }

    @Override
    public int addExportsampleorder(List<ExportSampleOrder> esoList){
        return exportSampleInfoMapper.addExportsampleorder(esoList);
    }

    @Override
    public int addExportsampleinfo(ExportSampleInfo esi){
        return exportSampleInfoMapper.addExportsampleinfo(esi);
    }

    @Override
    public int updateExportsampleinfo(ExportSampleInfo esi){
        return exportSampleInfoMapper.updateExportsampleinfo(esi);
    }

    @Override
    public int deleExportsampleorder(String export_sampleinfo_code){
        return exportSampleInfoMapper.deleExportsampleorder(export_sampleinfo_code);
    }

    @Override
    public int addResearchReport(List<ResearchReport> rrList){
        return exportSampleInfoMapper.addResearchReport(rrList);
    }

    @Override
    public int addProcedureOfSingle(ProcedureOfSingle pos){
        return exportSampleInfoMapper.addProcedureOfSingle(pos);
    }

    @Override
    public int addExportSampleFile(ExportSampleFile esf){
        return exportSampleInfoMapper.addExportSampleFile(esf);
    }

    @Override
    public ProcedureOfSingle findPosBycode(String export_sampleinfo_code){
        return exportSampleInfoMapper.findPosBycode(export_sampleinfo_code);
    }

    @Override
    public  List<ResearchReport> findResearchReport(String export_sampleinfo_code){
        return exportSampleInfoMapper.findResearchReport(export_sampleinfo_code);
    }

    @Override
    public ExportSampleFile findExportSampleFile(String export_samplefile_code){
        return exportSampleInfoMapper.findExportSampleFile(export_samplefile_code);
    }

    @Override
    public ExportSampleInfo findEsiByCode(String export_sampleinfo_code){
        return exportSampleInfoMapper.findEsiByCode(export_sampleinfo_code);
    }

    @Override
    public List<ExportSampleFile> getExportSampleFileAll(String export_sampleinfo_code){
        return exportSampleInfoMapper.getExportSampleFileAll(export_sampleinfo_code);
    }
}
