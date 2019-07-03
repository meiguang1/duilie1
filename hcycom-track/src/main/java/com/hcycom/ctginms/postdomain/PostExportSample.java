package com.hcycom.ctginms.postdomain;

import com.hcycom.ctginms.domain.ExportSampleOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: PostExportSample
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/27 10:23
 **/
@ApiModel(value = "出库信息传参",description = "增加出库信息、出库单信息、审核信息")
public class PostExportSample {

    @ApiModelProperty(value="出库单集合",name="state1",required=false)
    private List<ExportSampleOrder> list;

    public String getExport_sample_name() {
        return export_sample_name;
    }

    public void setExport_sample_name(String export_sample_name) {
        this.export_sample_name = export_sample_name;
    }

    @ApiModelProperty(value="出库描述",name="state1",required=false)
    private String notes;

    @ApiModelProperty(value="出库名称",name="export_sample_name",required=false)
    private String export_sample_name;

    public String getPoint_code() {
        return point_code;
    }

    public void setPoint_code(String point_code) {
        this.point_code = point_code;
    }

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

    public String getPoint_name() {
        return point_name;
    }

    public void setPoint_name(String point_name) {
        this.point_name = point_name;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getEventcode() {
        return eventcode;
    }

    public void setEventcode(String eventcode) {
        this.eventcode = eventcode;
    }

    @ApiModelProperty(value="点位编号",name="point_code",required=false)
    private String point_code;

    @ApiModelProperty(value="点位名称",name="point_name",required=false)
    private String point_name;

    @ApiModelProperty(value="用户登录名",name="login_name",required=false)
    private String login_name;

    @ApiModelProperty(value="时间编码",name="eventcode",required=false)
    private String eventcode;


}
