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
	private Collection<PhoneNumberDto> phonenumberList;

	private Integer count;

	@XmlElement(name = "phonenumberList")
	public void setPhonenumberList(Collection<PhoneNumberDto> phonenumberList) {
		this.phonenumberList = phonenumberList;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public Collection<PhoneNumberDto> getPhonenumberList() {
		return phonenumberList;
	}

}
