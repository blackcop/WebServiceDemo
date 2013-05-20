package org.example.ws.pojo;

import java.io.Serializable;

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
	/**
	 * 封面图片ID
	 */
	private Integer coverId;
	private Byte[] cover;

	public Integer getPsId() {
		return psId;
	}

	public void setPsId(Integer psId) {
		this.psId = psId;
	}

	public Integer getComm_id() {
		return comm_id;
	}

	public void setComm_id(Integer comm_id) {
		this.comm_id = comm_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCoverId() {
		return coverId;
	}

	public void setCoverId(Integer coverId) {
		this.coverId = coverId;
	}

	public Byte[] getCover() {
		return cover;
	}

	public void setCover(Byte[] cover) {
		this.cover = cover;
	}

}
