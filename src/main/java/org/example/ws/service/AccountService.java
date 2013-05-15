package org.example.ws.service;

import java.util.List;

import org.example.ws.bean.Association;
import org.example.ws.bean.Coupon;
import org.example.ws.pojo.CouponInfoOfAccount;
import org.example.ws.pojo.FavoriteInfo;

public interface AccountService {

	public List<CouponInfoOfAccount> showMyCoupons(int account_id);

	public void addCoupon(Coupon coupon, int account_id);

	public List<Association> getAssociations(int accountId);

	public List<FavoriteInfo> getFavorite(int accountId);
}
