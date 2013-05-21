package org.example.ws.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CouponList") 
public class CouponList {

	@XmlElement(name = "CouponInfoOfAccount", required = true) 
	List<CouponInfoOfAccount> coupons;

	/**
	 * @return the coupons
	 */
	public List<CouponInfoOfAccount> getCoupons() {
		return coupons;
	}

	/**
	 * @param coupons the coupons to set
	 */
	public void setCoupons(List<CouponInfoOfAccount> coupons) {
		this.coupons = coupons;
	}

}
