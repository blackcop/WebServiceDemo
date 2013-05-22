package org.example.ws.pojo;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PictureSet")
public class PictureSetDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer psId;
	private Integer comm_id;
	private String name;
	private Collection<PictureDto> pictures;

	@XmlElement(name = "picture_set_id")
	public Integer getPsId() {
		return psId;
	}

	public void setPsId(Integer psId) {
		this.psId = psId;
	}

	@XmlElement(name = "comm_id")
	public Integer getComm_id() {
		return comm_id;
	}

	public void setComm_id(Integer comm_id) {
		this.comm_id = comm_id;
	}

	@XmlElement(name = "picture_set_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "pictures")
	public Collection<PictureDto> getPictures() {
		return pictures;
	}

	public void setPictures(Collection<PictureDto> pictures) {
		this.pictures = pictures;
	}

}
