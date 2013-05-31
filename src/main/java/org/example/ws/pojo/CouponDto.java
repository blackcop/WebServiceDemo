package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dijia.Tang
 * 
 */
@XmlRootElement(name = "coupon")
public class CouponDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer commId;

	private Integer couponId;

	private String detail;

	private Integer count;

	private String commName;

	private Date beginDate;

	private Date endDate;

	private String beginDateStr;

	private String endDateStr;

	private String coupon_content;// 优惠券内容

	@XmlElement(name = "begin_date")
	public String getBeginDateStr() {
		return beginDateStr;
	}

	public void setBeginDateStr(String beginDateStr) {
		this.beginDateStr = beginDateStr;
	}

	@XmlElement(name = "end_date")
	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	private String picture_url;

	@XmlElement(name = "commercial_id")
	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	@XmlElement(name = "coupon_id")
	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	@XmlElement(name = "detail")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@XmlElement(name = "coupon_count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "commercial_name")
	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@XmlElement(nillable = false)
	public Date getBeginDate() {
		return beginDate;
	}

	@XmlElement(nillable = false)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@XmlElement(name = "picture_url")
	public String getPicture_url() {
		return picture_url;
	}

	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}

	@XmlElement(name = "coupon_content")
	public String getCoupon_content() {
		return coupon_content;
	}

	public void setCoupon_content(String coupon_content) {
		this.coupon_content = coupon_content;
	}

}
