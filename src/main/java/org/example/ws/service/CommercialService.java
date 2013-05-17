package org.example.ws.service;

import java.util.List;

import org.example.ws.bean.Coupon;
import org.example.ws.pojo.CommercialDetail;
import org.example.ws.pojo.Filter;
import org.example.ws.pojo.PictureDetail;

public interface CommercialService {

	/**
	 * 发布优惠券
	 * 
	 * @param coupon
	 */
	public void publishCoupon(Coupon coupon);

	public CommercialDetail getDetail(int commercialId);

	public List<PictureDetail> getPictureSetDetail(int pictureSetId);

	public List<CommercialDetail> filterCommercial(Filter filter);

	public List<Coupon> getCoupons();

}
