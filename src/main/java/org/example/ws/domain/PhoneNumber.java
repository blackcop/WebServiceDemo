package org.example.ws.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "phonenumber")
public class PhoneNumber implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer phonenumberId;

	private Integer commId;

	private String phoneNum;

	private String phoneDesc;

	@Id
	@GenericGenerator(name = "idgen", strategy = "increment")
	@GeneratedValue(generator = "idgen")
	@Column(name = "phonenumber_id", unique = true, nullable = false)
	public Integer getPhonenumberId() {
		return phonenumberId;
	}

	public void setPhonenumberId(Integer phonenumberId) {
		this.phonenumberId = phonenumberId;
	}

	@Column(name = "comm_id")
	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	@Column(name = "phone_num", length = 50)
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Column(name = "phone_desc", length = 50)
	public String getPhoneDesc() {
		return phoneDesc;
	}

	public void setPhoneDesc(String phone_desc) {
		this.phoneDesc = phone_desc;
	}
}
