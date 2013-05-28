package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "commercial_detail")
public class CommercialDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 商铺ID
	 */
	private Integer commId;

	/**
	 * 商铺图片路径
	 */
	private String pictUrl;

	/**
	 * 商铺名称
	 */
	private String name;

	/**
	 * 一级类别
	 */
	private String kind1;

	/**
	 * 二级类别
	 */
	private String kind2;

	/**
	 * 预算
	 */
	private Integer budget;

	/**
	 * 可否刷卡
	 */
	private Boolean isCardSupported;

	/**
	 * 可否抽烟
	 */
	private Boolean isSmokeEnable;

	/**
	 * 日语
	 */
	private Boolean isJapanese;

	/**
	 * 开发票
	 */
	private Boolean isIvoiceSupported;

	/**
	 * 是否所有wifi
	 */
	private Boolean isWifiSupported;

	/**
	 * 是否有包间
	 */
	private Boolean isPrivateRoomEnabled;

	/**
	 * 商铺名称
	 */
	private String address;

	/**
	 * 电话号码
	 */
	private Collection<PhoneNumberDto> phonenumbers;

	/**
	 * 一级地区名称
	 */
	private String region1;

	/**
	 * 二级地区名称
	 */
	private String region2;

	private String opentime;

	private String closetime;

	private Double latitude;

	private Double longitude;

	private String other;

	private Collection<CouponDto> coupons;

	private Collection<PictureSetDto> pictureSets;

	@XmlElement(name = "commercial_id")
	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	@XmlElement(name = "picture_url")
	public String getPictUrl() {
		return pictUrl;
	}

	public void setPictUrl(String pictUrl) {
		this.pictUrl = pictUrl;
	}

	@XmlElement(name = "commercial_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "kind_pname")
	public String getKind1() {
		return kind1;
	}

	public void setKind1(String kind1) {
		this.kind1 = kind1;
	}

	@XmlElement(name = "kind_cname")
	public String getKind2() {
		return kind2;
	}

	public void setKind2(String kind2) {
		this.kind2 = kind2;
	}

	@XmlElement(name = "budget")
	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	@XmlElement(name = "is_card_supported")
	public Boolean getIsCardSupported() {
		return isCardSupported;
	}

	public void setIsCardSupported(Boolean isCardSupported) {
		this.isCardSupported = isCardSupported;
	}

	@XmlElement(name = "is_smoke_enable")
	public Boolean getIsSmokeEnable() {
		return isSmokeEnable;
	}

	public void setIsSmokeEnable(Boolean isSmokeEnable) {
		this.isSmokeEnable = isSmokeEnable;
	}

	@XmlElement(name = "is_japanese")
	public Boolean getIsJapanese() {
		return isJapanese;
	}

	public void setIsJapanese(Boolean isJapanese) {
		this.isJapanese = isJapanese;
	}

	@XmlElement(name = "is_ivoice_supported")
	public Boolean getIsIvoiceSupported() {
		return isIvoiceSupported;
	}

	public void setIsIvoiceSupported(Boolean isIvoiceSupported) {
		this.isIvoiceSupported = isIvoiceSupported;
	}

	@XmlElement(name = "is_wifi_supported")
	public Boolean getIsWifiSupported() {
		return isWifiSupported;
	}

	public void setIsWifiSupported(Boolean isWifiSupported) {
		this.isWifiSupported = isWifiSupported;
	}

	@XmlElement(name = "is_privateroom_enabled")
	public Boolean getIsPrivateRoomEnabled() {
		return isPrivateRoomEnabled;
	}

	public void setIsPrivateRoomEnabled(Boolean isPrivateRoomEnabled) {
		this.isPrivateRoomEnabled = isPrivateRoomEnabled;
	}

	@XmlElement(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement(name = "region_pname")
	public String getRegion1() {
		return region1;
	}

	public void setRegion1(String region1) {
		this.region1 = region1;
	}

	@XmlElement(name = "region_cname")
	public String getRegion2() {
		return region2;
	}

	public void setRegion2(String region2) {
		this.region2 = region2;
	}

	@XmlElement(name = "coupons")
	public Collection<CouponDto> getCoupons() {
		return coupons;
	}

	public void setCoupons(Collection<CouponDto> coupons) {
		this.coupons = coupons;
	}

	@XmlElement(name = "picture_sets")
	public Collection<PictureSetDto> getPictureSets() {
		return pictureSets;
	}

	public void setPictureSets(Collection<PictureSetDto> pictureSets) {
		this.pictureSets = pictureSets;
	}

	@XmlElement(name = "phone_numbers")
	public Collection<PhoneNumberDto> getPhonenumbers() {
		return phonenumbers;
	}

	public void setPhonenumbers(Collection<PhoneNumberDto> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}

	@XmlElement(name = "opentime")
	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	@XmlElement(name = "closetime")
	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	@XmlElement(name = "latitude")
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@XmlElement(name = "longitude")
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@XmlElement(name = "other")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "CommercialDetailDto [commId=" + commId + ", pictUrl=" + pictUrl
				+ ", name=" + name + ", kind1=" + kind1 + ", kind2=" + kind2
				+ ", budget=" + budget + ", isCardSupported=" + isCardSupported
				+ ", isSmokeEnable=" + isSmokeEnable + ", isJapanese="
				+ isJapanese + ", isIvoiceSupported=" + isIvoiceSupported
				+ ", isWifiSupported=" + isWifiSupported
				+ ", isPrivateRoomEnabled=" + isPrivateRoomEnabled
				+ ", address=" + address + ", region1=" + region1
				+ ", region2=" + region2 + ", opentime=" + opentime
				+ ", closetime=" + closetime + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

}
