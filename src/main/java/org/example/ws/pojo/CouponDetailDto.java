package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Date;

public class CouponDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer commId; // 商铺ID

	private String commName;// 商铺名称

	private Integer couponId;// 优惠券ID

	private String detail;// 优惠券Title

	private String coupon_content;// 优惠券内容

	private Date beginDate;

	private Date endDate;

	private String picture_url;
}
