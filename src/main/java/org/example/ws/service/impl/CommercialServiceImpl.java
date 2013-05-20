/**
 * 
 */
package org.example.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.example.ws.bean.Commercial;
import org.example.ws.bean.Coupon;
import org.example.ws.dao.CommercialDao;
import org.example.ws.dao.CouponDao;
import org.example.ws.pojo.CommercialDetail;
import org.example.ws.pojo.Filter;
import org.example.ws.pojo.PictureDetail;
import org.example.ws.service.CommercialService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author peifei
 * 
 */
@Path("")
public class CommercialServiceImpl implements CommercialService {

	@Autowired
	private CouponDao couponDao;

	@Autowired
	private CommercialDao commercialDao;

	public CouponDao getCouponDao() {
		return couponDao;
	}

	public CommercialDao getCommercialDao() {
		return commercialDao;
	}

	public void setCommercialDao(CommercialDao commercialDao) {
		this.commercialDao = commercialDao;
	}

	public void setCouponDao(CouponDao couponDao) {
		this.couponDao = couponDao;
	}

	@GET
	@Path("/publishCoupon")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Override
	public void publishCoupon(Coupon coupon) {
		System.out.println(coupon.getCommName());
		couponDao.save(coupon);
	}

	@GET
	@Path("/getDetail")
	@Produces({ "application/json" })
	@Override
	public CommercialDetail getDetail(int commercialId) {
		CommercialDetail commercialDetail = new CommercialDetail();
		Commercial commercial = commercialDao.getObjectById(commercialId);
		String hql1 = "from Coupon where commId = ?";
		List<Coupon> coupons = couponDao.findListByParams(hql1,
				new Object[] { commercialId });
		commercialDetail.setCommercial(commercial);
		commercialDetail.setCoupons(coupons);
		return null;
	}

	@Override
	public List<PictureDetail> getPictureSetDetail(int pictureSetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("/filterCommercial")
	@Produces({ "application/json" })
	@Consumes({ MediaType.APPLICATION_JSON })
	@Override
	public List<CommercialDetail> filterCommercial(Filter filter) {
		System.out.println("处理更新类别逻辑，接受的数据为id:" + filter.getKey());
		return null;
	}

	@GET
	@Path("/getCoupons")
	@Produces({ "application/json" })
	@Override
	public List<Coupon> getCoupons() {
		List<Coupon> result = new ArrayList<Coupon>();
		List<Coupon> coupons = couponDao.findAll();
		Coupon coupon = null;
		for (int i = 0; i < coupons.size(); i++) {
			coupon = coupons.get(i);
			result.add(coupon);
		}
		return result;
	}

}
