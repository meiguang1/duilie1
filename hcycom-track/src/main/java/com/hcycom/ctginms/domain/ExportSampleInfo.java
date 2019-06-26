package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName: ExportSampleInfo
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/25 15:44
 **/
@Entity
@Table(name = "export_sample_info")
public class ExportSampleInfo {

    @Id
    @Column(name="id")
    @ApiModelProperty(value="id主键")
    private int id;

    @Column(name="export_sample_name")
    @ApiModelProperty(value="出库名称")
    private String export_sample_name;

    @Column(name="point_name")
    @ApiModelProperty(value="点位名称")
    private String point_name;

    @Column(name="notes")
    @ApiModelProperty(value="出库备注")
    private String notes;

    @Column(name="operator_name")
    @ApiModelProperty(value="出库操作员")
    private String operator_name;

    @Column(name="operator_time")
    @ApiModelProperty(value="出库时间")
    private Date operator_time;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ExportSampleInfo{" +
            "id=" + id +
            ", export_sample_name='" + export_sample_name + '\'' +
            ", point_name='" + point_name + '\'' +
            ", notes='" + notes + '\'' +
            ", operator_name='" + operator_name + '\'' +
            ", operator_time=" + operator_time +
            ", export_sample_state='" + export_sample_state + '\'' +
            ", detection_report_state='" + detection_report_state + '\'' +
            ", audit_state='" + audit_state + '\'' +
            ", export_file_state='" + export_file_state + '\'' +
            ", event_code='" + event_code + '\'' +
            '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExport_sample_name() {
        return export_sample_name;
    }

    public void setExport_sample_name(String export_sample_name) {
        this.export_sample_name = export_sample_name;
    }

    public String getPoint_name() {
        return point_name;
    }

    public void setPoint_name(String point_name) {
        this.point_name = point_name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public Date getOperator_time() {
        return operator_time;
    }

    public void setOperator_time(Date operator_time) {
        this.operator_time = operator_time;
    }

    public String getExport_sample_state() {
        return export_sample_state;
    }

    public void setExport_sample_state(String export_sample_state) {
        this.export_sample_state = export_sample_state;
    }

    public String getDetection_report_state() {
        return detection_report_state;
    }

    public void setDetection_report_state(String detection_report_state) {
        this.detection_report_state = detection_report_state;
    }

    public String getAudit_state() {
        return audit_state;
    }

    public void setAudit_state(String audit_state) {
        this.audit_state = audit_state;
    }

    public String getExport_file_state() {
        return export_file_state;
    }

    public void setExport_file_state(String export_file_state) {
        this.export_file_state = export_file_state;
    }

    public String getEvent_code() {
        return event_code;
    }

    public void setEvent_code(String event_code) {
        this.event_code = event_code;
    }

    @Column(name="export_sample_state")
    @ApiModelProperty(value="出库状态（0：未出库1：已出库）")
    private String export_sample_state;

    @Column(name="detection_report_state")
    @ApiModelProperty(value="监测报告状态（0：禁止上传1：允许上传2：成功上传）")
    private String detection_report_state;

    @Column(name="audit_state")
    @ApiModelProperty(value="审核状态（0：待审核 1：未通过 2：已通过）")
    private String audit_state;

    @Column(name="export_file_state")
    @ApiModelProperty(value="相关文件状态（0：无文件，n>0：代表有n个文件）")
    private String export_file_state;

    @Column(name="event_code")
    @ApiModelProperty(value="时间编码")
    private String event_code;
}
