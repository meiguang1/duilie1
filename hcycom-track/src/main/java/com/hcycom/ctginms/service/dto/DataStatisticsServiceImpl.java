package com.hcycom.ctginms.service.dto;



import com.hcycom.ctginms.postdomain.PostDataStatistics;
import com.hcycom.ctginms.repository.DataStatisticsMapper;
import com.hcycom.ctginms.service.DataStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {
    @Autowired
    private DataStatisticsMapper data;

    @Override
    public PostDataStatistics sampleSize(String eventcode) {
        List<Map> ptList=data.sampleSize(eventcode);
        List<Map> list=data.effectiveStrength(eventcode);
        PostDataStatistics p=new PostDataStatistics();
        p.setSampleSize(ptList);
        p.setEffectiveStrength(list);
        return p;
    }

    @Override
    public PostDataStatistics maleFemaleRatio(String eventcode) {
        List<Map> list=data.maleFemaleRatio(eventcode);
        List<Map> ptList=data.headcount(eventcode);
        PostDataStatistics p=new PostDataStatistics();
        p.setSampleSize(list);
        p.setEffectiveStrength(ptList);
        return p;
    }

    @Override
    public PostDataStatistics theAgeRatio(String eventcode) {
        List<Map> list=data.theAgeRatio(eventcode);
        System.out.println("------------------------"+list);
        int ptList=data.aggregate(eventcode);
        System.out.println("------------------------"+ptList);
        PostDataStatistics p=new PostDataStatistics();
        p.setSampleSize(list);
        p.setEffectiveStrength(ptList);
        return p;
    }
}
