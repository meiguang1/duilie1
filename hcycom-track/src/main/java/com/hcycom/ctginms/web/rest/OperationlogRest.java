package com.hcycom.ctginms.web.rest;

import com.hcycom.ctginms.domain.OperationLog;
import com.hcycom.ctginms.domain.PageBean;
import com.hcycom.ctginms.service.OperationlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: OperationlogRest
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/12 10:34
 **/
@RestController
@RequestMapping(value="/api/operationlogRest")
@Api(tags={"日志管理"},description="operation_log表的相关操作，做日志相关操作")
public class OperationlogRest {

    @Autowired
    private OperationlogService operationlogService;

    @GetMapping("/findByPage")
    @ApiOperation(value="分页查询日志列表", notes="分页查询日志列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "currentPage", value = "第几页", required = true, dataType = "Integer",paramType="query"),
        @ApiImplicitParam(name = "pageSize", value = "每页几条", required = true, dataType = "Integer",paramType="query")
    })
    public PageBean<OperationLog> findByPage(int currentPage,int pageSize){
       // model.addAttribute("pagemsg", operationlogService.findByPage(currentPage));//回显分页数据
        return operationlogService.getQueryPage(currentPage,pageSize,null,null);
    }

    @GetMapping("/getQueryPage")
    @ApiOperation(value="模糊查询加分页查询日志列表", notes="模糊查询加分页查询日志列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "currentPage", value = "第几页", required = true, dataType = "Integer",paramType="query"),
        @ApiImplicitParam(name = "pageSize", value = "每页几条", required = true, dataType = "Integer",paramType="query"),
        @ApiImplicitParam(name = "projectname", value = "项目名称", required = false, dataType = "String",paramType="query"),
        @ApiImplicitParam(name = "operationname", value = "项目操作员", required = false, dataType = "String",paramType="query")
    })
    public PageBean<OperationLog> getQueryPage(int currentPage,int pageSize,String projectname,String operationname){
        // model.addAttribute("pagemsg", operationlogService.findByPage(currentPage));//回显分页数据
        return operationlogService.getQueryPage(currentPage,pageSize,projectname,operationname);
    }
}
