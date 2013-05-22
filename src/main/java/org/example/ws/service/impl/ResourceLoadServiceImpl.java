package org.example.ws.service.impl;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.example.ws.pojo.AdDto;
import org.example.ws.pojo.AdInfoDto;
import org.example.ws.service.ResourceLoadService;

@Path("")
public class ResourceLoadServiceImpl implements ResourceLoadService{

	@GET
	@Path("/getAdPageInfo")
	@Produces({ "application/json" })
	public Response GetAdPageInfo() {
		AdDto adDto = new AdDto();
		ArrayList<AdInfoDto> adList = new ArrayList<AdInfoDto>();
		AdInfoDto adInfo = new AdInfoDto();
		adInfo.setCommId("10001");
		adInfo.setUrl("http://t2.dpfile.com/tuan/20130506/209823_130123300260000000.jpg");
		adList.add(adInfo);
		adInfo = new AdInfoDto();
		adInfo.setCommId("10002");
		adInfo.setUrl("http://t1.dpfile.com/tuan/20130403/184213_130094622240000000_8274.jpg");
		adList.add(adInfo);
		adDto.setAdList(adList);
		adDto.setCount(adList.size());
		
		Response resp = Response.status(Response.Status.OK).entity(adDto).build();
		return resp;
	}

}
