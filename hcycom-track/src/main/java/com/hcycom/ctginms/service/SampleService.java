package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.ImportSampleModel;
import com.hcycom.ctginms.domain.OperationLog;
import com.hcycom.ctginms.domain.Sample;
import com.hcycom.ctginms.postdomain.PostSample;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SampleService
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/11 16:59
 **/
public interface SampleService {

   List<Map<String,?>> getSampleByEventtcode(String eventcode);

   OperationLog getOperationlog(String describe);

   List<String> getQueryPageone(PostSample postSample);

   List<Map<String,?>> getQueryPagetwo(List<String> list,String eventcode,String starttime,String endtime);

   int selectCount();

   List<Sample> getAll();

   List<Map<String,?>> getStatistics(String eventcode);

   int  importSample(List<ImportSampleModel> payFeeList);
}
