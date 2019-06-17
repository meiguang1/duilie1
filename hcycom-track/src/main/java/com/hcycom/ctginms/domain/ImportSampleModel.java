package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName: ImportSampleModel
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/13 17:16
 **/
@Entity
public class ImportSampleModel {

    @Id
    @Column(name="id")
    @ApiModelProperty(value="id主键")
    private int id;

    @Column(name="person_code")
    @ApiModelProperty(value="调查对象编号")
    private String person_code;

    @Column(name="person_name")
    @ApiModelProperty(value="调查对象姓名")
    private String person_name;

    @Column(name="sample_code")
    @ApiModelProperty(value="样本编号")
    private String sample_code;

    @Column(name="sample_type")
    @ApiModelProperty(value="样本类型")
    private String sample_type;

    @Column(name="capacity")
    @ApiModelProperty(value="容量/ml")
    private String capacity;

    @Column(name="cryopreserved_code")
    @ApiModelProperty(value="冻存盒编号")
    private String cryopreserved_code;

    @Column(name="cryopreserved_line")
    @ApiModelProperty(value="冻存盒内坐标/行")
    private int cryopreserved_line;

    @Column(name="cryopreserved_column")
    @ApiModelProperty(value="冻存盒内坐标/列")
    private int cryopreserved_column;

    @Column(name="subpackage_time")
    @ApiModelProperty(value="分装时间")
    private String subpackage_time;

    @Override
    public String toString() {
        return "ImportSampleModel{" +
            "id=" + id +
            ", person_code='" + person_code + '\'' +
            ", person_name='" + person_name + '\'' +
            ", sample_code='" + sample_code + '\'' +
            ", sample_type='" + sample_type + '\'' +
            ", capacity='" + capacity + '\'' +
            ", cryopreserved_code='" + cryopreserved_code + '\'' +
            ", cryopreserved_line=" + cryopreserved_line +
            ", cryopreserved_column=" + cryopreserved_column +
            ", subpackage_time='" + subpackage_time + '\'' +
            ", offset_number=" + offset_number +
            ", refrigerator_code='" + refrigerator_code + '\'' +
            ", refrigerator_layer=" + refrigerator_layer +
            ", sample_shelf='" + sample_shelf + '\'' +
            ", samplebox_code='" + samplebox_code + '\'' +
            ", box_place='" + box_place + '\'' +
            ", head='" + head + '\'' +
            '}';
    }

    @Column(name="offset_number")
    @ApiModelProperty(value="分管号")
    private int offset_number;

    @Column(name="refrigerator_code")
    @ApiModelProperty(value="冰箱编号")
    private String refrigerator_code;

    @Column(name="refrigerator_layer")
    @ApiModelProperty(value="冰箱层")
    private int refrigerator_layer;

    @Column(name="sample_shelf")
    @ApiModelProperty(value="样本架")
    private String sample_shelf;

    @Column(name="samplebox_code")
    @ApiModelProperty(value="样本盒编号")
    private String samplebox_code;

    @Column(name="box_place")
    @ApiModelProperty(value="盒内位置（行,列）")
    private String box_place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson_code() {
        return person_code;
    }

    public void setPerson_code(String person_code) {
        this.person_code = person_code;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getSample_code() {
        return sample_code;
    }

    public void setSample_code(String sample_code) {
        this.sample_code = sample_code;
    }

    public String getSample_type() {
        return sample_type;
    }

    public void setSample_type(String sample_type) {
        this.sample_type = sample_type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCryopreserved_code() {
        return cryopreserved_code;
    }

    public void setCryopreserved_code(String cryopreserved_code) {
        this.cryopreserved_code = cryopreserved_code;
    }

    public int getCryopreserved_line() {
        return cryopreserved_line;
    }

    public void setCryopreserved_line(int cryopreserved_line) {
        this.cryopreserved_line = cryopreserved_line;
    }

    public int getCryopreserved_column() {
        return cryopreserved_column;
    }

    public void setCryopreserved_column(int cryopreserved_column) {
        this.cryopreserved_column = cryopreserved_column;
    }

    public String getSubpackage_time() {
        return subpackage_time;
    }

    public void setSubpackage_time(String subpackage_time) {
        this.subpackage_time = subpackage_time;
    }

    public int getOffset_number() {
        return offset_number;
    }

    public void setOffset_number(int offset_number) {
        this.offset_number = offset_number;
    }

    public String getRefrigerator_code() {
        return refrigerator_code;
    }

    public void setRefrigerator_code(String refrigerator_code) {
        this.refrigerator_code = refrigerator_code;
    }

    public int getRefrigerator_layer() {
        return refrigerator_layer;
    }

    public void setRefrigerator_layer(int refrigerator_layer) {
        this.refrigerator_layer = refrigerator_layer;
    }

    public String getSample_shelf() {
        return sample_shelf;
    }

    public void setSample_shelf(String sample_shelf) {
        this.sample_shelf = sample_shelf;
    }

    public String getSamplebox_code() {
        return samplebox_code;
    }

    public void setSamplebox_code(String samplebox_code) {
        this.samplebox_code = samplebox_code;
    }

    public String getBox_place() {
        return box_place;
    }

    public void setBox_place(String box_place) {
        this.box_place = box_place;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Column(name="head")

    @ApiModelProperty(value="负责人")
    private String head;
}
