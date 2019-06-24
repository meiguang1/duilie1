package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.ImportSampleInfo;
import com.netflix.ribbon.proxy.annotation.ClientProperties;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ImportSampleInfoMapper
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/18 15:37
 **/
@Mapper
public interface ImportSampleInfoMapper {
    /**
     * 添加入库信息记录至import_sample_info表
     * @param importSampleInfo
     * @return
     */
    int addSampleInfo(@Param("importSampleInfo")ImportSampleInfo importSampleInfo);

    /**
     * 查询某个事件下所有入库操作信息记录
     * @param eventCode
     * @return
     */
    List<ImportSampleInfo> getSampleInfo(@Param("eventCode")String eventCode);

    /**
     * 根据入库信息编码删除虚拟库import_sample_model中的数据
     * @param sampleInfoCode
     * @return
     */
    int delSampleModelByCode(@Param("sampleInfoCode")String sampleInfoCode);

    /**
     * 根据入库信息编码，查询已入到正式样本sample库中的数据
     * @param sampleInfoCode
     * @return
     */
    List<Map<String,?>> findSampleByxnCode(@Param("sampleInfoCode")String sampleInfoCode);
}
