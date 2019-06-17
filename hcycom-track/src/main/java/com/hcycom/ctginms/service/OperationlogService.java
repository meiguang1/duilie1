package com.hcycom.ctginms.service;

import com.hcycom.ctginms.domain.OperationLog;
import com.hcycom.ctginms.domain.PageBean;

import java.util.List;

/**
 * @ClassName: OperationlogService
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/12 10:35
 **/
public interface OperationlogService {

    int selectCount();

    List<OperationLog> getAll();

    PageBean<OperationLog> getQueryPage(int currentPage,int pageSize,String projectname,String operationname);
}
