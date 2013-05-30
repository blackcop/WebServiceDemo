package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Dijia.Tang
 * 
 */
public class PhoneNumbersDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 电话号码
	 */
	private Collection<PhoneNumberDto> phonenumber_list;

	private Integer count;

	@XmlElement(name = "phonenumber_list")
	public void setPhonenumber_list(Collection<PhoneNumberDto> phonenumber_list) {
		this.phonenumber_list = phonenumber_list;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public Collection<PhoneNumberDto> getPhonenumber_list() {
		return phonenumber_list;
	}

}
