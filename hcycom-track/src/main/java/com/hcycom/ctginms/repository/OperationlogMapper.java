package com.hcycom.ctginms.repository;

import com.hcycom.ctginms.domain.OperationLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: OperationlogMapper
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/12 10:36
 **/
@Mapper
public interface OperationlogMapper {

    /**
     * 分页操作，调用findByPage limit分页方法
     * @param map
     * @return
     */
    List<OperationLog> findByPage(HashMap<String,Object> map);
    /**
     * 查询所有日志
     * @return
     */
    List<OperationLog> getAll();

    /**
     * 查询用户记录总数
     * @return
     */
    int selectCount();

    /**
     * 模糊查询加分页
     * @param map
     * @return
     */
    List<OperationLog> getQueryPage(HashMap<String,Object> map);
}
