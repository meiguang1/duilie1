package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: Sample
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/11 16:28
 **/
@Entity
@Table(name = "Sample")
public class Sample {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
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

    @Id
    @Column(name="id")
    @ApiModelProperty(value="id主键")
    private int id;

    @Column(name="code")
    @ApiModelProperty(value="样本编号")
    private String code;

    @Column(name="type")
    @ApiModelProperty(value="样本类型")
    private String type;

    @Column(name="capacity")
    @ApiModelProperty(value="容量/ml")
    private String capacity;

    @Column(name="cryopreserved_code")
    @ApiModelProperty(value="冻存盒编号")
    private String cryopreservedcode;

    @Column(name="cryopreserved_line")
    @ApiModelProperty(value="冻存盒内坐标/行")
    private int cryopreservedline;

    @Column(name="cryopreserved_column")
    @ApiModelProperty(value="冻存盒内坐标/列")
    private int cryopreservedcolumn;

    @Column(name="subpackage_time")
    @ApiModelProperty(value="分装时间")
    private String subpackagetime;

    @Column(name="offset_number")
    @ApiModelProperty(value="分管号")
    private int offsetnumber;

    @Column(name="refrigerator_code")
    @ApiModelProperty(value="冰箱编号")
    private String refrigeratorcode;

    @Column(name="refrigerator_layer")
    @ApiModelProperty(value="冰箱层")
    private int refrigeratorlayer;

    @Column(name="sample_shelf")
    @ApiModelProperty(value="样本架")
    private String sampleshelf;

    @Column(name="samplebox_code")
    @ApiModelProperty(value="样本盒编号")
    private String sampleboxcode;

    @Column(name="box_place")
    @ApiModelProperty(value="盒内位置（行,列")
    private String boxplace;

    @Column(name="state")
    @ApiModelProperty(value="样品状态")
    private String state;

    @Column(name="head")
    @ApiModelProperty(value="样品负责人")
    private String head;

    @Column(name="create_time")
    @ApiModelProperty(value="创建时间")
    private String createtime;

    @Column(name="person_code")
    @ApiModelProperty(value="调查对象编号")
    private String personcode;

    @Column(name="event_code")
    @ApiModelProperty(value="时间编号")
    private String eventcode;
}
