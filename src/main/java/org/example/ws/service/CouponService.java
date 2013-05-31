package org.example.ws.service;

import javax.ws.rs.core.Response;

public interface CouponService {

	public Response AddCouponCount(Integer coupon_id);

	public Response recommend();

	/**
	 * 根据优惠券ID获取优惠券的详细信息
	 * 
	 * @author Dijia.Tang
	 * @param coupon_id
	 * @return
	 */
	public Response getCouponDetailById(Integer coupon_id);

}
