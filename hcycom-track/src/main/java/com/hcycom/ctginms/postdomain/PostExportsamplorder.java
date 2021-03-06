package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: PostExportsamplorder
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/26 11:36
 **/
@ApiModel(value = "出库单传参实体类",description = "出库单传参实体类")
public class PostExportsamplorder {

    @ApiModelProperty(value="出库单集合",name="list",required=false)
    private List<Map<String,?>> list;

    @ApiModelProperty(value = "出库备注",name = "notes",required = false)
    private String notes;

    public String getAudit_text() {
        return audit_text;
    }

    public void setAudit_text(String audit_text) {
        this.audit_text = audit_text;
    }

    @ApiModelProperty(value = "审核反馈信息",name = "audit_text",required = false)
    private String audit_text;

    public List<Map<String, ?>> getList() {
        return list;
    }

    public void setList(List<Map<String, ?>> list) {
        this.list = list;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
