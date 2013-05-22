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
public class RegionDto extends BaseRestResponse {

	private List<RegionInfoDto> regionList;
	private Integer count;
	/**
	 * @return the fieldList
	 */
	@XmlElement(name = "region_list")
	public List<RegionInfoDto> getFieldList() {
		return regionList;
	}
	/**
	 * @param fieldList the fieldList to set
	 */
	public void setFieldList(List<RegionInfoDto> fieldList) {
		this.regionList = fieldList;
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
