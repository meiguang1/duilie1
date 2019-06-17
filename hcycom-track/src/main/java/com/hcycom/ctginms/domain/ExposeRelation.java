package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午3:16:35   
 * @name 李硕
 * @Description: 暴反关系表实体类
 */
@Entity
@Table(name = "expose_relation")
public class ExposeRelation {

	/*
	 * 
  `expose_id` int(11) NOT NULL,
  `province` varchar(255) default NULL,省份
  `city` varchar(255) default NULL,城市
  `area` varchar(255) default NULL,区县
  `expose_sort_id` int(11) default NULL,外键，分类ID
  `expose_name` varchar(255) default NULL,暴反关系名称
  `expose_ratio` varchar(255) default NULL,暴反关系系数  
  `upper_limit` varchar(255) default NULL,暴反关系上限
  `low_limit` varchar(255) default NULL,暴反关系下限 
  `expose_source` varchar(255) default NULL,
  `if_dispaly` int(11) default NULL,
  `author_time` varchar(255) default NULL,
  `disease` varchar(255) default NULL,
  `expose_type_r` varchar(255) default NULL,
  `lagging` varchar(255) default NULL,
  `reference` varchar(255) default NULL,
  `age` varchar(255) default NULL,
  `gender` varchar(255) default NULL,
  `expose_author` varchar(255) default NULL,
	 * */
	@Id
	@Column(name = "expose_id")
	@ApiModelProperty(value="暴反关系ID")
	private int exposeid;
	
	@Column(name = "province")
	@ApiModelProperty(value="省份")
	private String province;
	
	@Column(name = "city")
	@ApiModelProperty(value="城市")
	private String city;
	
	@Column(name = "area")
	@ApiModelProperty(value="区县")
	private String area;
	
	@Column(name = "expose_sort_id")
	@ApiModelProperty(value="外键，分类ID")
	private int exposesortid;
	
	@Column(name = "expose_name")
	@ApiModelProperty(value="暴反关系名称")
	private String exposename;
	
	@Column(name = "expose_ratio")
	@ApiModelProperty(value="暴反关系系数 ")
	private String exposeratio;
	
	@Column(name = "upper_limit")
	@ApiModelProperty(value="暴反关系上限")
	private String upperlimit;
	
	@Column(name = "low_limit")
	@ApiModelProperty(value="暴反关系下限")
	private String lowlimit;
	
	@Column(name = "expose_source")
	@ApiModelProperty(value="")
	private String exposesource;
	
	@Column(name = "if_dispaly")
	@ApiModelProperty(value="")
	private int ifdispaly;
	
	@Column(name = "author_time")
	@ApiModelProperty(value="")
	private String authortime;
	
	@Column(name = "disease")
	@ApiModelProperty(value="")
	private String disease;
	
	@Column(name = "expose_type_r")
	@ApiModelProperty(value="")
	private String exposetyper;
	
	@Column(name = "lagging")
	@ApiModelProperty(value="")
	private String lagging;
	
	@Column(name = "reference")
	@ApiModelProperty(value="")
	private String reference;
	
	@Column(name = "age")
	@ApiModelProperty(value="")
	private String age;
	
	@Column(name = "gender")
	@ApiModelProperty(value="")
	private String gender;
	
	@Column(name = "expose_author")
	@ApiModelProperty(value="")
	private String exposeauthor;
	
	public int getExposeid() {
		return exposeid;
	}
	public void setExposeid(int exposeid) {
		this.exposeid = exposeid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getExposesortid() {
		return exposesortid;
	}
	public void setExposesortid(int exposesortid) {
		this.exposesortid = exposesortid;
	}
	public String getExposename() {
		return exposename;
	}
	public void setExposename(String exposename) {
		this.exposename = exposename;
	}
	public String getExposeratio() {
		return exposeratio;
	}
	public void setExposeratio(String exposeratio) {
		this.exposeratio = exposeratio;
	}
	public String getUpperlimit() {
		return upperlimit;
	}
	public void setUpperlimit(String upperlimit) {
		this.upperlimit = upperlimit;
	}
	public String getLowlimit() {
		return lowlimit;
	}
	public void setLowlimit(String lowlimit) {
		this.lowlimit = lowlimit;
	}
	public String getExposesource() {
		return exposesource;
	}
	public void setExposesource(String exposesource) {
		this.exposesource = exposesource;
	}
	public int getIfdispaly() {
		return ifdispaly;
	}
	public void setIfdispaly(int ifdispaly) {
		this.ifdispaly = ifdispaly;
	}
	public String getAuthortime() {
		return authortime;
	}
	public void setAuthortime(String authortime) {
		this.authortime = authortime;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getExposetyper() {
		return exposetyper;
	}
	public void setExposetyper(String exposetyper) {
		this.exposetyper = exposetyper;
	}
	public String getLagging() {
		return lagging;
	}
	public void setLagging(String lagging) {
		this.lagging = lagging;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getExposeauthor() {
		return exposeauthor;
	}
	public void setExposeauthor(String exposeauthor) {
		this.exposeauthor = exposeauthor;
	}
	
	
}
