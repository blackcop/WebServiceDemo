/**
 * 
 */
package org.example.ws.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.example.ws.bean.Commercial;
import org.example.ws.bean.Coupon;
import org.example.ws.bean.Facility;
import org.example.ws.bean.Picture;
import org.example.ws.bean.PictureSet;
import org.example.ws.dao.CommercialDao;
import org.example.ws.dao.CouponDao;
import org.example.ws.dao.FacilityDao;
import org.example.ws.dao.PictureDao;
import org.example.ws.dao.PictureSetDao;
import org.example.ws.pojo.CommercialDetailDto;
import org.example.ws.pojo.CommercialDto;
import org.example.ws.pojo.CouponDto;
import org.example.ws.pojo.FacilityDto;
import org.example.ws.pojo.FilterDto;
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

	@POST
	@Path("/publishCoupon")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Override
	public Response publishCoupon(CouponDto couponDto) {
		try {
			System.out.println("publishCoupon");
			System.out.println(couponDto.toString());
			Coupon coupon = dozerBeanUtil.convert(couponDto, Coupon.class);
			couponDao.save(coupon);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Path("/getDetail")
	@Produces({ "application/json" })
	@Override
	public CommercialDetailDto getDetail(
			@QueryParam("commercialId") int commercialId) {
		CommercialDetailDto result = new CommercialDetailDto();
		try {
			System.out.println("getDetail");

			Commercial commercial = commercialDao.getObjectById(commercialId);
			CommercialDto commercialDto = dozerBeanUtil.convert(commercial,
					CommercialDto.class);
			result.setCommercialDto(commercialDto);

			if (commercial.getPictId() != null
					&& !commercial.getPictId().equals("")) {
				Picture picture = pictureDao.getObjectById(commercial
						.getPictId());
				PictureDto pictureDto = dozerBeanUtil.convert(picture,
						PictureDto.class);
				// TODO 根据路径获取图片的二进制
				result.setPictureDto(pictureDto);
			}

			String hql1 = "from Facility where commId = ?";
			Facility facility = facilityDao.queryByHqlAndParams(hql1,
					new Object[] { commercialId });
			FacilityDto facilityDto = dozerBeanUtil.convert(facility,
					FacilityDto.class);
			result.setFacilityDto(facilityDto);

			String hql2 = "from Coupon where commId = ?";
			List<Coupon> coupons = couponDao.findListByParams(hql2,
					new Object[] { commercialId });
			CouponDto couponDto = null;
			List<CouponDto> couponDtos = new ArrayList<CouponDto>();
			for (Coupon coupon : coupons) {
				couponDto = dozerBeanUtil.convert(coupon, CouponDto.class);
				couponDtos.add(couponDto);
			}
			result.setCouponDtos(couponDtos);

			String hql3 = "from PictureSet where comm_id = ?";
			List<PictureSet> pictureSets = pictureSetDao.findListByParams(hql3,
					new Object[] { commercialId });
			PictureSetDto pictureSetDto = null;
			List<PictureSetDto> pictureSetDtos = new ArrayList<PictureSetDto>();
			for (PictureSet pictureSet : pictureSets) {
				pictureSetDto = dozerBeanUtil.convert(pictureSet,
						PictureSetDto.class);
				// TODO 根据路径获取图片的二进制
				pictureSetDtos.add(pictureSetDto);
			}
			result.setPictureSetDtos(pictureSetDtos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@GET
	@Path("/getPictureSetDetail")
	@Produces({ "application/json" })
	@Override
	public List<PictureDto> getPictureSetDetail(
			@QueryParam("commercialId") int pictureSetId) {
		List<PictureDto> pictureDtos = new ArrayList<PictureDto>();
		try {
			String hql = "from Picture where pictureSetId = ?";
			List<Picture> pictures = pictureDao.findListByParams(hql,
					new Object[] { pictureSetId });
			PictureDto pictureDto;
			for (Picture picture : pictures) {
				pictureDto = dozerBeanUtil.convert(picture, PictureDto.class);
				pictureDtos.add(pictureDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pictureDtos;
	}

	@GET
	@Path("/filterCommercial")
	@Produces({ "application/json" })
	@Consumes({ MediaType.APPLICATION_JSON })
	@Override
	public List<CommercialDetailDto> filterCommercial(FilterDto filter) {
		try {
			StringBuilder hql = new StringBuilder(
					"from Commercial where 1 = 1 ");
			List<Object> paramList = new ArrayList<Object>();
			int paramsSize = 0;
			if (filter.getKind1() != null) {
				hql.append(" and kind1 = ? ");
				paramsSize = paramsSize + 1;
				paramList.add(filter.getKind1());
			}
			if (filter.getKind2() != null) {
				hql.append(" and kind2 = ? ");
				paramsSize = paramsSize + 1;
				paramList.add(filter.getKind2());
			}
			if (filter.getRegion1() != null) {
				hql.append(" and region1 = ? ");
				paramsSize = paramsSize + 1;
				paramList.add(filter.getRegion1());
			}
			if (filter.getRegion2() != null) {
				hql.append(" and region2 = ? ");
				paramsSize = paramsSize + 1;
				paramList.add(filter.getRegion2());
			}
			if (filter.getBudget1() != null) {
				hql.append(" and budget > ? ");
				paramsSize = paramsSize + 1;
				paramList.add(filter.getBudget1());
			}
			if (filter.getBudget2() != null) {
				hql.append(" and budget < ? ");
				paramsSize = paramsSize + 1;
				paramList.add(filter.getBudget2());
			}
			if (filter.getKey() != null) {
				hql.append(" and (name like %?% or address like %?% )");
				paramsSize = paramsSize + 2;
				paramList.add(filter.getKey());
				paramList.add(filter.getKey());
			}
			Object[] params = new Object[paramsSize];
			for (int i = 0; i < paramList.size(); i++) {
				Object object = paramList.get(i);
				params[i] = object;
			}
			List<Commercial> commercials = commercialDao.findListByParams(
					hql.toString(), params);
			for (Commercial commercial : commercials) {
				CommercialDto commercialDto = dozerBeanUtil.convert(commercial,
						CommercialDto.class);
				CommercialDetailDto result = new CommercialDetailDto();
				result.setCommercialDto(commercialDto);

				if (commercial.getPictId() != null
						&& !commercial.getPictId().equals("")) {
					Picture picture = pictureDao.getObjectById(commercial
							.getPictId());
					PictureDto pictureDto = dozerBeanUtil.convert(picture,
							PictureDto.class);
					// TODO 根据路径获取图片的二进制
					result.setPictureDto(pictureDto);
				}

				StringBuilder hql1 = new StringBuilder(
						"from Facility where commId = ? ");
				List<Object> paramList2 = new ArrayList<Object>();
				paramList2.add(commercial.getCommId());
				int paramsSize2 = 1;
				if (filter.getIsCardSupported() != null) {
					hql1.append(" and isCardSupported = ?");
					paramsSize2 = paramsSize2 + 1;
					paramList2.add(filter.getIsCardSupported());
				}
				if (filter.getIsIvoiceSupported() != null) {
					hql1.append(" and isIvoiceSupported = ?");
					paramsSize2 = paramsSize2 + 1;
					paramList2.add(filter.getIsIvoiceSupported());
				}
				if (filter.getIsJapanese() != null) {
					hql1.append(" and isJapanese = ?");
					paramsSize2 = paramsSize2 + 1;
					paramList2.add(filter.getIsJapanese());
				}
				if (filter.getIsPrivateRoomEnabled() != null) {
					hql1.append(" and isPrivateRoomEnabled = ?");
					paramsSize2 = paramsSize2 + 1;
					paramList2.add(filter.getIsPrivateRoomEnabled());
				}
				if (filter.getIsSmokeEnable() != null) {
					hql1.append(" and isSmokeEnable = ?");
					paramsSize2 = paramsSize2 + 1;
					paramList2.add(filter.getIsSmokeEnable());
				}
				if (filter.getIsWifiSupported() != null) {
					hql1.append(" and isWifiSupported = ?");
					paramsSize2 = paramsSize2 + 1;
					paramList2.add(filter.getIsWifiSupported());
				}
				Object[] params2 = new Object[paramsSize2];
				for (int i = 0; i < paramList2.size(); i++) {
					Object object = paramList2.get(i);
					params2[i] = object;
				}
				Facility facility = facilityDao.queryByHqlAndParams(
						hql1.toString(), params2);
				FacilityDto facilityDto = dozerBeanUtil.convert(facility,
						FacilityDto.class);
				result.setFacilityDto(facilityDto);

				String hql2 = "from Coupon where commId = ?";
				List<Coupon> coupons = couponDao.findListByParams(hql2,
						new Object[] { commercial.getCommId() });
				CouponDto couponDto = null;
				List<CouponDto> couponDtos = new ArrayList<CouponDto>();
				for (Coupon coupon : coupons) {
					couponDto = dozerBeanUtil.convert(coupon, CouponDto.class);
					couponDtos.add(couponDto);
				}
				result.setCouponDtos(couponDtos);

				String hql3 = "from PictureSet where comm_id = ?";
				List<PictureSet> pictureSets = pictureSetDao.findListByParams(
						hql3, new Object[] { commercial.getCommId() });
				PictureSetDto pictureSetDto = null;
				List<PictureSetDto> pictureSetDtos = new ArrayList<PictureSetDto>();
				for (PictureSet pictureSet : pictureSets) {
					pictureSetDto = dozerBeanUtil.convert(pictureSet,
							PictureSetDto.class);
					// TODO 根据路径获取图片的二进制
					pictureSetDtos.add(pictureSetDto);
				}
				result.setPictureSetDtos(pictureSetDtos);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
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
