package org.example.ws.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Picture")
public class PictureDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer pictId;

	private String file;

	private Integer name;

	private Integer pictureSetId;

	private byte[] content;

	public Integer getPictId() {
		return pictId;
	}

	public void setPictId(Integer pictId) {
		this.pictId = pictId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public Integer getPictureSetId() {
		return pictureSetId;
	}

	public void setPictureSetId(Integer pictureSetId) {
		this.pictureSetId = pictureSetId;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
