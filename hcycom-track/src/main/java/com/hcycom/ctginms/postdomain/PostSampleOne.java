package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: PostSampleOne
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/24 18:34
 **/
@ApiModel(value = "确认入库实体类",description = "确认入库实体类")
public class PostSampleOne {

    @ApiModelProperty(value="入库数据集合",name="sampleList",required=false)
    private List<PostSampletwo> sampleList;

    @ApiModelProperty(value="当前时间",name="nowtime",required=false)
    private String nowtime;

    @ApiModelProperty(value="登录用户名",name="loginname",required=false)
    private String loginname;

    @ApiModelProperty(value="项目编码(项目编码和事件编码至少有一个)",name="projectcode",required=false)
    private String projectcode;

    @ApiModelProperty(value="事件编码(项目编码和事件编码至少有一个)",name="eventcode",required=false)
    private String eventcode;

    @ApiModelProperty(value="备注信息",name="notes",required=false)
    private String notes;

    public String getNowtime() {
        return nowtime;
    }

    public void setNowtime(String nowtime) {
        this.nowtime = nowtime;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public List<PostSampletwo> getSampleList() {
        return sampleList;
    }

    public void setSampleList(List<PostSampletwo> sampleList) {
        this.sampleList = sampleList;
    }

    public String getProjectcode() {
        return projectcode;

    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    public String getEventcode() {
        return eventcode;
    }

    public void setEventcode(String eventcode) {
        this.eventcode = eventcode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
