package org.example.ws.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.example.ws.bean.Picture;
import org.example.ws.dao.PictureDao;
import org.example.ws.pojo.AdDto;
import org.example.ws.pojo.AdInfoDto;
import org.example.ws.pojo.AssociationDto;
import org.example.ws.pojo.AssociationInfoDto;
import org.example.ws.pojo.CategoryDto;
import org.example.ws.pojo.CategoryInfoDto;
import org.example.ws.pojo.RegionDto;
import org.example.ws.pojo.RegionInfoDto;
import org.example.ws.service.ResourceLoadService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("")
public class ResourceLoadServiceImpl implements ResourceLoadService{

	
	@Autowired
	private PictureDao pictureDao;

	
	
	@GET
	@Path("/getAdPageInfo")
	@Produces({ "application/json;charset=utf-8" })
	public Response getAdPageInfo() {
		AdDto adDto = new AdDto();
		List<AdInfoDto> adList = new ArrayList<AdInfoDto>();
		AdInfoDto adInfo = new AdInfoDto();

	/*	Picture picture = pictureDao.getObjectById(coupon
				.getPictureId());
		recomdInfo.setPicUrl(picture.getFile());*/
		
		
		
		
		
		/*adInfo.setCommId("\1");
		adInfo.setUrl("http:\t2.dpfile.com/tuan/20130506/209823_130123300260000000.jpg");
		adList.add(adInfo);
		adInfo = new AdInfoDto();
		adInfo.setCommId("2");
		adInfo.setUrl("http://t1.dpfile.com/tuan/20130403/184213_130094622240000000_8274.jpg");
		adList.add(adInfo);*/
		adDto.setAdList(adList);
		adDto.setCount(adList.size());
		
		Response resp = Response.status(Response.Status.OK).entity(adDto).build();
		return resp;
	}

	@Override
	@GET
	@Path("/getRegionListOfFirstLevel")
	@Produces({ "application/json" })
	public Response getRegionListOfFirstLevel() {
		RegionDto fieldDto = new RegionDto();
		List<RegionInfoDto> fieldList = new ArrayList<RegionInfoDto>();
		RegionInfoDto fieldInfo = new RegionInfoDto();
		fieldInfo.setRegionId("1");
		fieldInfo.setRegionName("北京地区");
		fieldList.add(fieldInfo);
		
		fieldInfo = new RegionInfoDto();
		fieldInfo.setRegionId("2");
		fieldInfo.setRegionName("周边地区");
		fieldList.add(fieldInfo);
		
		fieldDto.setFieldList(fieldList);
		fieldDto.setCount(fieldList.size());
		return Response.status(Response.Status.OK).entity(fieldDto).build();
	}

	@Override
	@GET
	@Path("/getRegionListOfSecondLevel")
	@Produces({ "application/json" })
	public Response getRegionListOfSecondLevel(@QueryParam("region_id") Integer regionId) {
		RegionDto fieldDto = new RegionDto();
		if(regionId == null){
			fieldDto.setErrorCode("REQ_PARAM_ERROR");
			fieldDto.setErrorMsg("请求参数错误");
			return Response.status(Response.Status.BAD_REQUEST).entity(fieldDto).build();
		}
		if(regionId == 1){
			List<RegionInfoDto> fieldList = new ArrayList<RegionInfoDto>();
			RegionInfoDto fieldInfo = new RegionInfoDto();
			fieldInfo.setRegionId("1");
			fieldInfo.setRegionName("朝阳区");
			fieldList.add(fieldInfo);
			
			fieldInfo = new RegionInfoDto();
			fieldInfo.setRegionId("2");
			fieldInfo.setRegionName("房山区");
			fieldList.add(fieldInfo);
			
			fieldDto.setFieldList(fieldList);
			fieldDto.setCount(fieldList.size());
			return Response.status(Response.Status.OK).entity(fieldDto).build();
		} else if(regionId == 2){
			List<RegionInfoDto> fieldList = new ArrayList<RegionInfoDto>();
			RegionInfoDto fieldInfo = new RegionInfoDto();
			fieldInfo.setRegionId("3");
			fieldInfo.setRegionName("石家庄");
			fieldList.add(fieldInfo);
			
			fieldInfo = new RegionInfoDto();
			fieldInfo.setRegionId("4");
			fieldInfo.setRegionName("廊坊");
			fieldList.add(fieldInfo);
			
			fieldDto.setFieldList(fieldList);
			fieldDto.setCount(fieldList.size());
			return Response.status(Response.Status.OK).entity(fieldDto).build();
		} else{
			fieldDto.setErrorCode("REQ_RESOURCE_NOT_FOUND");
			fieldDto.setErrorMsg("请求资源未找到");
			return Response.status(Response.Status.NOT_FOUND).entity(fieldDto).build();
		}
	}

	@Override
	@GET
	@Path("/getKindListOfSecondLevel")
	@Produces({ "application/json" })
	public Response getCategoryListOfSecondLevel(@QueryParam("kind_id") Integer categoryId) {
		CategoryDto categoryDto = new CategoryDto();
		if(categoryId == null){
			categoryDto.setErrorCode("REQ_PARAM_ERROR");
			categoryDto.setErrorMsg("请求参数错误");
			return Response.status(Response.Status.BAD_REQUEST).entity(categoryDto).build();
		}
		if(categoryId == 1){
			List<CategoryInfoDto> categoryList = new ArrayList<CategoryInfoDto>();
			CategoryInfoDto categoryInfo = new CategoryInfoDto();
			categoryInfo.setCategoryId("1");
			categoryInfo.setCategoryName("日本料理");
			categoryList.add(categoryInfo);
			
			categoryInfo = new CategoryInfoDto();
			categoryInfo.setCategoryId("2");
			categoryInfo.setCategoryName("中华料理");
			categoryList.add(categoryInfo);
			
			categoryDto.setCategoryList(categoryList);
			categoryDto.setCount(categoryList.size());
			return Response.status(Response.Status.OK).entity(categoryDto).build();
		} else if(categoryId == 2){
			List<CategoryInfoDto> categoryList = new ArrayList<CategoryInfoDto>();
			categoryDto.setCategoryList(categoryList);
			categoryDto.setCount(categoryList.size());
			return Response.status(Response.Status.OK).entity(categoryDto).build();
		} else if(categoryId == 3){
			List<CategoryInfoDto> categoryList = new ArrayList<CategoryInfoDto>();
			categoryDto.setCategoryList(categoryList);
			categoryDto.setCount(categoryList.size());
			return Response.status(Response.Status.OK).entity(categoryDto).build();
		} else{
			categoryDto.setErrorCode("REQ_RESOURCE_NOT_FOUND");
			categoryDto.setErrorMsg("请求资源未找到");
			return Response.status(Response.Status.NOT_FOUND).entity(categoryDto).build();
		}
	}

	@Override
	@GET
	@Path("/getAssociationPageInfo")
	@Produces({ "application/json" })
	public Response getAssociationPageInfo() {
		AssociationDto assoDto = new AssociationDto();
		List<AssociationInfoDto> assoList = new ArrayList<AssociationInfoDto>();
		AssociationInfoDto assoInfo = new AssociationInfoDto();
		assoInfo.setActivity("同学聚会");
		assoInfo.setCreateDate(new Date());
		assoInfo.setDetail("同学聚会同学聚会同学聚会同学聚会同学聚会同学聚会");
		assoInfo.setGroupId(10001);
		assoInfo.setKind("同学会");
		assoInfo.setName("同学聚会");
		assoList.add(assoInfo);
		
		assoInfo = new AssociationInfoDto();
		assoInfo.setActivity("同乡聚会");
		assoInfo.setCreateDate(new Date());
		assoInfo.setDetail("同乡同乡同乡同乡同乡同乡同乡同乡同乡同乡同乡");
		assoInfo.setGroupId(10002);
		assoInfo.setKind("同乡会");
		assoInfo.setName("同乡聚会");
		assoList.add(assoInfo);
		
		assoDto.setAssoList(assoList);
		assoDto.setCount(assoList.size());
		
		Response resp = Response.status(Response.Status.OK).entity(assoDto).build();
		return resp;
	}

}
