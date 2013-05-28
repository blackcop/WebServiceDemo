package org.example.ws.pojo;

import org.example.ws.domain.Coupon;

public class CouponInfo {

	private Coupon coupon;
	private byte[] cover;

	/**
	 * @return the coupon
	 */
	public Coupon getCoupon() {
		return coupon;
	}

	/**
	 * @param coupon
	 *            the coupon to set
	 */
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	/**
	 * @return the cover
	 */
	public byte[] getCover() {
		return cover;
	}

	/**
	 * @param cover
	 *            the cover to set
	 */
	public void setCover(byte[] cover) {
		this.cover = cover;
	}
}
