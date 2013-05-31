/**
 * 
 */
package org.example.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.example.ws.dao.CouponDao;
import org.example.ws.dao.PictureDao;
import org.example.ws.domain.Coupon;
import org.example.ws.domain.Picture;
import org.example.ws.pojo.AddCouponDto;
import org.example.ws.pojo.RecomdCoupnDto;
import org.example.ws.pojo.RecomdInfoDto;
import org.example.ws.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lvl
 * 
 */
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponDao couponDao;

	@Autowired
	private PictureDao pictureDao;

	@GET
	@Path("/AddCouponCount")
	@Produces({ "application/json;charset=utf-8" })
	public Response AddCouponCount(@QueryParam("coupon_id") Integer coupon_id) {
		AddCouponDto addCoupon = new AddCouponDto();

		if (coupon_id == null) {
			addCoupon.setErrorCode("REQ_PARAM_ERROR");
			addCoupon.setErrorMsg("请求参数错误");
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(addCoupon).build();
		}
		Coupon coupon = couponDao.getObjectById(coupon_id);

		if (coupon == null) {
			addCoupon.setErrorCode("REQ_RESOURCE_NOT_FOUND");
			addCoupon.setErrorMsg("请求资源未找到");
			return Response.status(Response.Status.NOT_FOUND).entity(addCoupon)
					.build();
		}

		int addCount = coupon.getCount();
		addCount++;
		coupon.setCount(addCount);
		addCoupon.setCount(addCount);
		couponDao.update(coupon);

		Response resp = Response.status(Response.Status.OK).entity(addCoupon)
				.build();
		return resp;
	}

	@GET
	@Path("/getRecomdInfo")
	@Produces({ "application/json;charset=utf-8" })
	public Response recommend() {

		RecomdCoupnDto recomdCpnDto = new RecomdCoupnDto();
		ArrayList<RecomdInfoDto> recomdInfoDto = new ArrayList<RecomdInfoDto>();
		RecomdInfoDto recomdInfo = new RecomdInfoDto();
		List<Coupon> coupons = couponDao.findAll();
		int ownCount = 0;

		for (Coupon coupon : coupons) {
			if (coupon.getIsRecommend()) {
				recomdInfo = new RecomdInfoDto();
				ownCount++;
				recomdInfo.setCouponId(coupon.getCouponId());
				recomdInfo.setCommId(coupon.getCommId());
				recomdInfo.setCommName(coupon.getCommName());
				recomdInfo.setCount(coupon.getCount());
				recomdInfo.setDetail(coupon.getDetail());
				Picture picture = pictureDao.getObjectById(coupon
						.getPictureId());
				recomdInfo.setPicUrl(picture.getFile());
				recomdInfoDto.add(recomdInfo);
			}
		}
		recomdCpnDto.setCouponList(recomdInfoDto);
		recomdCpnDto.setCount(ownCount);
		Response resp = Response.status(Response.Status.OK)
				.entity(recomdCpnDto).build();
		return resp;
	}

	@Override
	public Response getCouponDetailById(Integer coupon_id) {
		Coupon coupon = couponDao.getObjectById(coupon_id);
		
		return null;
	}

}
