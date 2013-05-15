package org.example.ws.pojo;

import org.example.ws.bean.Commercial;
import org.example.ws.bean.Coupon;


public class CommercialDetail {
	private Commercial commercial;
	private String[] facility;
	private Coupon coupon;
	private PictureSetDetail[] pictureSetDetail;
	private Byte[] cover;
	/**
	 * @return the commercial
	 */
	public Commercial getCommercial() {
		return commercial;
	}
	/**
	 * @param commercial the commercial to set
	 */
	public void setCommercial(Commercial commercial) {
		this.commercial = commercial;
	}
	/**
	 * @return the facility
	 */
	public String[] getFacility() {
		return facility;
	}
	/**
	 * @param facility the facility to set
	 */
	public void setFacility(String[] facility) {
		this.facility = facility;
	}
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
	 * @return the pictureSetDetail
	 */
	public PictureSetDetail[] getPictureSetDetail() {
		return pictureSetDetail;
	}
	/**
	 * @param pictureSetDetail the pictureSetDetail to set
	 */
	public void setPictureSetDetail(PictureSetDetail[] pictureSetDetail) {
		this.pictureSetDetail = pictureSetDetail;
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
