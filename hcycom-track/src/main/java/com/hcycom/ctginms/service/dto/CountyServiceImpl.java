package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.County;
import com.hcycom.ctginms.postdomain.PostCounty;
import com.hcycom.ctginms.postdomain.Tada;
import com.hcycom.ctginms.repository.CountyMapper;
import com.hcycom.ctginms.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CountyServiceImpl
 * @Description: 区县表service实现类
 * @Author: 白敏
 * @Date: 2019/4/17 15:06
 **/
@Service
public class CountyServiceImpl implements CountyService{
    @Autowired
    private CountyMapper countyMapper;

    @Override
    public List<County> getCountyByProjectcode(String projectcode) {
        // TODO Auto-generated method stub
        List<County> countyList = countyMapper.getCountyByProjectcode(projectcode);
        return countyList;
    }

    @Override
    public int addCounty(PostCounty county) {
        // TODO Auto-generated method stub
        County county1=new County();
        county1.setId(county.getId());
        county1.setCountycode(county.getCountycode());
        county1.setCountyname(county.getCountyname());
        county1.setProjectcode(county.getProjectcode());
        countyMapper.addCounty(county1);
        int id = county1.getId();
        return id;
    }

    @Override
    public int updateCountyById(PostCounty county) {
        // TODO Auto-generated method stub
        County county1=new County();
        county1.setId(county.getId());
        county1.setCountycode(county.getCountycode());
        county1.setCountyname(county.getCountyname());
        county1.setProjectcode(county.getProjectcode());
        int a = countyMapper.updateCountyById(county1);
        return a;
    }

    @Override
    public int deleteCountyById(int id) {
        // TODO Auto-generated method stub
        int a = countyMapper.deleteCountyById(id);
        return a;
    }

    @Override
    public Tada likeSelect(String projectcode, String countyname, String countycode, int page, int pageSize) {
        int b=0;
        if (page > 1) {
            b = (page - 1) * pageSize ;
        }
        List<County> researchers = countyMapper.likeSelect(projectcode, countyname, countycode, b, pageSize);
        Tada tada = new Tada();
        tada.setSelect(researchers);
        int likeTable = countyMapper.getLikeTable(projectcode, countyname, countycode);
        tada.setPages(likeTable);
        return tada;
    }

    @Override
    public List<County> getCountyBy(String projectcode) {
        /*int b=0;
        if (page > 1) {
            b = (page - 1) * pageSize ;
        }*/
        List<County> countyList = countyMapper.getCountyBy(projectcode);
        return countyList;
    }

    @Override
    public Tada likeCountyBy(String projectcode, String countyname, String countycode, int page, int pageSize) {
        int b=0;
        if (page > 1) {
            b = (page - 1) * pageSize ;
        }
        List<County> researchers = countyMapper.likeCountyBy(projectcode, countyname, countycode, b, pageSize);
        Tada tada = new Tada();
        tada.setSelect(researchers);
        int likeTable = countyMapper.likegetTable(projectcode, countyname, countycode);
        tada.setPages(likeTable);
        return tada;
    }
}
