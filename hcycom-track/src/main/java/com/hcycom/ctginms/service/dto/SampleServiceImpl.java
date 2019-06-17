package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.ImportSampleModel;
import com.hcycom.ctginms.domain.OperationLog;
import com.hcycom.ctginms.domain.PageBean;
import com.hcycom.ctginms.domain.Sample;
import com.hcycom.ctginms.postdomain.PostSample;
import com.hcycom.ctginms.repository.SampleMapper;
import com.hcycom.ctginms.service.SampleService;
import groovy.beans.Vetoable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SampleServiceImpl
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/11 16:59
 **/
@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleMapper sampleMapper;

    @Override
    public List<Map<String,?>> getSampleByEventtcode(String eventcode) {
        // TODO Auto-generated method stub
        List<Map<String,?>> sampleList = sampleMapper.getSampleByEventtcode(eventcode);
        return sampleList;
    }

    @Override
    public OperationLog getOperationlog(String describe){
        OperationLog operationLog = sampleMapper.getOperationlog(describe);
        return operationLog;
    }
    @Override
    public List<String> getQueryPageone(PostSample postSample){
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<OperationLog> pageBean = new PageBean<OperationLog>();

        //封装当前页数
        pageBean.setCurrPage(postSample.getCurrentPage());

        //每页显示的数据
        pageBean.setPageSize(postSample.getPageSize());

        //封装总记录数
        int totalCount = sampleMapper.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/postSample.getPageSize());//向上取整
        pageBean.setTotalPage(num.intValue());
        map.put("start",(postSample.getCurrentPage()-1)*postSample.getPageSize());
        map.put("size", pageBean.getPageSize());
        map.put("samplecode", postSample.getSamplecode());
        map.put("personcode", postSample.getPersoncode());
        map.put("researchname", postSample.getResearchname());
        map.put("cryopreservedcode", postSample.getCryopreservedcode());
        map.put("starttime", postSample.getStarttime());
        map.put("endtime", postSample.getEndtime());
        //封装每页显示的数据
        List<String> lists = sampleMapper.getQueryPageone(map);
        return lists;
    }

    @Override
    public List<Map<String,?>> getQueryPagetwo(List<String> list,String eventcode,String starttime,String endtime){
        List<Map<String,?>> sampleList = sampleMapper.getQueryPagetwo(list,eventcode,starttime,endtime);
        return sampleList;
    }

    @Override
    public List<Sample> getAll() {
        return sampleMapper.getAll();
    }

    @Override
    public int selectCount(){
        return sampleMapper.selectCount();
    }

    @Override
    public List<Map<String,?>> getStatistics(String eventcode){
        List<Map<String,?>> sampleList = sampleMapper.getStatistics(eventcode);
        return sampleList;
    }

    @Override
    public int importSample(List<ImportSampleModel> payFeeList){
        return sampleMapper.importSample(payFeeList);
    }
}
