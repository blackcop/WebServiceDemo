package org.example.ws.bean;

// default package
// Generated 2013-5-15 13:47:41 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", catalog = "shixun")
public class Account implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer actId;

	private String name;

	private Set<Coupon> coupons = new HashSet<Coupon>();

	private Set<Commercial> commercials = new HashSet<Commercial>();

	private Set<Association> associations = new HashSet<Association>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "act_id", unique = true, nullable = false)
	public Integer getActId() {
		return actId;
	}

	public void setActId(Integer actId) {
		this.actId = actId;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "account_coupon", catalog = "shixun", joinColumns = { @JoinColumn(name = "account_id", referencedColumnName = "act_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "coupon_id",  referencedColumnName = "coupon_id",nullable = false, updatable = false) })
	public Set<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupon> coupons) {
		this.coupons = coupons;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "favorite", catalog = "shixun", joinColumns = { @JoinColumn(name = "account_id", referencedColumnName = "act_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "comm_id",  referencedColumnName = "comm_id", nullable = false, updatable = false) })
	public Set<Commercial> getCommercials() {
		return commercials;
	}

	public void setCommercials(Set<Commercial> commercials) {
		this.commercials = commercials;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "group_set", catalog = "shixun", joinColumns = { @JoinColumn(name = "account_id", referencedColumnName = "act_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false, updatable = false) })
	public Set<Association> getAssociations() {
		return associations;
	}

	public void setAssociations(Set<Association> associations) {
		this.associations = associations;
	}
}
