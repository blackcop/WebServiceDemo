package org.example.ws.service;


import javax.ws.rs.core.Response;


public interface CouponService {

	public Response AddCouponCount(Integer coupon_id);

	public Response recommend();

}
