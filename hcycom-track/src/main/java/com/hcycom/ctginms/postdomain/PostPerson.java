package com.hcycom.ctginms.postdomain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**     
 * @author: 北京华晨阳通信技术有限责任公司
 * @date: 2019年3月25日 下午2:49:53   
 * @name: 李硕
 * @Description: 
 */
@ApiModel(value = "修改或者增加post方法实体传参",description = "修改或者增加post方法实体传参")
public class PostPerson {

	@ApiModelProperty(value="ID",name="id",required=true)
	private int id;
	
	@ApiModelProperty(value="调查中心编码",name="researchcode",required=true)
	private String researchcode;
	
	@ApiModelProperty(value="调查人员姓名",name="researchname",required=true)
	private String researchname;
	
	@ApiModelProperty(value="点位",name="position",required=true)
	private String position;
	
	@ApiModelProperty(value="项目编码",name="projectcode",required=true)
    private String projectcode;

    @ApiModelProperty(value="性别",name="sex",required=true)
    private String sex;
	

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

    //这是后添加上去的,如果出错记得删除

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PostPerson{" +
            "id=" + id +
            ", researchcode='" + researchcode + '\'' +
            ", researchname='" + researchname + '\'' +
            ", position='" + position + '\'' +
            ", projectcode='" + projectcode + '\'' +
            ", sex='" + sex + '\'' +
            '}';
    }
}
