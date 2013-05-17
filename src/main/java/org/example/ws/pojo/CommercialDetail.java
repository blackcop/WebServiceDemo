package org.example.ws.pojo;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import org.example.ws.bean.Commercial;
import org.example.ws.bean.Coupon;

@XmlRootElement(name = "CommercialDetail")
public class CommercialDetail {
	private Commercial commercial;
	private Collection<String> facility;
	private Collection<Coupon> coupons;
	private Collection<PictureSetDetail> pictureSetDetail;
	private byte[] cover;

	/**
	 * @return the commercial
	 */
	public Commercial getCommercial() {
		return commercial;
	}

	/**
	 * @param commercial
	 *            the commercial to set
	 */
	public void setCommercial(Commercial commercial) {
		this.commercial = commercial;
	}

	public Collection<String> getFacility() {
		return facility;
	}

	public void setFacility(Collection<String> facility) {
		this.facility = facility;
	}

	public Collection<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Collection<Coupon> coupons) {
		this.coupons = coupons;
	}

	public Collection<PictureSetDetail> getPictureSetDetail() {
		return pictureSetDetail;
	}

	public void setPictureSetDetail(
			Collection<PictureSetDetail> pictureSetDetail) {
		this.pictureSetDetail = pictureSetDetail;
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
