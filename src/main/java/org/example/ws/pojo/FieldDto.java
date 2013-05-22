/**
 * 
 */
package org.example.ws.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.ws.util.BaseRestResponse;

/**
 * @author peifei
 *
 */
@XmlRootElement(name="result")
public class FieldDto extends BaseRestResponse {

	private List<FieldInfoDto> fieldList;
	private Integer count;
	/**
	 * @return the fieldList
	 */
	@XmlElement(name = "field_list")
	public List<FieldInfoDto> getFieldList() {
		return fieldList;
	}
	/**
	 * @param fieldList the fieldList to set
	 */
	public void setFieldList(List<FieldInfoDto> fieldList) {
		this.fieldList = fieldList;
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
