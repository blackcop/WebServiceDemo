package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Dijia.Tang
 * 
 */
public class PictureSetsDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer count;

	private Collection<PictureSetDto> picturesetList;

	@XmlElement(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@XmlElement(name = "pictureset_list")
	public Collection<PictureSetDto> getPicturesetList() {
		return picturesetList;
	}

	public void setPicturesetList(Collection<PictureSetDto> picturesetList) {
		this.picturesetList = picturesetList;
	}

}
