package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Dijia.Tang
 * 
 */

public class PicturesDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer count;

	private Collection<PictureDto> picture_list;

	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "picture_list")
	public Collection<PictureDto> getPicture_list() {
		return picture_list;
	}

	public void setPicture_list(Collection<PictureDto> picture_list) {
		this.picture_list = picture_list;
	}

}
