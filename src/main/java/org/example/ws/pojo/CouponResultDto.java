package org.example.ws.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.ws.util.BaseRestResponse;

@XmlRootElement(name = "result")
public class CouponResultDto extends BaseRestResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CouponDto couponDto;

	@XmlElement(name = "coupon")
	public CouponDto getCouponDto() {
		return couponDto;
	}

	public void setCouponDto(CouponDto couponDto) {
		this.couponDto = couponDto;
	}

}
