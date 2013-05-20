package org.example.ws.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Facility")
public class FacilityDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer facId;

	private Integer commId;

	private Boolean isCardSupported;

	private Boolean isSmokeEnable;

	private Boolean isWifiSupported;

	private Boolean isJapanese;

	private Boolean isIvoiceSupported;

	private Boolean isPrivateRoomEnabled;

	public Integer getFacId() {
		return facId;
	}

	public void setFacId(Integer facId) {
		this.facId = facId;
	}

	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	public Boolean getIsCardSupported() {
		return isCardSupported;
	}

	public void setIsCardSupported(Boolean isCardSupported) {
		this.isCardSupported = isCardSupported;
	}

	public Boolean getIsSmokeEnable() {
		return isSmokeEnable;
	}

	public void setIsSmokeEnable(Boolean isSmokeEnable) {
		this.isSmokeEnable = isSmokeEnable;
	}

	public Boolean getIsWifiSupported() {
		return isWifiSupported;
	}

	public void setIsWifiSupported(Boolean isWifiSupported) {
		this.isWifiSupported = isWifiSupported;
	}

	public Boolean getIsJapanese() {
		return isJapanese;
	}

	public void setIsJapanese(Boolean isJapanese) {
		this.isJapanese = isJapanese;
	}

	public Boolean getIsIvoiceSupported() {
		return isIvoiceSupported;
	}

	public void setIsIvoiceSupported(Boolean isIvoiceSupported) {
		this.isIvoiceSupported = isIvoiceSupported;
	}

	public Boolean getIsPrivateRoomEnabled() {
		return isPrivateRoomEnabled;
	}

	public void setIsPrivateRoomEnabled(Boolean isPrivateRoomEnabled) {
		this.isPrivateRoomEnabled = isPrivateRoomEnabled;
	}

}
