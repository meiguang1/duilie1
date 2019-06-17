package com.hcycom.ctginms.postdomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: PostCounty
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/4/17 16:18
 **/
@ApiModel(value = "区县实体传参",description = "区县实体传参")
public class PostCounty {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountycode() {
        return countycode;
    }

    public void setCountycode(String countycode) {
        this.countycode = countycode;
    }

    public String getCountyname() {
        return countyname;
    }

    public void setCountyname(String countyname) {
        this.countyname = countyname;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    @ApiModelProperty(value="ID",name="id",required=true)
    private int id;

    @ApiModelProperty(value="区县编码",name="countycode",required=true)
    private String countycode;

    @ApiModelProperty(value="区县名称",name="countyname",required=true)
    private String countyname;

    @ApiModelProperty(value="项目编码",name="projectcode",required=true)
    private String projectcode;
}
