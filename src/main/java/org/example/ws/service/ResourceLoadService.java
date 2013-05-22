package org.example.ws.service;

import javax.ws.rs.core.Response;

public interface ResourceLoadService {
	
	/**
	 * 获取广告页信息
	 * @return
	 */
	public Response getAdPageInfo();
	
	/**
	 * 获取一级地域信息
	 * @return
	 */
	public Response getRegionListOfFirstLevel();
	
	/**
	 * 获取二级地域信息
	 * @param fieldId
	 * @return
	 */
	public Response getRegionListOfSecondLevel(Integer fieldId);
	
	/**
	 * 获取二级类别信息
	 * @param categoryId
	 * @return
	 */
	public Response getCategoryListOfSecondLevel(Integer categoryId);
	
	/**
	 * 获取同乡会信息
	 * @return
	 */
	public Response getAssociationPageInfo();
}
