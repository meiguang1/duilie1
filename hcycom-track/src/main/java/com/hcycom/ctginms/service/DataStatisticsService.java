package com.hcycom.ctginms.service;

import com.hcycom.ctginms.postdomain.PostDataStatistics;



public interface DataStatisticsService {
    //<!--数据统计:调查人数-->
    PostDataStatistics sampleSize(String eventcode);

    //<!--数据统计:男女比例树状图-->
    PostDataStatistics maleFemaleRatio(String eventcode);

    //<!--数据统计:年龄比例柱状图-->
    PostDataStatistics theAgeRatio(String eventcode);
}
