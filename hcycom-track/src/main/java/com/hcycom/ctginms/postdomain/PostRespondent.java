package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;
import javax.persistence.Column;

public class PostRespondent {
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

    @Column(name="countyname")
    @ApiModelProperty(value="区县编码")
    private String countyname;

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

    @Column(name="select")
    @ApiModelProperty(value="详情")
    private Object select;

    @Column(name="likeSelect")
    @ApiModelProperty(value="总条数")
    private int likeSelect;
}
