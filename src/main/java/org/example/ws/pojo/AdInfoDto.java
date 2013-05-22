package org.example.ws.pojo;

import javax.xml.bind.annotation.XmlElement;

public class AdInfoDto {
	private String url;
	private String commId;
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
	/**
	 * @return the commId
	 */
	 @XmlElement(name = "comm_id") 
	public String getCommId() {
		return commId;
	}
	/**
	 * @param commId the commId to set
	 */
	public void setCommId(String commId) {
		this.commId = commId;
	}
	
}
