package com.hcycom.ctginms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午4:08:22   
 * @name 李硕
 * @Description: value表（有pm2.5小时值的表）的实体类
 */
@Entity
@Table(name = "value")
public class Value {

	/*
  `ID_NEW` varchar(255) NOT NULL,主键
  `AQI` varchar(255) default NULL,
  `AREA` varchar(255) default NULL,
  `PM25` varchar(255) default NULL,pm2.5浓度值
  `O3` varchar(255) default NULL,
  `CO` varchar(255) default NULL,
  `PM10` varchar(255) default NULL,
  `SO2` varchar(255) default NULL,
  `NO2` varchar(255) default NULL,
  `O3_8H` varchar(255) default NULL,
  `POSITION_NAME` varchar(255) default NULL,
  `PRIMARY_POLLUTANT` varchar(255) default NULL,
  `QUALITY` varchar(255) default NULL,
  `STATION_CODE` varchar(255) default NULL,
  `TIME_POINT` date default NULL,采集时间
  `LEVELS` varchar(255) default NULL,
  `CURRENTYEAR` varchar(255) default NULL,
  `LATITUDE` varchar(255) default NULL,
  `LONGITUDE` varchar(255) default NULL,
  `CURRENT_TIME` date default NULL,
  `AREA_CODE` varchar(255) default NULL,
  `PROVINCE` varchar(255) default NULL,省份
  `CITY` varchar(255) default NULL,城市
  `DISTRICT` varchar(255) default NULL,区县
	 * */
	@Id
	@Column(name = "ID_NEW")
	@ApiModelProperty(value="ID主键")
	private String idnew;
	
	@Column(name = "AQI")
	@ApiModelProperty(value="")
	private String aqi;
	
	@Column(name = "AREA")
	@ApiModelProperty(value="")
	private String area;
	
	@Column(name = "PM25")
	@ApiModelProperty(value="pm2.5浓度值")
	private String pm25;
	
	@Column(name = "O3")
	@ApiModelProperty(value="")
	private String o3;
	
	@Column(name = "CO")
	@ApiModelProperty(value="")
	private String co;
	
	@Column(name = "")
	@ApiModelProperty(value="")
	private String pm10;
	
	@Column(name = "SO2")
	@ApiModelProperty(value="")
	private String so2;
	
	@Column(name = "NO2")
	@ApiModelProperty(value="")
	private String no2;
	
	@Column(name = "O3_8H")
	@ApiModelProperty(value="")
	private String o38h;
	
	@Column(name = "POSITION_NAME")
	@ApiModelProperty(value="")
	private String positionname;
	
	@Column(name = "PRIMARY_POLLUTANT")
	@ApiModelProperty(value="")
	private String primarypollutant;
	
	@Column(name = "QUALITY")
	@ApiModelProperty(value="")
	private String quality;
	
	@Column(name = "STATION_CODE")
	@ApiModelProperty(value="")
	private String stationcode;
	
	@Column(name = "TIME_POINT")
	@ApiModelProperty(value="采集时间")
	private Date timepoint;
	
	@Column(name = "LEVELS")
	@ApiModelProperty(value="")
	private String levels;
	
	@Column(name = "CURRENTYEAR")
	@ApiModelProperty(value="")
	private String currentyear;
	
	@Column(name = "LATITUDE")
	@ApiModelProperty(value="")
	private String latitude;
	
	@Column(name = "LONGITUDE")
	@ApiModelProperty(value="")
	private String longitude;
	
	@Column(name = "CURRENT_TIME")
	@ApiModelProperty(value="")
	private Date currenttime;
	
	@Column(name = "AREA_CODE")
	@ApiModelProperty(value="")
	private String areacode;
	
	@Column(name = "PROVINCE")
	@ApiModelProperty(value="省份")
	private String province;
	
	@Column(name = "CITY")
	@ApiModelProperty(value="城市")
	private String city;
	
	@Column(name = "DISTRICT")
	@ApiModelProperty(value="区县")
	private String district;

	public String getIdnew() {
		return idnew;
	}

	public void setIdnew(String idnew) {
		this.idnew = idnew;
	}

	public String getAqi() {
		return aqi;
	}

	public void setAqi(String aqi) {
		this.aqi = aqi;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPm25() {
		return pm25;
	}

	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}

	public String getO3() {
		return o3;
	}

	public void setO3(String o3) {
		this.o3 = o3;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getPm10() {
		return pm10;
	}

	public void setPm10(String pm10) {
		this.pm10 = pm10;
	}

	public String getSo2() {
		return so2;
	}

	public void setSo2(String so2) {
		this.so2 = so2;
	}

	public String getNo2() {
		return no2;
	}

	public void setNo2(String no2) {
		this.no2 = no2;
	}

	public String getO38h() {
		return o38h;
	}

	public void setO38h(String o38h) {
		this.o38h = o38h;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public String getPrimarypollutant() {
		return primarypollutant;
	}

	public void setPrimarypollutant(String primarypollutant) {
		this.primarypollutant = primarypollutant;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getStationcode() {
		return stationcode;
	}

	public void setStationcode(String stationcode) {
		this.stationcode = stationcode;
	}

	public Date getTimepoint() {
		return timepoint;
	}

	public void setTimepoint(Date timepoint) {
		this.timepoint = timepoint;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getCurrentyear() {
		return currentyear;
	}

	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getCurrenttime() {
		return currenttime;
	}

	public void setCurrenttime(Date currenttime) {
		this.currenttime = currenttime;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	
	
}
