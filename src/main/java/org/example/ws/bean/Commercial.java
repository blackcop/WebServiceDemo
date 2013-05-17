package org.example.ws.bean;

// default package
// Generated 2013-5-15 13:47:41 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Commercial generated by hbm2java
 */
@Entity
@Table(name = "commercial", catalog = "shixun")
public class Commercial implements java.io.Serializable {

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
	private Set<Account> accounts = new HashSet<Account>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comm_id", unique = true, nullable = false)
	public Integer getCommId() {
		return this.commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	@Column(name = "fac_id")
	public Integer getFacId() {
		return facId;
	}

	public void setFacId(Integer facId) {
		this.facId = facId;
	}

	@Column(name = "pict_id")
	public Integer getPictId() {
		return pictId;
	}

	public void setPictId(Integer pictId) {
		this.pictId = pictId;
	}

	@Column(name = "name", length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "budget")
	public Integer getBudget() {
		return this.budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	@Column(name = "other", length = 200)
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Column(name = "kind1", length = 20)
	public String getKind1() {
		return this.kind1;
	}

	public void setKind1(String kind1) {
		this.kind1 = kind1;
	}

	@Column(name = "kind2", length = 20)
	public String getKind2() {
		return this.kind2;
	}

	public void setKind2(String kind2) {
		this.kind2 = kind2;
	}

	@Column(name = "region1", length = 20)
	public String getRegion1() {
		return this.region1;
	}

	public void setRegion1(String region1) {
		this.region1 = region1;
	}

	@Column(name = "region2", length = 40)
	public String getRegion2() {
		return this.region2;
	}

	public void setRegion2(String region2) {
		this.region2 = region2;
	}

	@Column(name = "latitude", precision = 22, scale = 0)
	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", precision = 22, scale = 0)
	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Column(name = "commercialcol", precision = 22, scale = 0)
	public Double getCommercialcol() {
		return this.commercialcol;
	}

	public void setCommercialcol(Double commercialcol) {
		this.commercialcol = commercialcol;
	}

	@Column(name = "phonenumber", length = 20)
	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "opentime", length = 8)
	public Date getOpentime() {
		return this.opentime;
	}

	public void setOpentime(Date opentime) {
		this.opentime = opentime;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "closetime", length = 8)
	public Date getClosetime() {
		return this.closetime;
	}

	public void setClosetime(Date closetime) {
		this.closetime = closetime;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "commercials")
	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
