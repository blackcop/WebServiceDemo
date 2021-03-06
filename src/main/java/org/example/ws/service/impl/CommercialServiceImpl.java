/**
 * 
 */
package org.example.ws.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.example.ws.dao.CommercialDao;
import org.example.ws.dao.CouponDao;
import org.example.ws.dao.PictureDao;
import org.example.ws.dao.PictureSetDao;
import org.example.ws.pojo.CommercialDetailDto;
import org.example.ws.pojo.CommercialSummaryDto;
import org.example.ws.pojo.CommercialSummarysDto;
import org.example.ws.pojo.CouponDto;
import org.example.ws.pojo.PhoneNumberDto;
import org.example.ws.service.CommercialService;
import org.example.ws.util.DozerBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author peifei
 * 
 */
@Path("")
public class CommercialServiceImpl implements CommercialService {

	@Autowired
	private PictureDao pictureDao;

	@Autowired
	private CouponDao couponDao;

	@Autowired
	private CommercialDao commercialDao;

	@Autowired
	private PictureSetDao pictureSetDao;

	@Autowired
	private DozerBeanUtil dozerBeanUtil;

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

	public DozerBeanUtil getDozerBeanUtil() {
		return dozerBeanUtil;
	}

	public void setDozerBeanUtil(DozerBeanUtil dozerBeanUtil) {
		this.dozerBeanUtil = dozerBeanUtil;
	}

	public PictureDao getPictureDao() {
		return pictureDao;
	}

	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	public PictureSetDao getPictureSetDao() {
		return pictureSetDao;
	}

	public void setPictureSetDao(PictureSetDao pictureSetDao) {
		this.pictureSetDao = pictureSetDao;
	}

	@GET
	@Path("/getCommercialDetail")
	@Produces({ "application/json" })
	@Override
	public CommercialDetailDto getCommercialDetail(int commercialId) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("/getCommercialsByFilters")
	@Produces({ "application/json" })
	@Override
	public Response getCommercialsByFilters(
			@QueryParam("region_pname") String region_pname,
			@QueryParam("region_cname") String region_cname,
			@QueryParam("kind_pname") String kind_pname,
			@QueryParam("kind_cname") String kind_cname,
			@QueryParam("budget") Integer budget,
			@QueryParam("isCardSupported") Boolean isCardSupported,
			@QueryParam("isSmokeEnable") Boolean isSmokeEnable,
			@QueryParam("isWifiSupported") Boolean isWifiSupported,
			@QueryParam("isJapanese") Boolean isJapanese,
			@QueryParam("isIvoiceSupported") Boolean isIvoiceSupported,
			@QueryParam("isPrivateRoomEnabled") Boolean isPrivateRoomEnabled) {
		List<CommercialSummaryDto> result = new ArrayList<CommercialSummaryDto>();
		CommercialSummaryDto commercialSummaryDto1 = new CommercialSummaryDto();
		commercialSummaryDto1.setCommId(100001);
		commercialSummaryDto1
				.setPictUrl("http://c.hiphotos.baidu.com/album/w%3D2048/sign=7991391cf9dcd100cd9cff2146b34610/0eb30f2442a7d9338ac37762ac4bd11373f001b3.jpg");
		commercialSummaryDto1.setName("小豆面馆");
		commercialSummaryDto1.setKind1("美食");
		commercialSummaryDto1.setKind2("中华料理");
		commercialSummaryDto1.setBudget(80);
		commercialSummaryDto1.setIsCardSupported(true);
		commercialSummaryDto1.setIsIvoiceSupported(true);
		commercialSummaryDto1.setIsJapanese(false);
		commercialSummaryDto1.setIsPrivateRoomEnabled(true);
		commercialSummaryDto1.setIsSmokeEnable(false);
		commercialSummaryDto1.setIsWifiSupported(true);
		commercialSummaryDto1.setAddress("朝阳区西坝河光熙门北里34号楼 ");
		PhoneNumberDto phoneNumberDto = new PhoneNumberDto(100001,
				"167893289132", null);
		List<PhoneNumberDto> phoneNumberDtos = new ArrayList<PhoneNumberDto>();
		phoneNumberDtos.add(phoneNumberDto);
		commercialSummaryDto1.setPhonenumbers(phoneNumberDtos);
		commercialSummaryDto1.setRegion1("浙江");
		commercialSummaryDto1.setRegion2("杭州");

		CouponDto couponDto1 = new CouponDto();
		couponDto1.setCommId(100001);
		couponDto1.setCouponId(222222);
		couponDto1.setDetail("XXXXXXXXXXXXXXXXX");
		couponDto1.setCount(10);
		couponDto1.setCommName("大豆面馆");
		couponDto1.setBeginDate(new Date());
		couponDto1.setEndDate(new Date());
		couponDto1.setPictureId(333333);

		CouponDto couponDto2 = new CouponDto();
		couponDto2.setCommId(100001);
		couponDto2.setCouponId(222223);
		couponDto2.setDetail("YYYYYYYYYY");
		couponDto2.setCount(13);
		couponDto2.setCommName("大豆面馆");
		couponDto2.setBeginDate(new Date());
		couponDto2.setEndDate(new Date());
		couponDto2.setPictureId(333333);

		List<CouponDto> list1 = new ArrayList<CouponDto>();
		list1.add(couponDto1);
		list1.add(couponDto2);
		commercialSummaryDto1.setCoupons(list1);
		result.add(commercialSummaryDto1);

		CommercialSummaryDto commercialSummaryDto2 = new CommercialSummaryDto();
		commercialSummaryDto2.setCommId(100002);
		commercialSummaryDto2
				.setPictUrl("http://a.hiphotos.baidu.com/album/w%3D2048/sign=49eee9e1cc11728b302d8b22fcc4c2ce/d833c895d143ad4b49fd20b083025aafa50f06ea.jpg");
		commercialSummaryDto2.setName("大豆面馆");
		commercialSummaryDto2.setKind1("美食");
		commercialSummaryDto2.setKind2("中华料理");
		commercialSummaryDto2.setBudget(77);
		commercialSummaryDto2.setIsCardSupported(false);
		commercialSummaryDto2.setIsIvoiceSupported(true);
		commercialSummaryDto2.setIsJapanese(false);
		commercialSummaryDto2.setIsPrivateRoomEnabled(true);
		commercialSummaryDto2.setIsSmokeEnable(false);
		commercialSummaryDto2.setIsWifiSupported(true);
		commercialSummaryDto2.setAddress("朝阳区西坝河光熙门北里34号楼 ");
		PhoneNumberDto phoneNumberDto1 = new PhoneNumberDto(100002,
				"167893289132", "");
		PhoneNumberDto phoneNumberDto2 = new PhoneNumberDto(100002,
				"456787654234", "日语可用");
		List<PhoneNumberDto> phoneNumberDtos1 = new ArrayList<PhoneNumberDto>();
		phoneNumberDtos1.add(phoneNumberDto1);
		phoneNumberDtos1.add(phoneNumberDto2);
		commercialSummaryDto2.setPhonenumbers(phoneNumberDtos1);
		commercialSummaryDto2.setRegion1("浙江");
		commercialSummaryDto2.setRegion2("杭州");
		CouponDto couponDto3 = new CouponDto();
		couponDto3.setCommId(100002);
		couponDto3.setCouponId(222232);
		couponDto3.setDetail("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		couponDto3.setCount(10);
		couponDto3.setCommName("大豆面馆");
		couponDto3.setBeginDate(new Date());
		couponDto3.setEndDate(new Date());
		couponDto3.setPictureId(333333);
		List<CouponDto> list2 = new ArrayList<CouponDto>();
		list2.add(couponDto3);
		commercialSummaryDto2.setCoupons(list2);
		result.add(commercialSummaryDto2);
		CommercialSummarysDto commercialSummarysDto = new CommercialSummarysDto();
		commercialSummarysDto.setCommercialSummarys(result);
		commercialSummarysDto.setCount(result.size());
		commercialSummarysDto.setErrorMessage("success");
		// return result;
		return Response.ok(commercialSummarysDto).build();
	}
}
