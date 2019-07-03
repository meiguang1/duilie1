package com.hcycom.ctginms.postdomain;

import com.hcycom.ctginms.domain.AuditSample;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: PostAuditSample
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/26 16:34
 **/
@ApiModel(value = "审核实体传参",description = "审核实体传参")
public class PostAuditSample {

    @ApiModelProperty(value="审核状态1",name="state1",required=true)
    private String state;

    @ApiModelProperty(value="审核数据集合1",name="list1",required=true)
    private List<AuditSample> list;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<AuditSample> getList() {
        return list;
    }

    public void setList(List<AuditSample> list) {
        this.list = list;
    }
}
