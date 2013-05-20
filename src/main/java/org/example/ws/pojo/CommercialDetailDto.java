package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CommercialDetail")
public class CommercialDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommercialDto commercialDto;

	private PictureDto pictureDto;

	private FacilityDto facilityDto;

	private Collection<CouponDto> couponDtos;

	private Collection<PictureSetDto> pictureSetDtos;

	public CommercialDto getCommercialDto() {
		return commercialDto;
	}

	public void setCommercialDto(CommercialDto commercialDto) {
		this.commercialDto = commercialDto;
	}

	public PictureDto getPictureDto() {
		return pictureDto;
	}

	public void setPictureDto(PictureDto pictureDto) {
		this.pictureDto = pictureDto;
	}

	public FacilityDto getFacilityDto() {
		return facilityDto;
	}

	public void setFacilityDto(FacilityDto facilityDto) {
		this.facilityDto = facilityDto;
	}

	public Collection<CouponDto> getCouponDtos() {
		return couponDtos;
	}

	public void setCouponDtos(Collection<CouponDto> couponDtos) {
		this.couponDtos = couponDtos;
	}

	public Collection<PictureSetDto> getPictureSetDtos() {
		return pictureSetDtos;
	}

	public void setPictureSetDtos(Collection<PictureSetDto> pictureSetDtos) {
		this.pictureSetDtos = pictureSetDtos;
	}

}
