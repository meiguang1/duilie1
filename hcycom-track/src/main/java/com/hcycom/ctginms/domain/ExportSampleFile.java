package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: ExportSampleFile
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/28 17:42
 **/
@Entity
@Table(name = "export_sample_file")
public class ExportSampleFile {

    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "自增主键")
    private int id;

    @Column(name = "export_samplefile_code")
    @ApiModelProperty(value = "出库文件编码")
    private String export_samplefile_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExport_samplefile_code() {
        return export_samplefile_code;
    }

    public void setExport_samplefile_code(String export_samplefile_code) {
        this.export_samplefile_code = export_samplefile_code;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getExport_sampleinfo_code() {
        return export_sampleinfo_code;
    }

    public void setExport_sampleinfo_code(String export_sampleinfo_code) {
        this.export_sampleinfo_code = export_sampleinfo_code;
    }

    @Column(name = "file_name")

    @ApiModelProperty(value = "文件名称")
    private String file_name;

    @Column(name = "file_path")
    @ApiModelProperty(value = "存放路径")
    private String file_path;

    @Column(name = "export_sampleinfo_code")
    @ApiModelProperty(value = "出库信息编码")
    private String export_sampleinfo_code;
}
