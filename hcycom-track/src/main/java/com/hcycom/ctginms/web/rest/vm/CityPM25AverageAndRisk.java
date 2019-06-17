package com.hcycom.ctginms.web.rest.vm;
/**      
 * @author: 北京华晨阳通信技术有限责任公司
 * @date:2018年5月17日 下午2:42:36   
 * @name 李硕
 * @Description: 城市时间段内pm2.5均值，以及分险特征值
 */
public class CityPM25AverageAndRisk {
	
	private String province;//省
	private String city;//市
	private String district;//区县
	private Double pm25;//pm2.5均值
	private int risk;//超额总死亡人数
	private int days;//计算的几天的
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
	public Double getPm25() {
		return pm25;
	}
	public void setPm25(Double pm25) {
		this.pm25 = pm25;
	}
	public int getRisk() {
		return risk;
	}
	public void setRisk(int risk) {
		this.risk = risk;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	
}
