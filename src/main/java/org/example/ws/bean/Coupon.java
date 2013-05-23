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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/**
 * Coupon generated by hbm2java
 */
@Entity
@Table(name = "coupon", catalog = "shixun")
@XmlRootElement(name = "Coupon")
public class Coupon implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer commId;

	private Integer couponId;

	private String detail;

	private Integer count;

	private String commName;

	private Date beginDate;

	private Date endDate;

	private Integer pictureId;
	private Boolean isRecommend;

	private Set<Account> accounts = new HashSet<Account>();

	@Column(name = "comm_id", unique = true, nullable = false)
	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	@Id
	@GenericGenerator(name = "idgen", strategy = "increment")
	@GeneratedValue(generator = "idgen")
	@Column(name = "coupon_id")
	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	@Column(name = "detail", length = 400)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "comm_name", length = 20)
	public String getCommName() {
		return this.commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "beginDate", nullable = false, length = 19)
	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endDate", nullable = false, length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "picture_id")
	public Integer getPictureId() {
		return pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	@Column(name = "is_recommend")
	public Boolean getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "coupons")
	@JoinTable(name = "account_coupon", catalog = "shixun", joinColumns = { @JoinColumn(name = "coupon_id", referencedColumnName = "coupon_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "act_id", referencedColumnName = "account_id", nullable = false, updatable = false) })
	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}
