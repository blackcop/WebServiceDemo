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
public class CategoryDto extends BaseRestResponse {

	private List<CategoryInfoDto> categoryList;
	private Integer count;
	/**
	 * @return the categoryList
	 */
	@XmlElement(name = "category_list")
	public List<CategoryInfoDto> getCategoryList() {
		return categoryList;
	}
	/**
	 * @param categoryList the fieldList to set
	 */
	public void setCategoryList(List<CategoryInfoDto> categoryList) {
		this.categoryList = categoryList;
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
