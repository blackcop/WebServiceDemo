/**
 * 
 */
package org.example.ws.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.example.ws.bean.Account;
import org.example.ws.bean.Coupon;
import org.example.ws.dao.AccountDao;
import org.example.ws.dao.CouponDao;
import org.example.ws.pojo.AssociationDto;
import org.example.ws.pojo.CouponDto;
import org.example.ws.pojo.CouponInfoOfAccount;
import org.example.ws.pojo.FavoriteInfo;
import org.example.ws.service.AccountService;
import org.example.ws.util.DozerBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author peifei
 * 
 */
@Path("/account")
@Produces("application/json")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private DozerBeanUtil dozerBeanUtil;
	@Autowired
	private CouponDao couponDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.example.ws.service.AccountService#showMyCoupons(int)
	 */
	@GET
	@Path("/showMyCoupons")
	@Produces({ "application/json" })
	@Override
	public List<CouponInfoOfAccount> showMyCoupons(
			@QueryParam("account_id") int account_id) {
		Account account = accountDao.getObjectById(account_id);
		Set<Coupon> coupons = account.getCoupons();
		List<CouponInfoOfAccount> results = new ArrayList<CouponInfoOfAccount>();
		for (Coupon coupon : coupons) {
			CouponInfoOfAccount cioa = new CouponInfoOfAccount();
			cioa.setComm_id(coupon.getCommId());
			cioa.setCommercialName(coupon.getCommName());
			cioa.setCouponId(coupon.getCouponId());
			results.add(cioa);
		}
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.example.ws.service.AccountService#addCoupon(org.example.ws.bean.Coupon
	 * , int) function of addCoupon has some wrong
	 */
	@POST
	@Path("/addCoupon")
	@Produces({ "application/json" })
	@Override
	public void addCoupon(CouponDto couponDto,
			@QueryParam("account_id") int account_id) {
		Account account = accountDao.getObjectById(account_id);
		Coupon coupon = couponDao.getObjectById(couponDto.getCommId());
		account.getCoupons().add(coupon);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.example.ws.service.AccountService#getAssociations(int)
	 */
	@GET
	@Path("/getAssociations")
	@Produces({ "application/json" })
	@Override
	public List<AssociationDto> getAssociations(
			@QueryParam("account_id") int account_id) {
		// Account account=accountDao.getObjectById(account_id);
		// List<AssociationDto> associationList= new
		// ArrayList<AssociationDto>();
		// Set<Association> associations=account.getAssociations();
		// for(Association association:associations){
		// AssociationDto associationDto = dozerBeanUtil.convert(association,
		// AssociationDto.class);
		// associationList.add(associationDto);
		// }
		// return associationList;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.example.ws.service.AccountService#getFavorite(int)
	 */
	@GET
	@Path("/getFavorite")
	@Produces({ "application/json" })
	@Override
	public List<FavoriteInfo> getFavorite(
			@QueryParam("account_id") int account_id) {
		Account account = accountDao.getObjectById(account_id);
		List<FavoriteInfo> results = new ArrayList<FavoriteInfo>();
		Set<Coupon> Coupons = account.getCoupons();
		for (Coupon coupon : Coupons) {
			FavoriteInfo faveInfo = new FavoriteInfo();
			faveInfo.setCommercialId(coupon.getCommId());
			faveInfo.setCommercialName(coupon.getCommName());
			results.add(faveInfo);
		}
		return results;
	}

	/**
	 * @return the accountDao
	 */
	public AccountDao getAccountDao() {
		return accountDao;
	}

	/**
	 * @param accountDao
	 *            the accountDao to set
	 */
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * @return the dozerBeanUtil
	 */
	public DozerBeanUtil getDozerBeanUtil() {
		return dozerBeanUtil;
	}

	/**
	 * @param dozerBeanUtil
	 *            the dozerBeanUtil to set
	 */
	public void setDozerBeanUtil(DozerBeanUtil dozerBeanUtil) {
		this.dozerBeanUtil = dozerBeanUtil;
	}

}
