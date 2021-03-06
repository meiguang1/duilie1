package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.ImportSampleModel;
import com.hcycom.ctginms.domain.OperationLog;
import com.hcycom.ctginms.domain.Person;
import com.hcycom.ctginms.domain.Sample;
import com.hcycom.ctginms.postdomain.PostSample;
import com.hcycom.ctginms.postdomain.PostSampletwo;
import org.springframework.web.multipart.MultipartFile;

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

   Sample findSampleBycode(String sample_code);

   OperationLog getOperationlog(String describe);

   List<String> getQueryPageone(PostSample postSample);

   List<Map<String,?>> getQueryPagetwo(List<String> list,String eventcode,String starttime,String endtime);

   int selectCount(String eventcode);

   List<Sample> getAll();

   List<Map<String,?>> getStatistics(String eventcode);

   int  importSampleModel(MultipartFile multipartFile,String sample_info_code) throws Exception;

   List<ImportSampleModel> findSampleModelByCode(String sampleModeCode);

   int addSample(List<PostSampletwo> sampleList);

   int updateSample(Sample sample);

}
