package org.example.ws.pojo;

import org.example.ws.bean.Coupon;


public class CouponInfo {

	private Coupon coupon;
	private Byte[] cover;
	/**
	 * @return the coupon
	 */
	public Coupon getCoupon() {
		return coupon;
	}
	/**
	 * @param coupon the coupon to set
	 */
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	/**
	 * @return the cover
	 */
	public Byte[] getCover() {
		return cover;
	}
	/**
	 * @param cover the cover to set
	 */
	public void setCover(Byte[] cover) {
		this.cover = cover;
	}
}
