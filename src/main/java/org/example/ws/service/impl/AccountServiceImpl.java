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

import org.example.ws.bean.Association;
import org.example.ws.bean.Coupon;
import org.example.ws.dao.AccountDao;
import org.example.ws.pojo.CouponInfoOfAccount;
import org.example.ws.pojo.FavoriteInfo;
import org.example.ws.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author peifei
 *
 */
@Path("/account")
@Produces("application/json")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao AccountDao;

	/* (non-Javadoc)
	 * @see org.example.ws.service.AccountService#showMyCoupons(int)
	 */
	@GET
	@Path("/showMyCoupons")
	@Produces({ "application/json" })
	@Override
	public List<CouponInfoOfAccount> showMyCoupons(@QueryParam("account_id") int account_id) {
		List<CouponInfoOfAccount> results = new ArrayList<CouponInfoOfAccount>();
		CouponInfoOfAccount cioa = new CouponInfoOfAccount();
		cioa.setComm_id(1);
		cioa.setCommercialName("name");
		cioa.setCouponId(1);
		results.add(cioa);
		return results;
	}

	/* (non-Javadoc)
	 * @see org.example.ws.service.AccountService#addCoupon(org.example.ws.bean.Coupon, int)
	 */
	@Override
	public void addCoupon(Coupon coupon, int account_id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.example.ws.service.AccountService#getAssociations(int)
	 */
	@Override
	public List<Association> getAssociations(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.example.ws.service.AccountService#getFavorite(int)
	 */
	@Override
	public List<FavoriteInfo> getFavorite(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the accountDao
	 */
	public AccountDao getAccountDao() {
		return AccountDao;
	}

	/**
	 * @param accountDao the accountDao to set
	 */
	public void setAccountDao(AccountDao accountDao) {
		AccountDao = accountDao;
	}

}
