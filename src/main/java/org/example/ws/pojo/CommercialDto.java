package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Commercial")
public class CommercialDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer commId;

	private Integer facId;

	private Integer pictId;

	private String name;

	private String address;

	private Integer budget;

	private String other;

	private String kind1;

	private String kind2;

	private String region1;

	private String region2;

	private Double latitude;

	private Double longitude;

	private Double commercialcol;

	private String phonenumber;

	private Date opentime;

	private Date closetime;

	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	public Integer getFacId() {
		return facId;
	}

	public void setFacId(Integer facId) {
		this.facId = facId;
	}

	public Integer getPictId() {
		return pictId;
	}

	public void setPictId(Integer pictId) {
		this.pictId = pictId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
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

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getCommercialcol() {
		return commercialcol;
	}

	public void setCommercialcol(Double commercialcol) {
		this.commercialcol = commercialcol;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getOpentime() {
		return opentime;
	}

	public void setOpentime(Date opentime) {
		this.opentime = opentime;
	}

	public Date getClosetime() {
		return closetime;
	}

	public void setClosetime(Date closetime) {
		this.closetime = closetime;
	}

}
