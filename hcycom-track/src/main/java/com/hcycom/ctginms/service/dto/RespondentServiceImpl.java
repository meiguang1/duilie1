package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.Respondent;
import com.hcycom.ctginms.postdomain.Tada;
import com.hcycom.ctginms.repository.RespondentMapper;
import com.hcycom.ctginms.service.RespondentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespondentServiceImpl implements RespondentService {

    @Autowired
    private RespondentMapper respondentMapper;

    @Override
    public List<Respondent> getAll(){
        return respondentMapper.getAll();
    }

    @Override
    public Tada paging(String researchname, String researchcode, String projectcode, String countycode, String start, String finish, int page, int pageSize) {
        int b=0;
        if (page > 1) {
            b = (page - 1) * pageSize ;
        }
        List<Respondent> researchers = respondentMapper.paging(researchname, researchcode, projectcode, countycode, start, finish, b, pageSize);
        Tada tada = new Tada();
        tada.setSelect(researchers);
        int likeTable = respondentMapper.getLikeTable(researchname, researchcode, projectcode, countycode, start, finish);
        tada.setPages(likeTable);
        return tada;
    }

}
