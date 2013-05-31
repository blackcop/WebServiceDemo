package org.example.ws.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.ws.util.BaseRestResponse;

@XmlRootElement(name = "result")
public class AddCouponDto extends BaseRestResponse {



	private Integer couponCount;

	@XmlElement(name = "coupon_count")
	public Integer getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}


}
