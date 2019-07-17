package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.Respondent;
import com.hcycom.ctginms.postdomain.Tada;

import java.util.List;

public interface RespondentService {
    //查询全部
    List<Respondent> getAll();

    //按照项目编码对调查对象编号以及姓名进行查询以及分页
    Tada paging(String researchname, String researchcode, String projectcode, String countycode, String start, String finish, int page, int pageSize);

}
