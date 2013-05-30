package org.example.ws.service;

import javax.ws.rs.core.Response;

/**
 * @author Dijia.Tang
 * 
 */
public interface CommercialService {

	public Response getCommercialDetail(int commercialId);

	public Response getCommercialsByFilters(String region_id, String kind_id,
			String budget, Boolean isCardSupported, Boolean isSmokeEnable,
			Boolean isWifiSupported, Boolean isJapanese,
			Boolean isIvoiceSupported, Boolean isPrivateRoomEnabled,
			String keyWord, Double latitude, Double longitude);
}
