package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
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
	
	private Integer pictureId;

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

	@XmlElement(name = "begin_date")
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@XmlElement(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@XmlElement(name = "picture_id")
	public Integer getPictureId() {
		return pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	@Override
	public String toString() {
		return "CouponDto [commId=" + commId + ", couponId=" + couponId
				+ ", detail=" + detail + ", count=" + count + ", commName="
				+ commName + ", beginDate=" + beginDate + ", endDate="
				+ endDate + ", pictureId=" + pictureId + "]";
	}
}
