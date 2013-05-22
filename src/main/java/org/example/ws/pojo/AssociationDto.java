package org.example.ws.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.ws.util.BaseRestResponse;

@XmlRootElement(name = "result")
public class AssociationDto extends BaseRestResponse{
    private List<AssociationInfoDto> assoList;
    private Integer count;
	/**
	 * @return the assoList
	 */
    @XmlElement(name = "asso_list")
	public List<AssociationInfoDto> getAssoList() {
		return assoList;
	}
	/**
	 * @param assoList the assoList to set
	 */
	public void setAssoList(List<AssociationInfoDto> assoList) {
		this.assoList = assoList;
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

}
