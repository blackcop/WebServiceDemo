package org.example.ws.pojo;

import javax.xml.bind.annotation.XmlElement;

public class RecomdInfoDto {
	private Integer couponId;
	private Integer commId;
	private String detail;
	private Integer count;
	private String commName;
	private String picUrl;
	
	@XmlElement(name = "coupon_id") 
	public Integer getCouponId() {
		return couponId;
	}
	
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	@XmlElement(name = "comm_id") 
	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}
	
	@XmlElement(name = "detail") 
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	@XmlElement(name = "count") 
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@XmlElement(name = "comm_name") 
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	@XmlElement(name = "pic_url") 
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	

	

}
