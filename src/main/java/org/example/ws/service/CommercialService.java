package org.example.ws.service;

import javax.ws.rs.core.Response;

/**
 * @author Dijia.Tang
 * 
 */
public interface CommercialService {

	public Response getCommercialDetail(int commercialId);

	public Response getCommercialsByFilters(String region_pname,
			String region_cname, String kind_pname, String kind_cname,
			Integer budget, Boolean isCardSupported, Boolean isSmokeEnable,
			Boolean isWifiSupported, Boolean isJapanese,
			Boolean isIvoiceSupported, Boolean isPrivateRoomEnabled,String keyWord);
}
