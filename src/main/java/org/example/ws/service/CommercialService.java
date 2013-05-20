package org.example.ws.service;

import java.util.List;

import org.example.ws.pojo.CommercialDetailDto;
import org.example.ws.pojo.CouponDto;
import org.example.ws.pojo.FilterDto;
import org.example.ws.pojo.PictureDto;
import javax.ws.rs.core.Response;

public interface CommercialService {

	/**
	 * 发布优惠券
	 * 
	 * @param coupon
	 * 
	 *            Json格式：
	 *            {"Coupon":{"commId":1,"couponId":22222,"detail":"新客,一律88折",
	 *            "count":50,"commName":"CommName","beginDate":
	 *            "2013-05-17T00:00:00+08:00"
	 *            ,"endDate":"2014-05-17T00:00:00+08:00","pictureId":null}}
	 */
	public Response publishCoupon(CouponDto couponDto);

	public CommercialDetailDto getDetail(int commercialId);

	public List<PictureDto> getPictureSetDetail(int pictureSetId);

	public List<CommercialDetailDto> filterCommercial(FilterDto filterDto);

	// public List<CouponDto> getCoupons();

}
