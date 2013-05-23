package org.example.ws.pojo;

import javax.xml.bind.annotation.XmlElement;

public class AdInfoDto {
	private String url;
	private Integer commId;
	/**
	 * @return the url
	 */
	@XmlElement(name = "pic_url") 
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	 @XmlElement(name = "commercial_id") 
	public Integer getCommId() {
		return commId;
	}
	public void setCommId(Integer commId) {
		this.commId = commId;
	}
	/**
	 * @return the commId
	 */

	
}
