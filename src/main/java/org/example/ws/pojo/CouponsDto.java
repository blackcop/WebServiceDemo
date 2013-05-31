package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Dijia.Tang
 * 
 */
public class CouponsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Collection<CouponDto> couponList;

	private Integer count;

	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "coupon_list")
	public Collection<CouponDto> getCouponList() {
		return couponList;
	}

	public void setCouponList(Collection<CouponDto> couponList) {
		this.couponList = couponList;
	}

}
