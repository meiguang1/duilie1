package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName: AuditSample
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/26 15:09
 **/
@Entity
@Table(name = "audit_sample")
public class AuditSample {

    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "自增主键")
    private int id;

    @Column(name = "audit_name")
    @ApiModelProperty(value = "审核名称")
    private String audit_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAudit_name() {
        return audit_name;
    }

    public void setAudit_name(String audit_name) {
        this.audit_name = audit_name;
    }

    public String getAudit_code() {
        return audit_code;
    }

    public void setAudit_code(String audit_code) {
        this.audit_code = audit_code;
    }

    public String getExport_sampleinfo_code() {
        return export_sampleinfo_code;
    }

    public void setExport_sampleinfo_code(String export_sampleinfo_code) {
        this.export_sampleinfo_code = export_sampleinfo_code;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getAudit_state() {
        return audit_state;
    }

    public void setAudit_state(String audit_state) {
        this.audit_state = audit_state;
    }

    @Column(name = "audit_code")
    @ApiModelProperty(value = "审核编码")
    private String audit_code;

    @Column(name = "export_sampleinfo_code")
    @ApiModelProperty(value = "出库信息编号")
    private String export_sampleinfo_code;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date create_time;

    @Column(name = "audit_state")
    @ApiModelProperty(value = "状态（0：未审核:1：通过，-1未通过，2通过删除，-2未通过删除）")
    private String audit_state;

    public String getAudit_text() {
        return audit_text;
    }

    public void setAudit_text(String audit_text) {
        this.audit_text = audit_text;
    }

    @Column(name = "audit_text")
    @ApiModelProperty(value = "审核反馈信息")
    private String audit_text;

}
