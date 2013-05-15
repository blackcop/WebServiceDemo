package org.example.ws.service;

import java.util.List;

import shixun.livestreet.db.pojo.Coupon;
import shixun.livestreet.pojo.CouponInfo;

public interface CouponService {

	public CouponInfo getDetail(int couponId);

	public List<CouponInfo> recommend();

}
