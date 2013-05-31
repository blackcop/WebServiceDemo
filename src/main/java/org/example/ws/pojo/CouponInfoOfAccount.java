package org.example.ws.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CouponInfoOfAccount")
public class CouponInfoOfAccount {

	private String commercialName;
	private int couponId;
	private int commId;
	/**
	 * @return the commercialName
	 */
	public String getCommercialName() {
		return commercialName;
	}
	/**
	 * @param commercialName the commercialName to set
	 */
	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}
	/**
	 * @return the couponId
	 */
	public int getCouponId() {
		return couponId;
	}
	/**
	 * @param couponId the couponId to set
	 */
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	/**
	 * @return the comm_id
	 */
	public int getCommId() {
		return commId;
	}
	/**
	 * @param comm_id the comm_id to set
	 */
	public void setCommId(int commId) {
		this.commId = commId;
	}
}
