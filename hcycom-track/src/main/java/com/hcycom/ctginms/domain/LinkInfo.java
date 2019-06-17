package com.hcycom.ctginms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "hcy_mn_link_info")
public class LinkInfo{
	
	@Id
	@Column(name = "link_id")
	@ApiModelProperty(value="链路ID")
	private String linkid;
	
	@Column(name = "delay_threshold")
	@ApiModelProperty(value="时延门限")
	private Double delaythreshold;
	
	@Column(name = "device_a_id")
	@ApiModelProperty(value="A端设备ID")
	private String deviceaid;
	
	@Column(name = "device_z_id")
	@ApiModelProperty(value="Z端设备ID")
	private String devicezid;
	
	@Column(name = "link_category")
	@ApiModelProperty(value="平台")
	private Integer linkcategory;

	public String getLinkid() {
		return linkid;
	}

	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}

	public Double getDelaythreshold() {
		return delaythreshold;
	}

	public void setDelaythreshold(Double delaythreshold) {
		this.delaythreshold = delaythreshold;
	}

	public String getDeviceaid() {
		return deviceaid;
	}

	public void setDeviceaid(String deviceaid) {
		this.deviceaid = deviceaid;
	}

	public String getDevicezid() {
		return devicezid;
	}

	public void setDevicezid(String devicezid) {
		this.devicezid = devicezid;
	}

	public Integer getLinkcategory() {
		return linkcategory;
	}

	public void setLinkcategory(Integer linkcategory) {
		this.linkcategory = linkcategory;
	}

}
