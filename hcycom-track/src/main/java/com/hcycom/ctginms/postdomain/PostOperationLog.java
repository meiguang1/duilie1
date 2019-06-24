package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @ClassName: PostOperationLog
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/21 15:01
 **/
@ApiModel(value = "获取当前进行的任务基本信息(项目编码和事件编码至少有一个)",description = "获取当前进行的任务基本信息")
public class PostOperationLog {

    @ApiModelProperty(value="当前时间",name="nowtime",required=false)
    private String nowtime;

    public String getNowtime() {
        return nowtime;
    }

    public void setNowtime(String nowtime) {
        this.nowtime = nowtime;
    }

    public String getProjrctcode() {
        return projrctcode;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setProjrctcode(String projrctcode) {
        this.projrctcode = projrctcode;
    }

    public String getEventcode() {
        return eventcode;
    }

    public void setEventcode(String eventcode) {
        this.eventcode = eventcode;
    }

    @ApiModelProperty(value="登录用户名",name="loginname",required=false)
    private String loginname;

    @ApiModelProperty(value="项目编码(项目编码和事件编码至少有一个)",name="projrctcode",required=false)
    private String projrctcode;

    @ApiModelProperty(value="事件编码(项目编码和事件编码至少有一个)",name="eventcode",required=false)
    private String eventcode;
}
