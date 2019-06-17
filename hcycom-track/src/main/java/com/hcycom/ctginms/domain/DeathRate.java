package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午2:35:28   
 * @name 李硕
 * @Description: 死亡率实体类
 */
@Entity
@Table(name = "death_rate")
public class DeathRate {

	/*
  `death_id` int(11) NOT NULL,
  `province` varchar(255) default NULL,省份
  `city` varchar(255) default NULL,城市
  `area` varchar(255) default NULL,区县
  `deathrate_name` varchar(255) default NULL,年死亡率数名称
  `deathrate_value` varchar(255) default NULL,年死亡率
  `deathrate_source` varchar(255) default NULL,
  `if_dispaly` int(11) default NULL,
  `deathrate_date` varchar(255) default NULL,
  `deathrate_author` varchar(255) default NULL,
	 * */
	@Id
	@Column(name = "death_id")
	@ApiModelProperty(value="死亡率ID")
	private int deathid;
	
	@Column(name = "province")
	@ApiModelProperty(value="省份")
	private String province;
	
	@Column(name = "city")
	@ApiModelProperty(value="城市")
	private String city;
	
	@Column(name = "area")
	@ApiModelProperty(value="区县")
	private String area;
	
	@Column(name = "deathrate_name")
	@ApiModelProperty(value="年死亡率数名称")
	private String deathratename;
	
	@Column(name = "deathrate_value")
	@ApiModelProperty(value="年死亡率")
	private String deathratevalue;
	
	@Column(name = "deathrate_source")
	@ApiModelProperty(value="")
	private String deathratesource;
	
	@Column(name = "if_dispaly")
	@ApiModelProperty(value="")
	private int ifdispaly;
	
	@Column(name = "deathrate_date")
	@ApiModelProperty(value="")
	private String deathratedate;
	
	@Column(name = "deathrate_author")
	@ApiModelProperty(value="")
	private String deathrateauthor;
	
	
	public int getDeathid() {
		return deathid;
	}
	public void setDeathid(int deathid) {
		this.deathid = deathid;
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
	public String getDeathratename() {
		return deathratename;
	}
	public void setDeathratename(String deathratename) {
		this.deathratename = deathratename;
	}
	public String getDeathratevalue() {
		return deathratevalue;
	}
	public void setDeathratevalue(String deathratevalue) {
		this.deathratevalue = deathratevalue;
	}
	public String getDeathratesource() {
		return deathratesource;
	}
	public void setDeathratesource(String deathratesource) {
		this.deathratesource = deathratesource;
	}
	public int getIfdispaly() {
		return ifdispaly;
	}
	public void setIfdispaly(int ifdispaly) {
		this.ifdispaly = ifdispaly;
	}
	public String getDeathratedate() {
		return deathratedate;
	}
	public void setDeathratedate(String deathratedate) {
		this.deathratedate = deathratedate;
	}
	public String getDeathrateauthor() {
		return deathrateauthor;
	}
	public void setDeathrateauthor(String deathrateauthor) {
		this.deathrateauthor = deathrateauthor;
	}
	
	
	
	
}
