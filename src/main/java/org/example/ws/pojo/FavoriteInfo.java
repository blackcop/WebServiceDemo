package org.example.ws.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FavoriteInfo")
public class FavoriteInfo {

	private String commercialName;
	private int commercialId;
	/**
	 * @return the commercialName
	 */
	public String getCommercialName() {
		return commercialName;
	}
	/**
	 * @param commercialName the commercialName to set
	 */
	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}
	/**
	 * @return the commercialId
	 */
	public int getCommercialId() {
		return commercialId;
	}
	/**
	 * @param commercialId the commercialId to set
	 */
	public void setCommercialId(int commercialId) {
		this.commercialId = commercialId;
	}
}
