package com.hcycom.ctginms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hcycom.ctginms.domain.Respondent;
import com.hcycom.ctginms.postdomain.Tada;
import com.hcycom.ctginms.service.RespondentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/respondent")
@Api(tags={"调查对象追踪"},description="调查对象追踪测试")
public class RespondentRest {
    @Autowired
    private RespondentService respondentService;

    @GetMapping("/getAll")
    @Timed
    @ApiOperation(value="测试", notes="测试")
    /*@ApiImplicitParams({
        @ApiImplicitParam(name = "eventcode", value = "事件编码", required = true, dataType = "String",paramType="query"),
    })*/
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public ResponseEntity<List<Respondent>> getAll(){

        List<Respondent> listUsers =respondentService.getAll();
        return new ResponseEntity<List<Respondent>>(listUsers, HttpStatus.OK);
    }


    @GetMapping("/pagingQuery")
    @Timed
    @ApiOperation(value = "测试分页查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "researchname", value = "人员名称", required = false, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "researchcode", value = "人员编码", required = false, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "projectcode", value = "项目编码", required = false, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "countycode", value = "区县编码", required = false, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "start", value = "起始时间", required = false, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "finish", value = "终止时间", required = false, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "page", value = "当前页数", required = true, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "int", paramType = "query"),
    })
    public ResponseEntity<Object> pagingQuery(String researchname, String researchcode, String projectcode, String countycode, String start, String finish, int page, int pageSize) {
        //System.out.println("asssssssssssssssssddddddddddddddd");
        Tada tada = respondentService.paging(researchname, researchcode, projectcode, countycode, start, finish, page, pageSize);
        return new ResponseEntity<Object>(tada, HttpStatus.OK);
    }
}
