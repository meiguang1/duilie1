package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: ResearchReport
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/28 12:03
 **/
@Entity
@Table(name = "research_report")
public class ResearchReport {

    @Id
    @Column(name="id")
    @ApiModelProperty(value="id主键")
    private int id;

    @Column(name="research_report_code")
    @ApiModelProperty(value="研究报告编号")
    private String research_report_code;

    @Column(name="person_code")
    @ApiModelProperty(value="调查对象编号")
    private String person_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResearch_report_code() {
        return research_report_code;
    }

    public void setResearch_report_code(String research_report_code) {
        this.research_report_code = research_report_code;
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

    public String getG_csg() {
        return g_csg;
    }

    public void setG_csg(String g_csg) {
        this.g_csg = g_csg;
    }

    public String getGm_csf() {
        return gm_csf;
    }

    public void setGm_csf(String gm_csf) {
        this.gm_csf = gm_csf;
    }

    public String getIfng() {
        return ifng;
    }

    public void setIfng(String ifng) {
        this.ifng = ifng;
    }

    public String getIl_10() {
        return il_10;
    }

    public void setIl_10(String il_10) {
        this.il_10 = il_10;
    }

    public String getScd40l() {
        return scd40l;
    }

    public void setScd40l(String scd40l) {
        this.scd40l = scd40l;
    }

    public String getIl_17() {
        return il_17;
    }

    public void setIl_17(String il_17) {
        this.il_17 = il_17;
    }

    public String getIl_1b() {
        return il_1b;
    }

    public void setIl_1b(String il_1b) {
        this.il_1b = il_1b;
    }

    public String getIl_6() {
        return il_6;
    }

    public void setIl_6(String il_6) {
        this.il_6 = il_6;
    }

    public String getIl_8() {
        return il_8;
    }

    public void setIl_8(String il_8) {
        this.il_8 = il_8;
    }

    public String getIabel_bio() {
        return iabel_bio;
    }

    public void setIabel_bio(String iabel_bio) {
        this.iabel_bio = iabel_bio;
    }

    public String getIabel_edc() {
        return iabel_edc;
    }

    public void setIabel_edc(String iabel_edc) {
        this.iabel_edc = iabel_edc;
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

    @Column(name="person_name")
    @ApiModelProperty(value="调查对象姓名")

    private String person_name;

    @Column(name="sample_code")
    @ApiModelProperty(value="样本编号")
    private String sample_code;

    @Column(name="g_csg")
    @ApiModelProperty(value="G.CSG")
    private String g_csg;

    @Column(name="GM.CSF")
    @ApiModelProperty(value="GM.CSF")
    private String gm_csf;

    @Column(name="ifng")
    @ApiModelProperty(value="IFNG")
    private String ifng;

    @Column(name="il_10")
    @ApiModelProperty(value="IL.10")
    private String il_10;

    @Column(name="scd40l")
    @ApiModelProperty(value="sCD40L")
    private String scd40l;

    @Column(name="il_17")
    @ApiModelProperty(value="IL.17")
    private String il_17;

    @Column(name="il_1b")
    @ApiModelProperty(value="IL.1b")
    private String il_1b;

    @Column(name="il_6")
    @ApiModelProperty(value="IL.6")
    private String il_6;

    @Column(name="il_8")
    @ApiModelProperty(value="IL.8")
    private String il_8;

    @Column(name="iabel_bio")
    @ApiModelProperty(value="label.bio")
    private String iabel_bio;

    @Column(name="iabel_edc")
    @ApiModelProperty(value="label.edc")
    private String iabel_edc;

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
