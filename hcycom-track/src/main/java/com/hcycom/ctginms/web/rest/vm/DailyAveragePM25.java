package com.hcycom.ctginms.web.rest.vm;

import java.util.Date;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonFormat;

/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月16日 下午4:44:04   
 * @name 李硕
 * @Description: 通过分组查询，将pm2.5日均值进行计算，得到每天对应的日均值，的实体类
 */
public class DailyAveragePM25 {

	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private String province;//省
	private String city;//市
	private String district;//区县
	private Date timepoint;
	private Double pm25;
	
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
	public Date getTimepoint() {
		return timepoint;
	}
	public void setTimepoint(Date timepoint) {
		this.timepoint = timepoint;
	}
	public Double getPm25() {
		return pm25;
	}
	public void setPm25(Double pm25) {
		this.pm25 = pm25;
	}
	
}
