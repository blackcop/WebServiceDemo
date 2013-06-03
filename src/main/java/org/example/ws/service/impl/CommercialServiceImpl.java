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
import org.example.ws.dao.KindDao;
import org.example.ws.dao.PhoneNumberDao;
import org.example.ws.dao.PictureDao;
import org.example.ws.dao.PictureSetDao;
import org.example.ws.dao.RegionDao;
import org.example.ws.domain.Commercial;
import org.example.ws.domain.Coupon;
import org.example.ws.domain.Kind;
import org.example.ws.domain.PhoneNumber;
import org.example.ws.domain.Picture;
import org.example.ws.domain.PictureSet;
import org.example.ws.domain.Region;
import org.example.ws.pojo.CommercialDetailDto;
import org.example.ws.pojo.CommercialDetailResultDto;
import org.example.ws.pojo.CommercialSummaryDto;
import org.example.ws.pojo.CommercialSummarysResultDto;
import org.example.ws.pojo.CouponDto;
import org.example.ws.pojo.CouponsDto;
import org.example.ws.pojo.PhoneNumberDto;
import org.example.ws.pojo.PhoneNumbersDto;
import org.example.ws.pojo.PictureDto;
import org.example.ws.pojo.PictureSetDto;
import org.example.ws.pojo.PictureSetsDto;
import org.example.ws.pojo.PicturesDto;
import org.example.ws.service.CommercialService;
import org.example.ws.util.DateUtils;
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
	private KindDao kindDao;

	@Autowired
	private RegionDao regionDao;

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
		try {
			// CommercialDetailDto commercialDetailDto = new
			// CommercialDetailDto();
			Commercial commercial = commercialDao.getObjectById(commercialId);
			if (commercial != null) {
				// System.out.println("commercial:->" + commercial.toString());
				CommercialDetailDto commercialDetailDto = dozerBeanUtil
						.convert(commercial, CommercialDetailDto.class);
				commercialDetailDto.setBudget("￥"
						+ commercial.getBudget().toString());
				if (commercial.getKindId() != null) {
					Kind kind2 = kindDao.getObjectById(commercial.getKindId());
					commercialDetailDto.setKind2(kind2.getKindName());
					Kind kind1 = kindDao.getObjectById(kind2.getParentId());
					commercialDetailDto.setKind1(kind1.getKindName());
				} else {
					commercialDetailDto.setKind1("");
					commercialDetailDto.setKind2("");
				}
				if (commercial.getRegionId() != null) {
					Region region2 = regionDao.getObjectById(commercial
							.getRegionId());
					commercialDetailDto.setRegion2(region2.getRegionName());
					Region region1 = regionDao.getObjectById(region2
							.getParentId());
					commercialDetailDto.setRegion1(region1.getRegionName());
				} else {
					commercialDetailDto.setRegion1("");
					commercialDetailDto.setRegion2("");
				}
				// System.out.println("commercialDetailDto:->"
				// + commercialDetailDto.toString());
				// get picture URL
				if (commercial.getPictId() != null) {
					Picture picture = pictureDao.getObjectById(commercial
							.getPictId());
					commercialDetailDto.setPictUrl(picture.getFile());
				} else {
					commercialDetailDto.setPictUrl("");
				}
				// get phone number
				PhoneNumbersDto phoneNumberListDto = getPhoneNumbersDtoByCommercialId(commercial
						.getCommId());
				commercialDetailDto.setPhoneNumbersDto(phoneNumberListDto);

				// get coupons
				CouponsDto couponsDto = getCouponsDtoByCommercialId(commercial
						.getCommId());
				commercialDetailDto.setCouponsDto(couponsDto);

				// get picture set
				String hql3 = "from PictureSet where commId = ?";
				List<PictureSet> pictureSets = pictureSetDao.findListByParams(
						hql3, new Object[] { commercial.getCommId() });
				List<PictureSetDto> pictureSetDtos = new ArrayList<PictureSetDto>();
				if (pictureSets != null && pictureSets.size() != 0) {
					PictureSet pictureSet = null;
					PictureSetDto pictureSetDto = null;
					for (int i = 0; i < pictureSets.size(); i++) {
						pictureSet = pictureSets.get(i);
						pictureSetDto = dozerBeanUtil.convert(pictureSet,
								PictureSetDto.class);
						// get the pictures in picture set
						// ------start------
						String hql4 = "from Picture where pictureSetId = ?";
						List<Picture> pictures = pictureDao.findListByParams(
								hql4, new Object[] { pictureSet.getPsId() });
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
						PicturesDto picturesDto = new PicturesDto();
						picturesDto.setPictureList(pictureDtos);
						picturesDto.setCount(pictureDtos.size());
						pictureSetDto.setPicturesDto(picturesDto);
						//
						pictureSetDtos.add(pictureSetDto);
					}
				}
				PictureSetsDto pictureSetDto = new PictureSetsDto();
				pictureSetDto.setPicturesetList(pictureSetDtos);
				pictureSetDto.setCount(pictureSetDtos.size());
				commercialDetailDto.setPictureSetsDto(pictureSetDto);
				result.setCommercialDetailDto(commercialDetailDto);
				result.setCount(1);
				return Response.ok(result).build();
			} else {
				result.setErrorCode("404");
				result.setErrorMsg("NOT FOUND.");
				return Response.status(Response.Status.NOT_FOUND)
						.entity(result).build();
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			result.setErrorCode("500");
			result.setErrorMsg("Param type is error.");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(result).build();
		} catch (Exception e2) {
			e2.printStackTrace();
			result.setErrorCode("500");
			result.setErrorMsg("Get Failed.");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(result).build();
		}
	}

	@GET
	@Path("/getCommercialsByFilters")
	@Produces({ "application/json;charset=utf-8" })
	@Override
	public Response getCommercialsByFilters(
			@QueryParam("region_id") String region_id,
			@QueryParam("kind_id") String kind_id,
			@QueryParam("budget") String budget,
			@QueryParam("isCardSupported") Boolean isCardSupported,
			@QueryParam("isSmokeEnable") Boolean isSmokeEnable,
			@QueryParam("isWifiSupported") Boolean isWifiSupported,
			@QueryParam("isJapanese") Boolean isJapanese,
			@QueryParam("isIvoiceSupported") Boolean isIvoiceSupported,
			@QueryParam("isPrivateRoomEnabled") Boolean isPrivateRoomEnabled,
			@QueryParam("keyWord") String keyWord,
			@QueryParam("latitude") Double latitude,
			@QueryParam("longitude") Double longitude) {
		CommercialSummarysResultDto result = new CommercialSummarysResultDto();
		try {
			List<Object> paramList = new ArrayList<Object>();
			StringBuilder sb = new StringBuilder("from Commercial where 1 = 1 ");
			if (region_id != null && !region_id.equals("")) {
				paramList.add(Integer.valueOf(region_id));
				sb.append(" and regionId = ? ");
			}
			if (kind_id != null && !kind_id.equals("")) {
				String[] kind_ids = kind_id.split(",");
				for (int i = 0; i < kind_ids.length; i++) {
					paramList.add(Integer.valueOf(kind_ids[i]));
					if (i == 0) {
						sb.append(" and kindId = ? ");
					} else {
						sb.append(" or kindId = ? ");
					}
				}
			}
			if (budget != null && !budget.equals("")) {
				String[] budgets = budget.split(",");
				for (int i = 0; i < budgets.length; i++) {
					Integer min_budget = 0;
					Integer max_budget = 0;
					if (budgets[i].equals("1")) {
						min_budget = 30;
						max_budget = 50;
					} else if (budgets[i].equals("2")) {
						min_budget = 50;
						max_budget = 80;
					} else if (budgets[i].equals("3")) {
						min_budget = 80;
						max_budget = 120;
					} else if (budgets[i].equals("4")) {
						min_budget = 120;
						max_budget = 200;
					} else if (budgets[i].equals("5")) {
						min_budget = 200;
						max_budget = 300;
					} else if (budgets[i].equals("6")) {
						min_budget = 300;
						max_budget = 500;
					} else if (budgets[i].equals("7")) {
						min_budget = 500;
						max_budget = Integer.MAX_VALUE;
					} else {
						result.setErrorCode("404");
						result.setErrorMsg("the param budget is out of bounds.");
						return Response.status(Response.Status.NOT_FOUND)
								.entity(result).build();
					}
					paramList.add(min_budget);
					paramList.add(max_budget);
					if (i == 0) {
						sb.append(" and ( budget >= ? and budget <= ? )");
					} else {
						sb.append(" or ( budget >= ? and budget <= ? )");
					}
				}
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
			if (keyWord != null && !keyWord.trim().equals("")) {
				StringBuilder keyWordSB = new StringBuilder();
				keyWordSB.append("%");
				keyWordSB.append(keyWord);
				keyWordSB.append("%");
				paramList.add(keyWordSB.toString().trim());
				paramList.add(keyWordSB.toString().trim());
				sb.append(" and (name like ? or address like ?)");
			}

			if (latitude != null && longitude != null) {
				//
				Double minLatitude = latitude - 0.1;
				Double maxLatitude = latitude + 0.1;
				Double minLongitude = longitude - 0.1;
				Double maxLongitude = longitude + 0.1;
				paramList.add(minLatitude);
				paramList.add(maxLatitude);
				paramList.add(minLongitude);
				paramList.add(maxLongitude);
				sb.append(" and ( latitude >= ? and latitude <= ? )");
				sb.append(" and ( longitude >= ? and longitude <= ? )");
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
				commercialSummaryDto.setBudget("￥"
						+ commercial.getBudget().toString());
				if (commercial.getKindId() != null) {
					Kind kind2 = kindDao.getObjectById(commercial.getKindId());
					commercialSummaryDto.setKind2(kind2.getKindName());
					Kind kind1 = kindDao.getObjectById(kind2.getParentId());
					commercialSummaryDto.setKind1(kind1.getKindName());
				} else {
					commercialSummaryDto.setKind1("");
					commercialSummaryDto.setKind2("");
				}
				if (commercial.getRegionId() != null) {
					Region region2 = regionDao.getObjectById(commercial
							.getRegionId());
					commercialSummaryDto.setRegion2(region2.getRegionName());
					Region region1 = regionDao.getObjectById(region2
							.getParentId());
					commercialSummaryDto.setRegion1(region1.getRegionName());
				} else {
					commercialSummaryDto.setRegion1("");
					commercialSummaryDto.setRegion2("");
				}

				// System.out.println(commercialSummaryDto.toString());
				// get picture URL
				if (commercial.getPictId() != null) {
					Picture picture = pictureDao.getObjectById(commercial
							.getPictId());
					commercialSummaryDto.setPictUrl(picture.getFile());
				} else {
					commercialSummaryDto.setPictUrl("");
				}

				// get phone number
				PhoneNumbersDto phoneNumberListDto = getPhoneNumbersDtoByCommercialId(commercial
						.getCommId());
				commercialSummaryDto.setPhoneNumbersDto(phoneNumberListDto);

				// get coupon
				CouponsDto couponsDto = getCouponsDtoByCommercialId(commercial
						.getCommId());
				commercialSummaryDto.setCouponsDto(couponsDto);

				//
				commercialSummaryDtos.add(commercialSummaryDto);
			}
			result.setCommercialSummarys(commercialSummaryDtos);
			result.setCount(commercialSummaryDtos.size());
			return Response.ok(result).build();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			result.setErrorCode("500");
			result.setErrorMsg("Param type is error.");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(result).build();
		} catch (Exception e2) {
			e2.printStackTrace();
			result.setErrorCode("500");
			result.setErrorMsg("Get Failed");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(result).build();
		}
	}

	/**
	 * 根据商铺ID，获取商铺的电话号码
	 * 
	 * @param commercial_id
	 * @return
	 */
	private PhoneNumbersDto getPhoneNumbersDtoByCommercialId(
			Integer commercial_id) {
		String hql = "from PhoneNumber where commId = ?";
		List<PhoneNumber> pictureNumbers = phoneNumberDao.findListByParams(hql,
				new Object[] { commercial_id });
		List<PhoneNumberDto> phoneNumberDtoList = new ArrayList<PhoneNumberDto>();
		if (pictureNumbers != null && pictureNumbers.size() != 0) {
			PhoneNumber phoneNumber = null;
			PhoneNumberDto phoneNumberDto = null;
			for (int i = 0; i < pictureNumbers.size(); i++) {
				phoneNumber = pictureNumbers.get(i);
				phoneNumberDto = dozerBeanUtil.convert(phoneNumber,
						PhoneNumberDto.class);
				if (phoneNumberDto.getPhoneDesc() == null) {
					phoneNumberDto.setPhoneDesc("");
				}
				phoneNumberDtoList.add(phoneNumberDto);
			}
		}
		PhoneNumbersDto phoneNumberListDto = new PhoneNumbersDto();
		phoneNumberListDto.setPhonenumberList(phoneNumberDtoList);
		phoneNumberListDto.setCount(phoneNumberDtoList.size());
		return phoneNumberListDto;
	}

	/**
	 * 根据商铺ID，获取商铺的的优惠券
	 * 
	 * @param commercial_id
	 * @return
	 */
	private CouponsDto getCouponsDtoByCommercialId(Integer commercial_id) {
		String hql2 = "from Coupon where commId = ?";
		List<Coupon> coupons = couponDao.findListByParams(hql2,
				new Object[] { commercial_id });
		List<CouponDto> couponDtos = new ArrayList<CouponDto>();
		if (coupons != null && coupons.size() != 0) {
			Coupon coupon = null;
			CouponDto couponDto = null;
			for (int i = 0; i < coupons.size(); i++) {
				coupon = coupons.get(i);
				couponDto = dozerBeanUtil.convert(coupon, CouponDto.class);
				couponDto.setBeginDateStr(DateUtils.format(couponDto.getBeginDate()));
				couponDto.setEndDateStr(DateUtils.format(couponDto.getEndDate()));
				couponDto.setBeginDate(null);
				couponDto.setEndDate(null);
				if (coupon.getPictureId() != null) {
					Picture picture = pictureDao.getObjectById(coupon
							.getPictureId());
					couponDto.setPicture_url(picture.getFile());
				} else {
					couponDto.setPicture_url("");
				}
				couponDtos.add(couponDto);
			}
		}
		CouponsDto couponsDto = new CouponsDto();
		couponsDto.setCouponList(couponDtos);
		couponsDto.setCount(couponDtos.size());
		return couponsDto;
	}
}
