/**
 * 
 */
package org.example.ws.service.impl;

import java.util.List;

import org.example.ws.bean.Coupon;
import org.example.ws.pojo.CommercialDetail;
import org.example.ws.pojo.Filter;
import org.example.ws.pojo.PictureDetail;
import org.example.ws.service.CommercialService;

/**
 * @author peifei
 *
 */
public class CommercialServiceImpl implements CommercialService {

	/* (non-Javadoc)
	 * @see org.example.ws.service.CommercialService#publishCoupon(org.example.ws.bean.Coupon)
	 */
	@Override
	public void publishCoupon(Coupon coupon) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.example.ws.service.CommercialService#getDetail(int)
	 */
	@Override
	public CommercialDetail getDetail(int commercialId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.example.ws.service.CommercialService#getPictureSetDetail(int)
	 */
	@Override
	public List<PictureDetail> getPictureSetDetail(int pictureSetId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.example.ws.service.CommercialService#filterCommercial(org.example.ws.pojo.Filter)
	 */
	@Override
	public List<CommercialDetail> filterCommercial(Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
