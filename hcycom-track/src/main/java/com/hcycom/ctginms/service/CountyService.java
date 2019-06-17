package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.County;
import com.hcycom.ctginms.postdomain.PostCounty;
import com.hcycom.ctginms.postdomain.Tada;

import java.util.List;

/**
 * @ClassName: CountyService
 * @Description: 区县service
 * @Author: 白敏
 * @Date: 2019/4/17 14:58
 **/
public interface CountyService {
    //根据项目编码code,获取查询全部区县
    List<County> getCountyByProjectcode(String projectcode);

    //单个添加区县
    int addCounty(PostCounty county);

    ///修改区县信息
    int updateCountyById(PostCounty county);

    //除区县信息（逻辑删除，更改状态）
    int deleteCountyById(int id);

    //按照项目编码区县编码以及区县名称进行查询和及分页
    Tada likeSelect(String projectcode, String countyname, String countycode, int page, int pageSize);

    //根据项目编码code,获取查询全部区县
    List<County> getCountyBy(String projectcode);

    Tada likeCountyBy(String projectcode, String countyname, String countycode, int page, int pageSize);


}
