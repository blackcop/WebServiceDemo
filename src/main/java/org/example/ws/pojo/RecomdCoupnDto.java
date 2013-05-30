package org.example.ws.pojo;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.ws.util.BaseRestResponse;
@XmlRootElement(name="result")
public class RecomdCoupnDto extends BaseRestResponse{
	private List<RecomdInfoDto> coupon_list;
	private Integer count;
	
	
	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "coupon_list")
	public List<RecomdInfoDto> getCoupon_list() {
		return coupon_list;
	}

	public void setCoupon_list(List<RecomdInfoDto> coupon_list) {
		this.coupon_list = coupon_list;
	}

}
