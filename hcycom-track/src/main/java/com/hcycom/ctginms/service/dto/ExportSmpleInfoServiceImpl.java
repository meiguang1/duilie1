package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.ExportSampleInfo;
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
    public  List<Map<String,?>> findExportsamplemodel(String eventcode,String exportsampleinfocode){
        return exportSampleInfoMapper.findExportsamplemodel(eventcode,exportsampleinfocode);
    }
}
