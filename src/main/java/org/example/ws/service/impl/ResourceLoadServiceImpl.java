package org.example.ws.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.example.ws.dao.AdvertDao;
import org.example.ws.dao.AssociationDao;
import org.example.ws.dao.KindDao;
import org.example.ws.dao.RegionDao;
import org.example.ws.domain.Advert;
import org.example.ws.domain.Association;
import org.example.ws.domain.Kind;
import org.example.ws.domain.Region;
import org.example.ws.pojo.AdDto;
import org.example.ws.pojo.AdInfoDto;
import org.example.ws.pojo.AssociationDto;
import org.example.ws.pojo.AssociationInfoDto;
import org.example.ws.pojo.CategoryDto;
import org.example.ws.pojo.CategoryInfoDto;
import org.example.ws.pojo.RegionDto;
import org.example.ws.pojo.RegionInfoDto;
import org.example.ws.service.ResourceLoadService;
import org.example.ws.util.CategoryComparator;
import org.example.ws.util.DateUtils;
import org.example.ws.util.ObjectComparator;
import org.example.ws.util.RegionComparator;
import org.springframework.beans.factory.annotation.Autowired;

public class ResourceLoadServiceImpl implements ResourceLoadService {

	@Autowired
	private AdvertDao advertDao;

	@Autowired
	private RegionDao regionDao;
	
	@Autowired
	private KindDao kindDao;
	
	@Autowired
	private AssociationDao associationDao;

	@GET
	@Path("/getAdPageInfo")
	@Produces({ "application/json;charset=utf-8" })
	public Response getAdPageInfo() {
		AdDto adDto = new AdDto();
		List<AdInfoDto> adList = new ArrayList<AdInfoDto>();
		AdInfoDto adInfo = new AdInfoDto();
		List<Advert> advertList = advertDao.findAll();
		for (Advert advert : advertList) {
			adInfo = new AdInfoDto();
			adInfo.setCommId(advert.getCommId());
			adInfo.setUrl(advert.getAdvertImgPath());
			adList.add(adInfo);
		}
		adDto.setAdList(adList);
		adDto.setCount(adList.size());

		Response resp = Response.status(Response.Status.OK).entity(adDto)
				.build();
		return resp;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getRegionListOfFirstLevel")
	@Produces({ "application/json;charset=utf-8" })
	public Response getRegionListOfFirstLevel() {
		RegionDto fieldDto = new RegionDto();
		List<RegionInfoDto> fieldList = new ArrayList<RegionInfoDto>();
		RegionInfoDto fieldInfo = new RegionInfoDto();
		List<Region> regions = regionDao.findAll();

		for (Region region : regions) {
			if (region.getIsParent()) {
				fieldInfo = new RegionInfoDto();
				fieldInfo.setRegionCode(region.getRegionCode());
				fieldInfo.setRegionId(region.getRegionId());
				fieldInfo.setRegionName(region.getRegionName());
				fieldList.add(fieldInfo);
			}
		}
		ObjectComparator comparator = new RegionComparator();
		Collections.sort(fieldList, comparator);
		fieldDto.setFieldList(fieldList);
		fieldDto.setCount(fieldList.size());
		return Response.status(Response.Status.OK).entity(fieldDto).build();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getRegionListOfSecondLevel")
	@Produces({ "application/json;charset=utf-8" })
	public Response getRegionListOfSecondLevel(
			@QueryParam("region_id") Integer region_id) {
		RegionDto fieldDto = new RegionDto();
		
		if (region_id == null) {
			fieldDto.setErrorCode("REQ_PARAM_ERROR");
			fieldDto.setErrorMsg("请求参数错误");
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(fieldDto).build();
		}
				
		List<RegionInfoDto> fieldList = new ArrayList<RegionInfoDto>();
		RegionInfoDto fieldInfo = new RegionInfoDto();
		Region region = regionDao.getObjectById(region_id);
		List<Region> regions = regionDao.findAll();

		if (region == null) {
			fieldDto.setErrorCode("REQ_RESOURCE_NOT_FOUND");
			fieldDto.setErrorMsg("请求资源未找到");
			return Response.status(Response.Status.NOT_FOUND).entity(fieldDto)
					.build();
		}

		int region_id1 = region_id.intValue();

		for (Region region1 : regions) {
			if (region1.getParentId() != null) {
				int region_id2 = region1.getParentId().intValue();
				if (region_id1 == region_id2) {
					fieldInfo = new RegionInfoDto();
					fieldInfo.setRegionId(region1.getRegionId());
					fieldInfo.setRegionName(region1.getRegionName());
					fieldInfo.setRegionCode(region1.getRegionCode());
					fieldList.add(fieldInfo);
				}
			}
		}
		ObjectComparator comparator = new RegionComparator();
		Collections.sort(fieldList, comparator);

		fieldDto.setFieldList(fieldList);
		fieldDto.setCount(fieldList.size());
		return Response.status(Response.Status.OK).entity(fieldDto).build();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getKindListOfSecondLevel")
	@Produces({ "application/json;charset=utf-8" })
	public Response getCategoryListOfSecondLevel(
			@QueryParam("kind_id") Integer kind_id) {
		CategoryDto categoryDto = new CategoryDto();
		
		if (kind_id == null) {
			categoryDto.setErrorCode("REQ_PARAM_ERROR");
			categoryDto.setErrorMsg("请求参数错误");
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(categoryDto).build();
		}
		
		List<CategoryInfoDto> categoryList = new ArrayList<CategoryInfoDto>();
		CategoryInfoDto categoryInfo = new CategoryInfoDto();
		Kind kind = kindDao.getObjectById(kind_id);
		List<Kind> kinds = kindDao.findAll();
		
		if (kind == null) {
			categoryDto.setErrorCode("REQ_RESOURCE_NOT_FOUND");
			categoryDto.setErrorMsg("请求资源未找到");
			return Response.status(Response.Status.NOT_FOUND).entity(categoryDto)
					.build();
		}

		int region_id1 = kind_id.intValue();

		for (Kind kind1 : kinds) {
			if (kind1.getParentId() != null) {
				int region_id2 = kind1.getParentId().intValue();
				if (region_id1 == region_id2) {
					categoryInfo = new CategoryInfoDto();
					categoryInfo.setCategoryId(kind1.getKindId());
					categoryInfo.setCategoryName(kind1.getKindName());
					categoryList.add(categoryInfo);
				}
			}
		}
		ObjectComparator comparator = new CategoryComparator();
		Collections.sort(categoryList, comparator);

		categoryDto.setCategoryList(categoryList);
		categoryDto.setCount(categoryList.size());
		return Response.status(Response.Status.OK).entity(categoryDto).build();
	}

	@Override
	@GET
	@Path("/getAssociationPageInfo")
	@Produces({ "application/json;charset=utf-8" })
	public Response getAssociationPageInfo() {
		AssociationDto assoDto = new AssociationDto();
		List<AssociationInfoDto> assoList = new ArrayList<AssociationInfoDto>();
		AssociationInfoDto assoInfo = new AssociationInfoDto();
		List<Association> associations = associationDao.findAll();
		for(Association association:associations){
			assoInfo = new AssociationInfoDto();
			assoInfo.setActivity(association.getActivity());
			assoInfo.setCreateDate(DateUtils.format(association.getCreateDate()));
			assoInfo.setDetail(association.getActivity());
			assoInfo.setGroupId(association.getGroupId());
			assoInfo.setKind(association.getKind());
			assoInfo.setName(association.getName());
			assoList.add(assoInfo);		
		}

		assoDto.setAssoList(assoList);
		assoDto.setCount(assoList.size());

		Response resp = Response.status(Response.Status.OK).entity(assoDto)
				.build();
		return resp;
	}

}
