package org.example.ws;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.example.ws.dao.CouponDao;
import org.example.ws.domain.Coupon;
import org.example.ws.service.CouponService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class CouponServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	CouponService couponService;
	CouponDao couponDao;

	@Test
	protected void testAddCouponCount() {
		Coupon coupon = couponDao.getObjectById(10001);
		int count = coupon.getCount().intValue();
		couponService.AddCouponCount(10001);
		count++;
		assertEquals(count, coupon.getCount().intValue());

	}

	@Test
	protected void testRecommend() {
		Response resp = couponService.recommend();
		assertNotNull(resp.getEntity());
	}

}
