package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.ImportSampleModel;
import com.hcycom.ctginms.domain.OperationLog;
import com.hcycom.ctginms.domain.Sample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SampleMapper
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/11 17:01
 **/
@Mapper
public interface SampleMapper {

    /**
     * 根据事件查询全部样本
     * @param eventcode
     * @return
     */
    List<Map<String,?>> getSampleByEventtcode(@Param("eventcode")String eventcode);

    /**
     * 根据操作表叙述查询操作日志
     * @param describe
     * @return
     */
    OperationLog getOperationlog(@Param("describe")String describe);

    /**
     * 分页加模糊查询出调查对象编号
     * @param map
     * @return
     */
    List<String> getQueryPageone(HashMap<String,Object> map);

    /**
     * 根据分页获取的调查对象编号获取所有的样本列表
     * @param queryList
     * @return
     */
    List<Map<String,?>> getQueryPagetwo(@Param("queryList")List<String> queryList,@Param("eventcode")String eventcode,@Param("starttime")String starttime,@Param("endtime")String endtime);

    /**
     * 查询所有样本列表
     * @return
     */
    List<Sample> getAll();

    /**
     * 查询样本列表记录总数
     * @return
     */
    int selectCount();

    /**
     * 统计样本表中每个调查对象的各样本条数
     * @param eventcode
     * @return
     */
    List<Map<String,?>> getStatistics(@Param("eventcode")String eventcode);

    /**
     * 将csv数据导入临时表import_sample_model中
     * @param payFeeList
     * @return
     */
    int  importSample(@Param("payFeeList")List payFeeList);
    //int  importSample(List<ImportSampleModel> payFeeList);


}
