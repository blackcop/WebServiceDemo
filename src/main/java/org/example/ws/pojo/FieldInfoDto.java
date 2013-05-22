package org.example.ws.pojo;

import javax.xml.bind.annotation.XmlElement;

public class FieldInfoDto {
	private String fieldId;
	private String fieldName;
	/**
	 * @return the fieldId
	 */
	@XmlElement(name = "field_id")
	public String getFieldId() {
		return fieldId;
	}
	/**
	 * @param fieldId the fieldId to set
	 */
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	/**
	 * @return the fieldName
	 */
	@XmlElement(name = "field_name")
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
