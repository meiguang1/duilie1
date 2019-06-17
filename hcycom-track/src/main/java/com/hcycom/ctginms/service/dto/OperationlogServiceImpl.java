package com.hcycom.ctginms.service.dto;

import com.hcycom.ctginms.domain.OperationLog;
import com.hcycom.ctginms.domain.PageBean;
import com.hcycom.ctginms.repository.OperationlogMapper;
import com.hcycom.ctginms.service.OperationlogService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: OperationlogServiceImpl
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/12 10:36
 **/
@Service
public class OperationlogServiceImpl implements OperationlogService{

    @Autowired
    private OperationlogMapper operationlogMapper;

    @Override
    public List<OperationLog> getAll() {
        return operationlogMapper.getAll();
    }

    @Override
    public int selectCount(){
        return operationlogMapper.selectCount();
    }

    @Override
    public PageBean<OperationLog> getQueryPage(int currentPage,int pageSize,String projectname,String operationname) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<OperationLog> pageBean = new PageBean<OperationLog>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = operationlogMapper.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        if(projectname==null&&operationname==null){
            map.put("start",(currentPage-1)*pageSize);
            map.put("size", pageBean.getPageSize());
            //封装每页显示的数据
            List<OperationLog> lists = operationlogMapper.findByPage(map);
            pageBean.setLists(lists);
        }else{
            map.put("start",(currentPage-1)*pageSize);
            map.put("size", pageBean.getPageSize());
            map.put("projectname", projectname);
            map.put("operationname", operationname);
            //封装每页显示的数据
            List<OperationLog> lists = operationlogMapper.getQueryPage(map);
            pageBean.setLists(lists);
        }
        return pageBean;
    }

}
