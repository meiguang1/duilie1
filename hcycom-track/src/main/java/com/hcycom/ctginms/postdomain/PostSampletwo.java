package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;

/**
 * @ClassName: PostSample
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/12 17:12
 **/
@ApiModel(value = "虚拟库数据正式入库传参",description = "虚拟库数据正式入库传参")
public class PostSampletwo {

    public String getSamplecode() {
        return samplecode;
    }

    public void setSamplecode(String samplecode) {
        this.samplecode = samplecode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @ApiModelProperty(value="样本编号",name="samplecode",required=true)
    private String samplecode;

    @ApiModelProperty(value="调查对象编号",name="personcode",required=true)
    private String personcode;

    @ApiModelProperty(value="样本类型",name="type",required=true)
    private String type;

    @ApiModelProperty(value="容量/ml",name="capacity",required=true)
    private String capacity;

    @ApiModelProperty(value="冻存盒编号",name="cryopreservedcode",required=true)
    private String cryopreservedcode;

    @ApiModelProperty(value="冻存盒内坐标/行",name="cryopreservedline",required=true)
    private int cryopreservedline;

    @ApiModelProperty(value="冻存盒内坐标/列",name="cryopreservedcolumn",required=true)
    private int cryopreservedcolumn;

    @ApiModelProperty(value="分装时间",name="subpackagetime",required=true)
    private String subpackagetime;

    @ApiModelProperty(value="分管号",name="offsetnumber",required=true)
    private int offsetnumber;

    @ApiModelProperty(value="冰箱编号",name="refrigeratorcode",required=true)
    private String refrigeratorcode;

    @ApiModelProperty(value="冰箱层",name="refrigeratorlayer",required=true)
    private int refrigeratorlayer;

    @ApiModelProperty(value="样本架",name="sampleshelf",required=true)
    private String sampleshelf;

    @ApiModelProperty(value="样本盒编号",name="sampleboxcode",required=true)
    private String sampleboxcode;

    @ApiModelProperty(value="盒内位置（行,列）",name="boxplace",required=true)
    private String boxplace;

    @ApiModelProperty(value="样品状态",name="state",example="1",required=true)
    private String state;

    @ApiModelProperty(value="样品负责人",name="head",required=true)
    private String head;

    @ApiModelProperty(value="创建时间",name="createtime",required=false)
    private String createtime;

    @ApiModelProperty(value="事件编号",name="eventcode",required=true)
    private String eventcode;

    @ApiModelProperty(value="入库信息编码",name="sample_info_code",required=true)
    private String sample_info_code;

    public String getCapacity() {
        return capacity;
    }

    public String getSample_info_code() {
        return sample_info_code;
    }

    public void setSample_info_code(String sample_info_code) {
        this.sample_info_code = sample_info_code;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;

    }

    public String getCryopreservedcode() {
        return cryopreservedcode;
    }

    public void setCryopreservedcode(String cryopreservedcode) {
        this.cryopreservedcode = cryopreservedcode;
    }

    public int getCryopreservedline() {
        return cryopreservedline;
    }

    public void setCryopreservedline(int cryopreservedline) {
        this.cryopreservedline = cryopreservedline;
    }

    public int getCryopreservedcolumn() {
        return cryopreservedcolumn;
    }

    public void setCryopreservedcolumn(int cryopreservedcolumn) {
        this.cryopreservedcolumn = cryopreservedcolumn;
    }

    public String getSubpackagetime() {
        return subpackagetime;
    }

    public void setSubpackagetime(String subpackagetime) {
        this.subpackagetime = subpackagetime;
    }

    public int getOffsetnumber() {
        return offsetnumber;
    }

    public void setOffsetnumber(int offsetnumber) {
        this.offsetnumber = offsetnumber;
    }

    public String getRefrigeratorcode() {
        return refrigeratorcode;
    }

    public void setRefrigeratorcode(String refrigeratorcode) {
        this.refrigeratorcode = refrigeratorcode;
    }

    public int getRefrigeratorlayer() {
        return refrigeratorlayer;
    }

    public void setRefrigeratorlayer(int refrigeratorlayer) {
        this.refrigeratorlayer = refrigeratorlayer;
    }

    public String getSampleshelf() {
        return sampleshelf;
    }

    public void setSampleshelf(String sampleshelf) {
        this.sampleshelf = sampleshelf;
    }

    public String getSampleboxcode() {
        return sampleboxcode;
    }

    public void setSampleboxcode(String sampleboxcode) {
        this.sampleboxcode = sampleboxcode;
    }

    public String getBoxplace() {
        return boxplace;
    }

    public void setBoxplace(String boxplace) {
        this.boxplace = boxplace;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getPersoncode() {
        return personcode;
    }

    public void setPersoncode(String personcode) {
        this.personcode = personcode;
    }

    public String getEventcode() {
        return eventcode;
    }

    public void setEventcode(String eventcode) {
        this.eventcode = eventcode;
    }
}
