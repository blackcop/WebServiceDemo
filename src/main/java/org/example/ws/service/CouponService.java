package org.example.ws.service;

import java.util.List;

import org.example.ws.pojo.CouponInfo;

public interface CouponService {

	public CouponInfo getDetail(int couponId);

	public List<CouponInfo> recommend();

}
