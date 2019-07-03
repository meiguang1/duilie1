package com.hcycom.ctginms.postdomain;

import com.hcycom.ctginms.domain.ExportSampleOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: PostExportSampleTwo
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/28 9:45
 **/
@ApiModel(value = "重新出库信息传参",description = "修改出库信息、出库单信息、审核信息")
public class PostExportSampleTwo {

    @ApiModelProperty(value="出库单集合",name="state1",required=false)
    private List<ExportSampleOrder> list;

    @ApiModelProperty(value="出库描述",name="state1",required=false)
    private String notes;

    public List<ExportSampleOrder> getList() {
        return list;
    }

    public void setList(List<ExportSampleOrder> list) {
        this.list = list;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEventcode() {
        return eventcode;
    }

    public void setEventcode(String eventcode) {
        this.eventcode = eventcode;
    }

    public String getExport_sampleinfo_code() {
        return export_sampleinfo_code;
    }

    public void setExport_sampleinfo_code(String export_sampleinfo_code) {
        this.export_sampleinfo_code = export_sampleinfo_code;
    }

    @ApiModelProperty(value="时间编码",name="state1",required=false)
    private String eventcode;

    @ApiModelProperty(value="出库信息编码",name="export_sampleinfo_code",required=true)
    private String export_sampleinfo_code;
}
