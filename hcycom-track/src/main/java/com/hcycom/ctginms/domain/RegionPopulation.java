package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 上午11:29:42   
 * @name 李硕
 * @Description: 区域人口数实体类
 */

@Entity
@Table(name = "region_population")
public class RegionPopulation {
	/*
  `pop_id` int(11) NOT NULL,
  `province` varchar(255) default NULL,省份
  `city` varchar(255) default NULL,城市
  `area` varchar(255) default NULL,区县
  `pop_name` varchar(255) default NULL,人口数名称
  `pop_number` int(11) default NULL,人口数
  `pop_source` varchar(255) default NULL,
  `if_dispaly` int(11) default NULL,
  `pop_date` varchar(255) default NULL,
  `pop_author` varchar(255) default NULL,
	 * */
	
	@Id
	@Column(name = "pop_id")
	@ApiModelProperty(value="区域人口ID")
	private int popid;
	
	@Column(name = "province")
	@ApiModelProperty(value="省份")
	private String province;
	
	@Column(name = "city")
	@ApiModelProperty(value="城市")
	private String city;
	
	@Column(name = "area")
	@ApiModelProperty(value="区县")
	private String area;
	
	@Column(name = "pop_name")
	@ApiModelProperty(value="人口数名称")
	private String popname;
	
	@Column(name = "pop_number")
	@ApiModelProperty(value="人口数")
	private int popnumber;
	
	@Column(name = "pop_source")
	@ApiModelProperty(value="")
	private String popsource;
	
	@Column(name = "if_dispaly")
	@ApiModelProperty(value="")
	private int ifdispaly;
	
	@Column(name = "pop_date")
	@ApiModelProperty(value="")
	private String popdate;
	
	@Column(name = "pop_author")
	@ApiModelProperty(value="")
	private String popauthor;
	
	
	public int getPopid() {
		return popid;
	}
	public void setPopid(int popid) {
		this.popid = popid;
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
	public String getPopname() {
		return popname;
	}
	public void setPopname(String popname) {
		this.popname = popname;
	}
	public int getPopnumber() {
		return popnumber;
	}
	public void setPopnumber(int popnumber) {
		this.popnumber = popnumber;
	}
	public String getPopsource() {
		return popsource;
	}
	public void setPopsource(String popsource) {
		this.popsource = popsource;
	}
	
	public int getIfdispaly() {
		return ifdispaly;
	}
	public void setIfdispaly(int ifdispaly) {
		this.ifdispaly = ifdispaly;
	}
	public String getPopdate() {
		return popdate;
	}
	public void setPopdate(String popdate) {
		this.popdate = popdate;
	}
	public String getPopauthor() {
		return popauthor;
	}
	public void setPopauthor(String popauthor) {
		this.popauthor = popauthor;
	}
	
	
	
	
	
	
	
	

}















