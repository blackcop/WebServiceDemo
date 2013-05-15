package org.example.ws.service;

import java.util.List;

import shixun.livestreet.db.pojo.Association;
import shixun.livestreet.db.pojo.Coupon;
import shixun.livestreet.pojo.CouponInfoOfAccount;
import shixun.livestreet.pojo.FavoriteInfo;

public interface AccountService {

	public List<CouponInfoOfAccount> showMyCoupons(int account_id);

	public void addCoupon(Coupon coupon, int account_id);

	public List<Association> getAssociations(int accountId);

	public List<FavoriteInfo> getFavorite(int accountId);
}
