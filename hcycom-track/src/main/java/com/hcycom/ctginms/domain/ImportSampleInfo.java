package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName: ImportSampleInfo
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/18 15:28
 **/
@Entity
@Table(name = "import_sample_info")
public class ImportSampleInfo {

    @Id
    @Column(name="id")
    @ApiModelProperty(value="id主键")
    private int id;

    public String getExport_sampleinfo_code() {
        return export_sampleinfo_code;
    }

    public void setExport_sampleinfo_code(String export_sampleinfo_code) {
        this.export_sampleinfo_code = export_sampleinfo_code;
    }

    @Column(name = "export_sampleinfo_code")
    @ApiModelProperty(value = "出库信息编号")

    private String export_sampleinfo_code;

    @Column(name="entrepot_name")
    @ApiModelProperty(value="入库名称")
    private String entrepot_name;

    public String getPoint_name() {
        return point_name;
    }

    public void setPoint_name(String point_name) {
        this.point_name = point_name;
    }

    @Column(name="point_code")
    @ApiModelProperty(value="点位编码")
    private String point_code;

    @Column(name="point_name")
    @ApiModelProperty(value="点位名称（为外表关联字段）")
    private String point_name;

    @Column(name="import_name")
    @ApiModelProperty(value="上传文件名")
    private String import_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoint_code() {
        return point_code;
    }

    public void setPoint_code(String point_code) {
        this.point_code = point_code;
    }

    public String getEntrepot_name() {
        return entrepot_name;
    }

    public void setEntrepot_name(String entrepot_name) {
        this.entrepot_name = entrepot_name;
    }

    public String getImport_name() {
        return import_name;
    }

    public void setImport_name(String import_name) {
        this.import_name = import_name;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public Date getImport_time() {
        return import_time;
    }

    public void setImport_time(Date import_time) {
        this.import_time = import_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name="operator_name")

    @ApiModelProperty(value="入库操作员")
    private String operator_name;

    @Column(name="import_time")
    @ApiModelProperty(value="上传时间")
    private Date import_time;

    public String getEvent_code() {

        return event_code;
    }

    public String getSample_info_code() {
        return sample_info_code;
    }

    public void setSample_info_code(String sample_info_code) {
        this.sample_info_code = sample_info_code;
    }

    public void setEvent_code(String event_code) {
        this.event_code = event_code;

    }

    @Override
    public String toString() {
        return "ImportSampleInfo{" +
            "id=" + id +
            ", export_sampleinfo_code='" + export_sampleinfo_code + '\'' +
            ", entrepot_name='" + entrepot_name + '\'' +
            ", point_code='" + point_code + '\'' +
            ", import_name='" + import_name + '\'' +
            ", operator_name='" + operator_name + '\'' +
            ", import_time=" + import_time +
            ", state='" + state + '\'' +
            ", event_code='" + event_code + '\'' +
            ", sample_info_code='" + sample_info_code + '\'' +
            '}';
    }

    @Column(name="state")
    @ApiModelProperty(value="入库状态")
    private String state;

    @Column(name="event_code")
    @ApiModelProperty(value="事件编码")
    private String event_code;

    @Column(name="sample_info_code")
    @ApiModelProperty(value="入库信息编码")
    private String sample_info_code;


}
