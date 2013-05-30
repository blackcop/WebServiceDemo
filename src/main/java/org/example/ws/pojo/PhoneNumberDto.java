package org.example.ws.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dijia.Tang
 * 
 */
@XmlRootElement(name = "phonenumber")
public class PhoneNumberDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Integer phonenumber_id;

	// private Integer comm_id;

	private String phone_num;

	private String phone_desc;

	public PhoneNumberDto() {
		super();
	}

	// @XmlElement(name = "phonenumber_id")
	// public Integer getPhonenumber_id() {
	// return phonenumber_id;
	// }
	//
	// public void setPhonenumber_id(Integer phonenumber_id) {
	// this.phonenumber_id = phonenumber_id;
	// }
	//
	// @XmlElement(name = "commercial_id")
	// public Integer getComm_id() {
	// return comm_id;
	// }
	//
	// public void setComm_id(Integer comm_id) {
	// this.comm_id = comm_id;
	// }

	@XmlElement(name = "phone_num")
	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	@XmlElement(name = "phone_desc")
	public String getPhone_desc() {
		return phone_desc;
	}

	public void setPhone_desc(String phone_desc) {
		this.phone_desc = phone_desc;
	}

}
