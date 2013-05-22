package org.example.ws.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phonenumber")
public class PhoneNumberDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer commId;

	private String phoneNum;

	private String phoneDesc;

	public PhoneNumberDto() {
		super();
	}

	public PhoneNumberDto(Integer commId, String phoneNum, String phoneDesc) {
		super();
		this.commId = commId;
		this.phoneNum = phoneNum;
		this.phoneDesc = phoneDesc;
	}

	@XmlElement(name = "comm_id")
	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	@XmlElement(name = "phone_num")
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@XmlElement(name = "phone_desc")
	public String getPhoneDesc() {
		return phoneDesc;
	}

	public void setPhoneDesc(String phoneDesc) {
		this.phoneDesc = phoneDesc;
	}

}
