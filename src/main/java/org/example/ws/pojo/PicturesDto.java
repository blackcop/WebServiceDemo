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

	private Collection<PictureDto> pictureList;

	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "picture_list")
	public Collection<PictureDto> getPictureList() {
		return pictureList;
	}

	public void setPictureList(Collection<PictureDto> pictureList) {
		this.pictureList = pictureList;
	}

}
