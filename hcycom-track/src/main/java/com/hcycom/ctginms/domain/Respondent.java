package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Respondent")
public class Respondent {


    @Id
    @Column(name="id")
    @ApiModelProperty(value="id主键")
    private int id;

    @Column(name="researchcode")
    @ApiModelProperty(value="人员编码")
    private String researchcode;

    @Column(name="researchname")
    @ApiModelProperty(value="人员名称")
    private String researchname;

    @Column(name="projectcode")
    @ApiModelProperty(value="项目编码")
    private String projectcode;

    @Column(name="eventcode")
    @ApiModelProperty(value="事件编码")
    private String eventcode;

    @Column(name="countycode")
    @ApiModelProperty(value="区县编码")
    private String countycode;

    @Column(name="sex")
    @ApiModelProperty(value="性别")
    private String sex;

    @Column(name="date_of_birth")
    @ApiModelProperty(value="出生日期")
    private String date_of_birth;

    @Column(name="into_group")
    @ApiModelProperty(value="入组日期")
    private String into_group;

    @Column(name="id_number")
    @ApiModelProperty(value="身份证号")
    private String id_number;

    @Column(name="contact_way")
    @ApiModelProperty(value="联系方式")
    private String contact_way;

    @Column(name="signature_date")
    @ApiModelProperty(value="签名日期")
    private String signature_date;

    @Column(name="detailed_address")
    @ApiModelProperty(value="详细地址")
    private String detailed_address;

    @Column(name="postal_code")
    @ApiModelProperty(value="邮政编码")
    private String postal_code;

    @Column(name="email_address")
    @ApiModelProperty(value="电子邮箱")
    private String email_address;

    @Column(name="sample_size")
    @ApiModelProperty(value="样本数量")
    private int sample_size;

    @Column(name="sample_type")
    @ApiModelProperty(value="样本类型")
    private String sample_type;

    @Column(name="quantity_in_stock")
    @ApiModelProperty(value="库存数量")
    private int quantity_in_stock;

    @Column(name="inventory_type")
    @ApiModelProperty(value="库存类型")
    private String inventory_type;

    @Column(name="the_delivery")
    @ApiModelProperty(value="已出库数量")
    private int the_delivery;

    @Column(name="outbound_type")
    @ApiModelProperty(value="出库类型")
    private String outbound_type;

    @Column(name="lock_the_number")
    @ApiModelProperty(value="锁定数量")
    private int lock_the_number;

    @Column(name="the_lock_type")
    @ApiModelProperty(value="锁定类型")
    private String the_lock_type;

    @Column(name="questionnaire")
    @ApiModelProperty(value="调查问卷")
    private String questionnaire;

    @Column(name="medical_examination_report")
    @ApiModelProperty(value="体检报告")
    private String medical_examination_report;

    @Column(name="a_medical_file")
    @ApiModelProperty(value="体检文件")
    private String a_medical_file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResearchcode() {
        return researchcode;
    }

    public void setResearchcode(String researchcode) {
        this.researchcode = researchcode;
    }

    public String getResearchname() {
        return researchname;
    }

    public void setResearchname(String researchname) {
        this.researchname = researchname;
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

    public String getCountycode() {
        return countycode;
    }

    public void setCountycode(String countycode) {
        this.countycode = countycode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getInto_group() {
        return into_group;
    }

    public void setInto_group(String into_group) {
        this.into_group = into_group;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getContact_way() {
        return contact_way;
    }

    public void setContact_way(String contact_way) {
        this.contact_way = contact_way;
    }

    public String getSignature_date() {
        return signature_date;
    }

    public void setSignature_date(String signature_date) {
        this.signature_date = signature_date;
    }

    public String getDetailed_address() {
        return detailed_address;
    }

    public void setDetailed_address(String detailed_address) {
        this.detailed_address = detailed_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public int getSample_size() {
        return sample_size;
    }

    public void setSample_size(int sample_size) {
        this.sample_size = sample_size;
    }

    public String getSample_type() {
        return sample_type;
    }

    public void setSample_type(String sample_type) {
        this.sample_type = sample_type;
    }

    public int getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(int quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    public String getInventory_type() {
        return inventory_type;
    }

    public void setInventory_type(String inventory_type) {
        this.inventory_type = inventory_type;
    }

    public int getThe_delivery() {
        return the_delivery;
    }

    public void setThe_delivery(int the_delivery) {
        this.the_delivery = the_delivery;
    }

    public String getOutbound_type() {
        return outbound_type;
    }

    public void setOutbound_type(String outbound_type) {
        this.outbound_type = outbound_type;
    }

    public int getLock_the_number() {
        return lock_the_number;
    }

    public void setLock_the_number(int lock_the_number) {
        this.lock_the_number = lock_the_number;
    }

    public String getThe_lock_type() {
        return the_lock_type;
    }

    public void setThe_lock_type(String the_lock_type) {
        this.the_lock_type = the_lock_type;
    }

    public String getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(String questionnaire) {
        this.questionnaire = questionnaire;
    }

    public String getMedical_examination_report() {
        return medical_examination_report;
    }

    public void setMedical_examination_report(String medical_examination_report) {
        this.medical_examination_report = medical_examination_report;
    }

    public String getA_medical_file() {
        return a_medical_file;
    }

    public void setA_medical_file(String a_medical_file) {
        this.a_medical_file = a_medical_file;
    }

    @Override
    public String toString() {
        return "Respondent{" +
            "id=" + id +
            ", researchcode='" + researchcode + '\'' +
            ", researchname='" + researchname + '\'' +
            ", projectcode='" + projectcode + '\'' +
            ", eventcode='" + eventcode + '\'' +
            ", countycode='" + countycode + '\'' +
            ", sex='" + sex + '\'' +
            ", date_of_birth='" + date_of_birth + '\'' +
            ", into_group='" + into_group + '\'' +
            ", id_number='" + id_number + '\'' +
            ", contact_way='" + contact_way + '\'' +
            ", signature_date='" + signature_date + '\'' +
            ", detailed_address='" + detailed_address + '\'' +
            ", postal_code='" + postal_code + '\'' +
            ", email_address='" + email_address + '\'' +
            ", sample_size=" + sample_size +
            ", sample_type='" + sample_type + '\'' +
            ", quantity_in_stock=" + quantity_in_stock +
            ", inventory_type='" + inventory_type + '\'' +
            ", the_delivery=" + the_delivery +
            ", outbound_type='" + outbound_type + '\'' +
            ", lock_the_number=" + lock_the_number +
            ", the_lock_type='" + the_lock_type + '\'' +
            ", questionnaire='" + questionnaire + '\'' +
            ", medical_examination_report='" + medical_examination_report + '\'' +
            ", a_medical_file='" + a_medical_file + '\'' +
            '}';
    }
}
