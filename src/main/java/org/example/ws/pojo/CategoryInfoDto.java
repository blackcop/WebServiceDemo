package org.example.ws.pojo;

import javax.xml.bind.annotation.XmlElement;

public class CategoryInfoDto {
	private String categoryId;
	private String categoryName;

	/**
	 * @return the categoryId
	 */
	@XmlElement(name = "kind_id")
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	@XmlElement(name = "kind_name")
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
