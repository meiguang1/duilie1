package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.Researcher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataStatisticsMapper {

    //<!--数据统计:调查人数:点位编码、点位名称、预计人数-->
    List<Map> sampleSize(@Param("eventcode") String eventcode);
    //<!--数据统计:调查人数:实际人数-->
    List<Map> effectiveStrength(@Param("eventcode") String eventcode);

    //<!--数据统计:男女比例树状图:各点位男女数据统计-->
    List<Map> maleFemaleRatio(@Param("eventcode") String eventcode);
    //<!--数据统计:男女比例树状图:男女各个总数-->
    List<Map> headcount(@Param("eventcode") String eventcode);

    //<!--数据统计:年龄比例柱状图:各点位不同年龄段的数据统计-->
    List<Map> theAgeRatio(@Param("eventcode") String eventcode);
    //<!--数据统计:年龄比例柱状图:人数总计-->
    int aggregate(@Param("eventcode") String eventcode);

}
