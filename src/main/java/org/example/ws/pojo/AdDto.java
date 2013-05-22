package org.example.ws.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.ws.util.BaseRestResponse;

@XmlRootElement(name="result")
public class AdDto extends BaseRestResponse{
	
	private List<AdInfoDto> adList;
	private Integer count;

	/**
	 * @return the adList
	 */
	@XmlElement(name = "ad_list")
	public List<AdInfoDto> getAdList() {
		return adList;
	}

	/**
	 * @param adList the adList to set
	 */
	public void setAdList(List<AdInfoDto> adList) {
		this.adList = adList;
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
