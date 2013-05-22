/**
 * 
 */
package org.example.ws.service.impl;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.example.ws.pojo.AddCouponDto;
import org.example.ws.pojo.RecomdCoupnDto;
import org.example.ws.pojo.RecomdInfoDto;
import org.example.ws.service.CouponService;

/**
 * @author lvl
 *
 */
@Path("")
public class CouponServiceImpl implements CouponService {

//	@Autowired
//	private CouponDao couponDao;
//	@Autowired
//	private DozerBeanUtil dozerBeanUtil;
	
	
	@GET
	@Path("/AddCouponCount")
	@Produces({ "application/json" })
	public Response AddCouponCount(@QueryParam("coupon_id") int coupon_id) {
/*		Coupon coupon=couponDao.getObjectById(coupon_id);
		AddCouponDto addCoupon=dozerBeanUtil.convert(coupon, AddCouponDto.class);
		int AddCount=addCoupon.getCount();
		AddCount++;
		addCoupon.setCount(AddCount);
		*/

		AddCouponDto addCouponDto=new AddCouponDto();
		addCouponDto.setCount(2);
		
		Response resp = Response.status(Response.Status.OK).entity(addCouponDto).build();
		return resp;
	}

	@GET
	@Path("/getRecomdInfo")
	@Produces({ "application/json" })
	public Response recommend() {
		RecomdCoupnDto recomdCpnDto=new RecomdCoupnDto();
		ArrayList<RecomdInfoDto> recomdInfoDto=new ArrayList<RecomdInfoDto>();
		RecomdInfoDto recomdInfo=new RecomdInfoDto();
		recomdInfo.setCouponId(30001);
		recomdInfo.setCommId(11);
		recomdInfo.setCommName("kaochi");
		recomdInfo.setCount(11);
		recomdInfo.setDetail("88折");
		recomdInfo.setPicUrl("http://picserver/img1.jpg");	
		recomdInfoDto.add(recomdInfo);
		recomdCpnDto.setCoupon_list(recomdInfoDto);

		recomdInfo=new RecomdInfoDto();
		recomdInfo.setCouponId(30002);
		recomdInfo.setCommId(22);
		recomdInfo.setCommName("kaoya");
		recomdInfo.setCount(12);
		recomdInfo.setDetail("77折");
		recomdInfo.setPicUrl("http://picserver/img2.jpg");
		recomdInfoDto.add(recomdInfo);
		recomdCpnDto.setOwn_count(2);
		recomdCpnDto.setCoupon_list(recomdInfoDto);
        
		Response resp = Response.status(Response.Status.OK).entity(recomdCpnDto).build();
		return resp;
	}

}
