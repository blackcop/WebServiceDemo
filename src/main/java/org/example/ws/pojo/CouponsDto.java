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

	private Collection<CouponDto> coupon_list;

	private Integer count;

	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "coupon_list")
	public Collection<CouponDto> getCoupon_list() {
		return coupon_list;
	}

	public void setCoupon_list(Collection<CouponDto> coupon_list) {
		this.coupon_list = coupon_list;
	}

}
