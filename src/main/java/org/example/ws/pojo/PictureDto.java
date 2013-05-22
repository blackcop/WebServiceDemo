package org.example.ws.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "picture")
public class PictureDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer pictId;

	private String file;

	private String name;

	private Integer pictureSetId;

	@XmlElement(name = "picture_id")
	public Integer getPictId() {
		return pictId;
	}

	public void setPictId(Integer pictId) {
		this.pictId = pictId;
	}

	@XmlElement(name = "picture_url")
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@XmlElement(name = "picture_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "picture_set_id")
	public Integer getPictureSetId() {
		return pictureSetId;
	}

	public void setPictureSetId(Integer pictureSetId) {
		this.pictureSetId = pictureSetId;
	}

}
