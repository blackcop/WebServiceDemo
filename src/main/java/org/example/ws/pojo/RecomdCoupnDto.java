package org.example.ws.pojo;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.example.ws.util.BaseRestResponse;
@XmlRootElement(name="result")
public class RecomdCoupnDto extends BaseRestResponse{
	private List<RecomdInfoDto> couponList;
	private Integer count;
	
	
	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "coupon_list")
	public List<RecomdInfoDto> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<RecomdInfoDto> coupon_list) {
		this.couponList = coupon_list;
	}

}
