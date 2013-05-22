package org.example.ws.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.ws.util.BaseRestResponse;

@XmlRootElement(name = "result")
public class CommercialDetailResultDto extends BaseRestResponse implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer count;
	private CommercialDetailDto commercialDetailDto;

	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "commercial_detail")
	public CommercialDetailDto getCommercialDetailDto() {
		return commercialDetailDto;
	}

	public void setCommercialDetailDto(CommercialDetailDto commercialDetailDto) {
		this.commercialDetailDto = commercialDetailDto;
	}

}
