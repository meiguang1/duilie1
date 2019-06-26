package com.hcycom.ctginms.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: ExportSampleOrder
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/26 10:33
 **/
@Entity
@Table(name = "export_sample_order")
public class ExportSampleOrder {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSample_code() {
        return sample_code;
    }

    public void setSample_code(String sample_code) {
        this.sample_code = sample_code;
    }

    public String getInspect_cryopreserved_code() {
        return inspect_cryopreserved_code;
    }

    public void setInspect_cryopreserved_code(String inspect_cryopreserved_code) {
        this.inspect_cryopreserved_code = inspect_cryopreserved_code;
    }

    public String getInspect_box_code() {
        return inspect_box_code;
    }

    public void setInspect_box_code(String inspect_box_code) {
        this.inspect_box_code = inspect_box_code;
    }

    public String getExport_sampleinfo_code() {
        return export_sampleinfo_code;
    }

    public void setExport_sampleinfo_code(String export_sampleinfo_code) {
        this.export_sampleinfo_code = export_sampleinfo_code;
    }

    @Id
    @Column(name="id")
    @ApiModelProperty(value="id主键")

    private int id;

    @Column(name="sample_code")
    @ApiModelProperty(value="样本编号")
    private String sample_code;

    @Column(name="inspect_cryopreserved_code")
    @ApiModelProperty(value="送检.冻存盒编号1")
    private String inspect_cryopreserved_code;

    @Column(name="inspect_box_code")
    @ApiModelProperty(value="送检.盒内编号1")
    private String inspect_box_code;

    @Column(name="export_sampleinfo_code")
    @ApiModelProperty(value="出库信息编号")
    private String export_sampleinfo_code;
}
