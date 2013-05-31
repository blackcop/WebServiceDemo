package org.example.ws.domain;

// default package
// Generated 2013-5-15 13:47:41 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Picture generated by hbm2java
 */
@Entity
@Table(name = "picture")
public class Picture implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pictId;
	private String file;
	private String name;
	private Integer pictureSetId;

	@Id
	@GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "pict_id", unique = true, nullable = false)
	public Integer getPictId() {
		return this.pictId;
	}

	public void setPictId(Integer pictId) {
		this.pictId = pictId;
	}

	@Column(name = "file", length = 100)
	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pictureSet_id")
	public Integer getPictureSetId() {
		return this.pictureSetId;
	}

	public void setPictureSetId(Integer pictureSetId) {
		this.pictureSetId = pictureSetId;
	}

}
