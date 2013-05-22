package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.ws.util.BaseRestResponse;

@XmlRootElement(name = "result")
public class CommercialSummarysResultDto extends BaseRestResponse implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer count;

	private Collection<CommercialSummaryDto> commercialSummarys;

	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "commercial_summarys")
	public Collection<CommercialSummaryDto> getCommercialSummarys() {
		return commercialSummarys;
	}

	public void setCommercialSummarys(
			Collection<CommercialSummaryDto> commercialSummarys) {
		this.commercialSummarys = commercialSummarys;
	}

}
