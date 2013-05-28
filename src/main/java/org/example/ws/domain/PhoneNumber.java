package org.example.ws.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "phonenumber", catalog = "shixun")
public class PhoneNumber implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer phonenumber_id;

	private Integer comm_id;

	private String phone_num;

	private String phone_desc;

	@Id
	@GenericGenerator(name = "idgen", strategy = "increment")
	@GeneratedValue(generator = "idgen")
	@Column(name = "phonenumber_id", unique = true, nullable = false)
	public Integer getPhonenumber_id() {
		return phonenumber_id;
	}

	public void setPhonenumber_id(Integer phonenumber_id) {
		this.phonenumber_id = phonenumber_id;
	}

	@Column(name = "comm_id")
	public Integer getComm_id() {
		return comm_id;
	}

	public void setComm_id(Integer comm_id) {
		this.comm_id = comm_id;
	}

	@Column(name = "phone_num", length = 50)
	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	@Column(name = "phone_num", length = 50)
	public String getPhone_desc() {
		return phone_desc;
	}

	public void setPhone_desc(String phone_desc) {
		this.phone_desc = phone_desc;
	}
}
