package org.example.ws.service;

import java.util.List;

import org.example.ws.pojo.AssociationDto;
import org.example.ws.pojo.CouponDto;
import org.example.ws.pojo.CouponInfoOfAccount;
import org.example.ws.pojo.FavoriteInfo;

public interface AccountService {

	public List<CouponInfoOfAccount> showMyCoupons(int account_id);

	public void addCoupon(CouponDto couponDto, int account_id);

	public List<AssociationDto> getAssociations(int accountId);

	public List<FavoriteInfo> getFavorite(int accountId);
}
