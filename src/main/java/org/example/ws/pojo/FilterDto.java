package org.example.ws.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Filter")
public class FilterDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String region1;

	private String region2;

	private String kind1;

	private String kind2;

	private String key;

	//TODO
	private Integer budget1;

	private Integer budget2;

	private Boolean isCardSupported;

	private Boolean isSmokeEnable;

	private Boolean isWifiSupported;

	private Boolean isJapanese;

	private Boolean isIvoiceSupported;

	private Boolean isPrivateRoomEnabled;

	public String getRegion1() {
		return region1;
	}

	public void setRegion1(String region1) {
		this.region1 = region1;
	}

	public String getRegion2() {
		return region2;
	}

	public void setRegion2(String region2) {
		this.region2 = region2;
	}

	public String getKind1() {
		return kind1;
	}

	public void setKind1(String kind1) {
		this.kind1 = kind1;
	}

	public String getKind2() {
		return kind2;
	}

	public void setKind2(String kind2) {
		this.kind2 = kind2;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getBudget1() {
		return budget1;
	}

	public void setBudget1(Integer budget1) {
		this.budget1 = budget1;
	}

	public Integer getBudget2() {
		return budget2;
	}

	public void setBudget2(Integer budget2) {
		this.budget2 = budget2;
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
