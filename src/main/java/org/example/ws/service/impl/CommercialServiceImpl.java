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
import org.example.ws.dao.FacilityDao;
import org.example.ws.dao.PictureDao;
import org.example.ws.dao.PictureSetDao;
import org.example.ws.pojo.CommercialDetailDto;
import org.example.ws.pojo.CommercialDetailResultDto;
import org.example.ws.pojo.CommercialSummaryDto;
import org.example.ws.pojo.CommercialSummarysResultDto;
import org.example.ws.pojo.CouponDto;
import org.example.ws.pojo.PhoneNumberDto;
import org.example.ws.pojo.PictureDto;
import org.example.ws.pojo.PictureSetDto;
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
	private FacilityDao facilityDao;

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

	public FacilityDao getFacilityDao() {
		return facilityDao;
	}

	public void setFacilityDao(FacilityDao facilityDao) {
		this.facilityDao = facilityDao;
	}

	public PictureSetDao getPictureSetDao() {
		return pictureSetDao;
	}

	public void setPictureSetDao(PictureSetDao pictureSetDao) {
		this.pictureSetDao = pictureSetDao;
	}

	// /**
	// * 没用
	// */
	// @POST
	// @Path("/publishCoupon")
	// @Consumes({ MediaType.APPLICATION_JSON })
	// @Override
	// public Response publishCoupon(CouponDto couponDto) {
	// try {
	// System.out.println("publishCoupon");
	// Coupon coupon = dozerBeanUtil.convert(couponDto, Coupon.class);
	// couponDao.save(coupon);
	// return Response.ok().build();
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new WebApplicationException(
	// Response.Status.INTERNAL_SERVER_ERROR);
	// }
	// }

	/**
	 * 获取商户详情/
	 */
	// @GET
	// @Path("/getDetail")
	// @Produces({ "application/json" })
	// @Override
	// public CommercialDetailDto getDetail(
	// @QueryParam("commercialId") int commercialId) {
	// CommercialDetailDto result = new CommercialDetailDto();
	// try {
	// System.out.println("getDetail");
	// Commercial commercial = commercialDao.getObjectById(commercialId);
	// CommercialDto commercialDto = dozerBeanUtil.convert(commercial,
	// CommercialDto.class);
	// result.setCommercialDto(commercialDto);
	//
	// if (commercial.getPictId() != null
	// && !commercial.getPictId().equals("")) {
	// Picture picture = pictureDao.getObjectById(commercial
	// .getPictId());
	// PictureDto pictureDto = dozerBeanUtil.convert(picture,
	// PictureDto.class);
	// // TODO 根据路径获取图片的二进制
	// result.setPictureDto(pictureDto);
	// }
	//
	// String hql1 = "from Facility where commId = ?";
	// Facility facility = facilityDao.queryByHqlAndParams(hql1,
	// new Object[] { commercialId });
	// FacilityDto facilityDto = dozerBeanUtil.convert(facility,
	// FacilityDto.class);
	// result.setFacilityDto(facilityDto);
	//
	// String hql2 = "from Coupon where commId = ?";
	// List<Coupon> coupons = couponDao.findListByParams(hql2,
	// new Object[] { commercialId });
	// CouponDto couponDto = null;
	// List<CouponDto> couponDtos = new ArrayList<CouponDto>();
	// for (Coupon coupon : coupons) {
	// couponDto = dozerBeanUtil.convert(coupon, CouponDto.class);
	// couponDtos.add(couponDto);
	// }
	// result.setCouponDtos(couponDtos);
	//
	// String hql3 = "from PictureSet where comm_id = ?";
	// List<PictureSet> pictureSets = pictureSetDao.findListByParams(hql3,
	// new Object[] { commercialId });
	// PictureSetDto pictureSetDto = null;
	// List<PictureSetDto> pictureSetDtos = new ArrayList<PictureSetDto>();
	// for (PictureSet pictureSet : pictureSets) {
	// pictureSetDto = dozerBeanUtil.convert(pictureSet,
	// PictureSetDto.class);
	// // TODO 根据路径获取图片的二进制
	// pictureSetDtos.add(pictureSetDto);
	// }
	// result.setPictureSetDtos(pictureSetDtos);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return result;
	// }

	@GET
	@Path("/getCommercialDetail")
	@Produces({ "application/json" })
	@Override
	public Response getCommercialDetail(
			@QueryParam("commercialId") int commercialId) {
		CommercialDetailResultDto result = new CommercialDetailResultDto();
		CommercialDetailDto commercialDetailDto = new CommercialDetailDto();
		commercialDetailDto.setCommId(100001);
		commercialDetailDto
				.setPictUrl("http://c.hiphotos.baidu.com/album/w%3D2048/sign=7991391cf9dcd100cd9cff2146b34610/0eb30f2442a7d9338ac37762ac4bd11373f001b3.jpg");
		commercialDetailDto.setName("小豆面馆");
		commercialDetailDto.setKind1("美食");
		commercialDetailDto.setKind2("中华料理");
		commercialDetailDto.setBudget(80);
		commercialDetailDto.setIsCardSupported(true);
		commercialDetailDto.setIsIvoiceSupported(true);
		commercialDetailDto.setIsJapanese(false);
		commercialDetailDto.setIsPrivateRoomEnabled(true);
		commercialDetailDto.setIsSmokeEnable(false);
		commercialDetailDto.setIsWifiSupported(true);
		commercialDetailDto.setAddress("朝阳区西坝河光熙门北里34号楼 ");
		PhoneNumberDto phoneNumberDto = new PhoneNumberDto(100001,
				"167893289132", null);
		List<PhoneNumberDto> phoneNumberDtos = new ArrayList<PhoneNumberDto>();
		phoneNumberDtos.add(phoneNumberDto);
		commercialDetailDto.setPhonenumbers(phoneNumberDtos);
		commercialDetailDto.setRegion1("浙江");
		commercialDetailDto.setRegion2("杭州");
		commercialDetailDto.setOpentime("8:30");
		commercialDetailDto.setClosetime("22:00");
		commercialDetailDto.setLatitude(11.012);
		commercialDetailDto.setLongitude(8.143);
		CouponDto couponDto = new CouponDto();
		couponDto.setCommId(100001);
		couponDto.setCouponId(222232);
		couponDto.setDetail("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		couponDto.setCount(10);
		couponDto.setCommName("大豆面馆");
		couponDto.setBeginDate(new Date());
		couponDto.setEndDate(new Date());
		couponDto.setPictureId(333333);
		List<CouponDto> list = new ArrayList<CouponDto>();
		list.add(couponDto);
		commercialDetailDto.setCoupons(list);

		List<PictureSetDto> pictureSets = new ArrayList<PictureSetDto>();
		PictureSetDto pictureSetDto1 = new PictureSetDto();
		pictureSetDto1.setComm_id(100001);
		pictureSetDto1.setName("环境");
		pictureSetDto1.setPsId(99999);
		List<PictureDto> pictures1 = new ArrayList<PictureDto>();
		{
			PictureDto picture1 = new PictureDto();
			picture1.setFile("http://c.hiphotos.baidu.com/album/w%3D2048/sign=7991391cf9dcd100cd9cff2146b34610/0eb30f2442a7d9338ac37762ac4bd11373f001b3.jpg");
			picture1.setName("好图");
			picture1.setPictId(83682);
			picture1.setPictureSetId(99999);
			pictures1.add(picture1);
			PictureDto picture2 = new PictureDto();
			picture2.setFile("http://c.hiphotos.baidu.com/album/w%3D2048/sign=7991391cf9dcd100cd9cff2146b34610/0eb30f2442a7d9338ac37762ac4bd11373f001b3.jpg");
			picture2.setName("好图2");
			picture2.setPictId(83681);
			picture2.setPictureSetId(99999);
			pictures1.add(picture2);
		}
		pictureSetDto1.setPictures(pictures1);
		pictureSets.add(pictureSetDto1);

		PictureSetDto pictureSetDto2 = new PictureSetDto();
		pictureSetDto2.setComm_id(100001);
		pictureSetDto2.setName("环境");
		pictureSetDto2.setPsId(99998);

		List<PictureDto> pictures2 = new ArrayList<PictureDto>();
		PictureDto picture3 = new PictureDto();
		picture3.setFile("http://c.hiphotos.baidu.com/album/w%3D2048/sign=7991391cf9dcd100cd9cff2146b34610/0eb30f2442a7d9338ac37762ac4bd11373f001b3.jpg");
		picture3.setName("好图");
		picture3.setPictId(83688);
		picture3.setPictureSetId(99998);
		pictures2.add(picture3);

		pictureSetDto2.setPictures(pictures2);
		pictureSets.add(pictureSetDto2);

		commercialDetailDto.setPictureSets(pictureSets);

		result.setCommercialDetailDto(commercialDetailDto);
		result.setCount(1);
		result.setErrorMsg("error");
		return Response.ok(result).build();
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
				"167893289132", null);
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
		CommercialSummarysResultDto commercialSummarysDto = new CommercialSummarysResultDto();
		commercialSummarysDto.setCommercialSummarys(result);
		commercialSummarysDto.setCount(result.size());
		commercialSummarysDto.setErrorMsg("error");
		// return result;
		return Response.ok(commercialSummarysDto).build();
	}
	// /**
	// * 无用
	// */
	// @GET
	// @Path("/getPictureSetDetail")
	// @Produces({ "application/json" })
	// @Override
	// public List<PictureDto> getPictureSetDetail(
	// @QueryParam("commercialId") int pictureSetId) {
	// List<PictureDto> pictureDtos = new ArrayList<PictureDto>();
	// try {
	// String hql = "from Picture where pictureSetId = ?";
	// List<Picture> pictures = pictureDao.findListByParams(hql,
	// new Object[] { pictureSetId });
	// PictureDto pictureDto;
	// for (Picture picture : pictures) {
	// pictureDto = dozerBeanUtil.convert(picture, PictureDto.class);
	// pictureDtos.add(pictureDto);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return pictureDtos;
	// }

	// /**
	// *
	// */
	// @GET
	// @Path("/filterCommercial")
	// @Produces({ "application/json" })
	// @Consumes({ MediaType.APPLICATION_JSON })
	// @Override
	// public List<CommercialDetailDto> filterCommercial(FilterDto filter) {
	// List<CommercialDetailDto> commercialDetailDtos = new
	// ArrayList<CommercialDetailDto>();
	// try {
	// StringBuilder hql = new StringBuilder(
	// "from Commercial where 1 = 1 ");
	// List<Object> paramList = new ArrayList<Object>();
	// int paramsSize = 0;
	// if (filter.getKind1() != null) {
	// hql.append(" and kind1 = ? ");
	// paramsSize = paramsSize + 1;
	// paramList.add(filter.getKind1());
	// }
	// if (filter.getKind2() != null) {
	// hql.append(" and kind2 = ? ");
	// paramsSize = paramsSize + 1;
	// paramList.add(filter.getKind2());
	// }
	// if (filter.getRegion1() != null) {
	// hql.append(" and region1 = ? ");
	// paramsSize = paramsSize + 1;
	// paramList.add(filter.getRegion1());
	// }
	// if (filter.getRegion2() != null) {
	// hql.append(" and region2 = ? ");
	// paramsSize = paramsSize + 1;
	// paramList.add(filter.getRegion2());
	// }
	// if (filter.getBudget1() != null) {
	// hql.append(" and budget > ? ");
	// paramsSize = paramsSize + 1;
	// paramList.add(filter.getBudget1());
	// }
	// if (filter.getBudget2() != null) {
	// hql.append(" and budget < ? ");
	// paramsSize = paramsSize + 1;
	// paramList.add(filter.getBudget2());
	// }
	// if (filter.getKey() != null) {
	// hql.append(" and (name like %?% or address like %?% )");
	// paramsSize = paramsSize + 2;
	// paramList.add(filter.getKey());
	// paramList.add(filter.getKey());
	// }
	// Object[] params = new Object[paramsSize];
	// for (int i = 0; i < paramList.size(); i++) {
	// Object object = paramList.get(i);
	// params[i] = object;
	// }
	// List<Commercial> commercials = commercialDao.findListByParams(
	// hql.toString(), params);
	// for (Commercial commercial : commercials) {
	// CommercialDto commercialDto = dozerBeanUtil.convert(commercial,
	// CommercialDto.class);
	// CommercialDetailDto result = new CommercialDetailDto();
	// result.setCommercialDto(commercialDto);
	//
	// if (commercial.getPictId() != null
	// && !commercial.getPictId().equals("")) {
	// Picture picture = pictureDao.getObjectById(commercial
	// .getPictId());
	// PictureDto pictureDto = dozerBeanUtil.convert(picture,
	// PictureDto.class);
	// // TODO 根据路径获取图片的二进制
	// result.setPictureDto(pictureDto);
	// }
	//
	// StringBuilder hql1 = new StringBuilder(
	// "from Facility where commId = ? ");
	// List<Object> paramList2 = new ArrayList<Object>();
	// paramList2.add(commercial.getCommId());
	// int paramsSize2 = 1;
	// if (filter.getIsCardSupported() != null) {
	// hql1.append(" and isCardSupported = ?");
	// paramsSize2 = paramsSize2 + 1;
	// paramList2.add(filter.getIsCardSupported());
	// }
	// if (filter.getIsIvoiceSupported() != null) {
	// hql1.append(" and isIvoiceSupported = ?");
	// paramsSize2 = paramsSize2 + 1;
	// paramList2.add(filter.getIsIvoiceSupported());
	// }
	// if (filter.getIsJapanese() != null) {
	// hql1.append(" and isJapanese = ?");
	// paramsSize2 = paramsSize2 + 1;
	// paramList2.add(filter.getIsJapanese());
	// }
	// if (filter.getIsPrivateRoomEnabled() != null) {
	// hql1.append(" and isPrivateRoomEnabled = ?");
	// paramsSize2 = paramsSize2 + 1;
	// paramList2.add(filter.getIsPrivateRoomEnabled());
	// }
	// if (filter.getIsSmokeEnable() != null) {
	// hql1.append(" and isSmokeEnable = ?");
	// paramsSize2 = paramsSize2 + 1;
	// paramList2.add(filter.getIsSmokeEnable());
	// }
	// if (filter.getIsWifiSupported() != null) {
	// hql1.append(" and isWifiSupported = ?");
	// paramsSize2 = paramsSize2 + 1;
	// paramList2.add(filter.getIsWifiSupported());
	// }
	// Object[] params2 = new Object[paramsSize2];
	// for (int i = 0; i < paramList2.size(); i++) {
	// Object object = paramList2.get(i);
	// params2[i] = object;
	// }
	// Facility facility = facilityDao.queryByHqlAndParams(
	// hql1.toString(), params2);
	// if (facility != null) {
	// FacilityDto facilityDto = dozerBeanUtil.convert(facility,
	// FacilityDto.class);
	// result.setFacilityDto(facilityDto);
	// } else {
	// result.setFacilityDto(null);
	// }
	//
	// String hql2 = "from Coupon where commId = ?";
	// List<Coupon> coupons = couponDao.findListByParams(hql2,
	// new Object[] { commercial.getCommId() });
	// CouponDto couponDto = null;
	// List<CouponDto> couponDtos = new ArrayList<CouponDto>();
	// for (Coupon coupon : coupons) {
	// couponDto = dozerBeanUtil.convert(coupon, CouponDto.class);
	// couponDtos.add(couponDto);
	// }
	// result.setCouponDtos(couponDtos);
	//
	// String hql3 = "from PictureSet where comm_id = ?";
	// List<PictureSet> pictureSets = pictureSetDao.findListByParams(
	// hql3, new Object[] { commercial.getCommId() });
	// PictureSetDto pictureSetDto = null;
	// List<PictureSetDto> pictureSetDtos = new ArrayList<PictureSetDto>();
	// for (PictureSet pictureSet : pictureSets) {
	// pictureSetDto = dozerBeanUtil.convert(pictureSet,
	// PictureSetDto.class);
	// // TODO 根据路径获取图片的二进制
	// pictureSetDtos.add(pictureSetDto);
	// }
	// result.setPictureSetDtos(pictureSetDtos);
	// commercialDetailDtos.add(result);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// List<CommercialDetailDto> r = new ArrayList<CommercialDetailDto>();
	// for (CommercialDetailDto commercialDetailDto : commercialDetailDtos) {
	// if (commercialDetailDto.getFacilityDto() != null) {
	// r.add(commercialDetailDto);
	// }
	// }
	// return r;
	// }
	// @GET
	// @Path("/getCoupons")
	// @Produces({ "application/json" })
	// @Override
	// public List<CouponDto> getCoupons() {
	// List<CouponDto> result = new ArrayList<CouponDto>();
	// List<Coupon> coupons = couponDao.findAll();
	// CouponDto couponDto = null;
	// Coupon coupon = null;
	// for (int i = 0; i < coupons.size(); i++) {
	// coupon = coupons.get(i);
	// couponDto = dozerBeanUtil.convert(coupon, CouponDto.class);
	// result.add(couponDto);
	// }
	// return result;
	// }

}
