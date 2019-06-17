package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: PostSample
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/12 17:12
 **/
@ApiModel(value = "样本分页实体传参",description = "样本分页实体传参")
public class PostSample {
    @ApiModelProperty(value="当前页",name="currentPage",example="1",required=true)
    private int currentPage;

    @ApiModelProperty(value="每页条数",name="pageSize",example="10",required=true)
    private int pageSize;

    @ApiModelProperty(value="事件编码",name="eventCode",required=true)
    private String eventCode;

    public int getCurrentPage() {
        return currentPage;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSamplecode() {
        return samplecode;
    }

    public void setSamplecode(String samplecode) {
        this.samplecode = samplecode;
    }

    public String getPersoncode() {
        return personcode;
    }

    public void setPersoncode(String personcode) {
        this.personcode = personcode;
    }

    public String getResearchname() {
        return researchname;
    }

    public void setResearchname(String researchname) {
        this.researchname = researchname;
    }

    public String getCryopreservedcode() {
        return cryopreservedcode;
    }

    public void setCryopreservedcode(String cryopreservedcode) {
        this.cryopreservedcode = cryopreservedcode;
    }


    @ApiModelProperty(value="样本编码",name="samplecode",required=false)

    private String samplecode;

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    @ApiModelProperty(value="调查对象编码",name="personcode",required=false)

    private String personcode;

    @ApiModelProperty(value="调查对象姓名",name="researchname",required=false)
    private String researchname;

    @ApiModelProperty(value="冻存盒编码",name="cryopreservedcode",required=false)
    private String cryopreservedcode;

    @ApiModelProperty(value="开始日期",name="starttime",example="1",required=false)
    private String starttime;

    @ApiModelProperty(value="结束日期",name="endtime",example="",required=false)
    private String endtime;
}
