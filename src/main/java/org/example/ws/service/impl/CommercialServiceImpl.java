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
import javax.ws.rs.core.Response;

import org.example.ws.dao.CommercialDao;
import org.example.ws.dao.CouponDao;
import org.example.ws.dao.PhoneNumberDao;
import org.example.ws.dao.PictureDao;
import org.example.ws.dao.PictureSetDao;
import org.example.ws.domain.Commercial;
import org.example.ws.domain.Coupon;
import org.example.ws.domain.PhoneNumber;
import org.example.ws.domain.Picture;
import org.example.ws.domain.PictureSet;
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
 * @author Dijia.Tang
 * 
 */
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
	private PhoneNumberDao phoneNumberDao;

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
	@Produces({ "application/json;charset=utf-8" })
	@Override
	public Response getCommercialDetail(
			@QueryParam("commercialId") int commercialId) {
		CommercialDetailResultDto result = new CommercialDetailResultDto();
		// CommercialDetailDto commercialDetailDto = new CommercialDetailDto();
		Commercial commercial = commercialDao.getObjectById(commercialId);
		if (commercial != null) {
			// System.out.println("commercial:->" + commercial.toString());
			CommercialDetailDto commercialDetailDto = dozerBeanUtil.convert(
					commercial, CommercialDetailDto.class);
			// System.out.println("commercialDetailDto:->"
			// + commercialDetailDto.toString());
			// 获取picture URL
			if (commercial.getPictId() != null) {
				Picture picture = pictureDao.getObjectById(commercial
						.getPictId());
				commercialDetailDto.setPictUrl(picture.getFile());
			}
			// 获取电话号码
			String hql = "from PhoneNumber where comm_id = ?";
			List<PhoneNumber> pictureNumbers = phoneNumberDao.findListByParams(
					hql, new Object[] { commercial.getCommId() });
			List<PhoneNumberDto> phoneNumberDtos = new ArrayList<PhoneNumberDto>();
			if (pictureNumbers != null && pictureNumbers.size() != 0) {
				PhoneNumber phoneNumber = null;
				PhoneNumberDto phoneNumberDto = null;
				for (int i = 0; i < pictureNumbers.size(); i++) {
					phoneNumber = pictureNumbers.get(i);
					phoneNumberDto = dozerBeanUtil.convert(phoneNumber,
							PhoneNumberDto.class);
					phoneNumberDtos.add(phoneNumberDto);
				}
			}
			commercialDetailDto.setPhonenumbers(phoneNumberDtos);
			// 获取优惠券
			String hql2 = "from Coupon where commId = ?";
			List<Coupon> coupons = couponDao.findListByParams(hql2,
					new Object[] { commercial.getCommId() });
			List<CouponDto> couponDtos = new ArrayList<CouponDto>();
			if (coupons != null && coupons.size() != 0) {
				Coupon coupon = null;
				CouponDto couponDto = null;
				for (int i = 0; i < coupons.size(); i++) {
					coupon = coupons.get(i);
					couponDto = dozerBeanUtil.convert(coupon, CouponDto.class);
					couponDtos.add(couponDto);
				}
			}
			commercialDetailDto.setCoupons(couponDtos);
			// 获取照片集
			String hql3 = "from PictureSet where comm_id = ?";
			List<PictureSet> pictureSets = pictureSetDao.findListByParams(hql3,
					new Object[] { commercial.getCommId() });
			List<PictureSetDto> pictureSetDtos = new ArrayList<PictureSetDto>();
			if (pictureSets != null && pictureSets.size() != 0) {
				PictureSet pictureSet = null;
				PictureSetDto pictureSetDto = null;
				for (int i = 0; i < pictureSets.size(); i++) {
					pictureSet = pictureSets.get(i);
					pictureSetDto = dozerBeanUtil.convert(pictureSet,
							PictureSetDto.class);
					// 获取数据集中的详细图片
					// ------start------
					String hql4 = "from Picture where pictureSetId = ?";
					List<Picture> pictures = pictureDao.findListByParams(hql4,
							new Object[] { pictureSetDto.getPsId() });
					List<PictureDto> pictureDtos = new ArrayList<PictureDto>();
					if (pictures != null && pictures.size() != 0) {
						Picture picture = null;
						PictureDto pictureDto = null;
						for (int j = 0; j < pictures.size(); j++) {
							picture = pictures.get(j);
							pictureDto = dozerBeanUtil.convert(picture,
									PictureDto.class);
							pictureDtos.add(pictureDto);
						}
					}
					// ------end------
					pictureSetDto.setPictures(pictureDtos);
				}
				pictureSetDtos.add(pictureSetDto);
			}
			commercialDetailDto.setPictureSets(pictureSetDtos);
			result.setCommercialDetailDto(commercialDetailDto);
			result.setCount(1);
			return Response.ok(result).build();
		} else {
			result.setErrorCode("404");
			result.setErrorMsg("NOT FOUND");
			Response response = Response.status(404).build();
			return response;
		}

	}

	@GET
	@Path("/getCommercialsByFilters")
	@Produces({ "application/json;charset=utf-8" })
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
		CommercialSummarysResultDto result = new CommercialSummarysResultDto();
		try {
			List<Object> paramList = new ArrayList<Object>();
			StringBuilder sb = new StringBuilder("from Commercial where 1 = 1 ");
			if (region_pname != null && !region_pname.equals("")) {
				paramList.add(region_pname);
				sb.append(" and region1 = ? ");
			}
			if (region_cname != null && !region_cname.equals("")) {
				paramList.add(region_cname);
				sb.append(" and region2 = ? ");
			}
			if (kind_pname != null && !kind_pname.equals("")) {
				paramList.add(kind_pname);
				sb.append(" and region1 = ? ");
			}
			if (kind_cname != null && !kind_cname.equals("")) {
				paramList.add(kind_cname);
				sb.append(" and region2 = ? ");
			}
			if (budget != null && !budget.equals("")) {
				paramList.add(budget);
				sb.append(" and budget = ? ");
			}
			if (isCardSupported != null && !isCardSupported.equals("")) {
				paramList.add(isCardSupported);
				sb.append(" and isCardSupported = ? ");
			}
			if (isSmokeEnable != null && !isSmokeEnable.equals("")) {
				paramList.add(isSmokeEnable);
				sb.append(" and isSmokeEnable = ? ");
			}
			if (isWifiSupported != null && !isWifiSupported.equals("")) {
				paramList.add(isWifiSupported);
				sb.append(" and isWifiSupported = ? ");
			}
			if (isJapanese != null && !isJapanese.equals("")) {
				paramList.add(isJapanese);
				sb.append(" and isJapanese = ? ");
			}
			if (isIvoiceSupported != null && !isIvoiceSupported.equals("")) {
				paramList.add(isIvoiceSupported);
				sb.append(" and isIvoiceSupported = ? ");
			}
			if (isPrivateRoomEnabled != null
					&& !isPrivateRoomEnabled.equals("")) {
				paramList.add(isPrivateRoomEnabled);
				sb.append(" and isPrivateRoomEnabled = ? ");
			}
			Object[] params = new Object[paramList.size()];
			for (int i = 0; i < paramList.size(); i++) {
				params[i] = paramList.get(i);
			}
			List<Commercial> commercials = commercialDao.findListByParams(
					sb.toString(), params);
			List<CommercialSummaryDto> commercialSummaryDtos = new ArrayList<CommercialSummaryDto>();
			Commercial commercial = null;
			CommercialSummaryDto commercialSummaryDto = null;
			for (int j = 0; j < commercials.size(); j++) {
				commercial = commercials.get(j);
				commercialSummaryDto = dozerBeanUtil.convert(commercial,
						CommercialSummaryDto.class);
				// System.out.println(commercialSummaryDto.toString());
				// 获取picture URL
				if (commercial.getPictId() != null) {
					Picture picture = pictureDao.getObjectById(commercial
							.getPictId());
					commercialSummaryDto.setPictUrl(picture.getFile());
				}
				// 获取电话号码
				String hql = "from PhoneNumber where comm_id = ?";
				List<PhoneNumber> pictureNumbers = phoneNumberDao
						.findListByParams(hql,
								new Object[] { commercial.getCommId() });
				List<PhoneNumberDto> phoneNumberDtos = new ArrayList<PhoneNumberDto>();
				if (pictureNumbers != null && pictureNumbers.size() != 0) {
					PhoneNumber phoneNumber = null;
					PhoneNumberDto phoneNumberDto = null;
					for (int i = 0; i < pictureNumbers.size(); i++) {
						phoneNumber = pictureNumbers.get(i);
						phoneNumberDto = dozerBeanUtil.convert(phoneNumber,
								PhoneNumberDto.class);
						phoneNumberDtos.add(phoneNumberDto);
					}
				}
				commercialSummaryDto.setPhonenumbers(phoneNumberDtos);

				// 获取优惠券
				String hql2 = "from Coupon where commId = ?";
				List<Coupon> coupons = couponDao.findListByParams(hql2,
						new Object[] { commercial.getCommId() });
				List<CouponDto> couponDtos = new ArrayList<CouponDto>();
				if (coupons != null && coupons.size() != 0) {
					Coupon coupon = null;
					CouponDto couponDto = null;
					for (int i = 0; i < coupons.size(); i++) {
						coupon = coupons.get(i);
						couponDto = dozerBeanUtil.convert(coupon,
								CouponDto.class);
						couponDtos.add(couponDto);
					}
				}
				commercialSummaryDto.setCoupons(couponDtos);
				commercialSummaryDtos.add(commercialSummaryDto);
			}
			result.setCommercialSummarys(commercialSummaryDtos);
			result.setCount(commercialSummaryDtos.size());
			return Response.ok(result).build();
		} catch (Exception e) {
			e.printStackTrace();
			result.setErrorCode("500");
			result.setErrorMsg("Get Failed");
			Response response = Response.status(500).build();
			return response;
		}

	}
}
