package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName: ProcedureOfSingle
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/28 15:57
 **/
@Entity
@Table(name = "procedure_of_single")
public class ProcedureOfSingle {

    @Id
    @Column(name = "id")
    @ApiModelProperty(value="id主键")
    private int id;

    @Column(name = "code")
    @ApiModelProperty(value="手续单编号")
    private String code;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public String getExport_sampleinfo_code() {
        return export_sampleinfo_code;
    }

    public void setExport_sampleinfo_code(String export_sampleinfo_code) {
        this.export_sampleinfo_code = export_sampleinfo_code;
    }

    @Column(name = "name")
    @ApiModelProperty(value="手续单名称")
    private String name;

    public String getExport_samplefile_code() {
        return export_samplefile_code;
    }

    public void setExport_samplefile_code(String export_samplefile_code) {
        this.export_samplefile_code = export_samplefile_code;
    }

    @Column(name = "upload_time")
    @ApiModelProperty(value="上传手续单时间")
    private Date upload_time;

    @Column(name = "export_sampleinfo_code")
    @ApiModelProperty(value="出库信息编号")
    private String export_sampleinfo_code;

    @Column(name = "export_samplefile_code")
    @ApiModelProperty(value="上传的出库单文件编码")
    private String export_samplefile_code;
}
