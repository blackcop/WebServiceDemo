package org.example.ws.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "advert", catalog = "shixun")
public class Advert implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer advertId;
	
	private Integer CommId;
	
	private String  advertName;
	
	private String advertImgPath;

	@Id
	@GenericGenerator(name = "idgen", strategy = "increment")
	@GeneratedValue(generator = "idgen")
	@Column(name = "advert_id", unique = true, nullable = false)
	public Integer getAdvertId() {
		return advertId;
	}

	public void setAdvertId(Integer advertId) {
		this.advertId = advertId;
	}

	@Column(name = "comm_id")
	public Integer getCommId() {
		return CommId;
	}

	public void setCommId(Integer commId) {
		CommId = commId;
	}

	
	@Column(name = "advert_name", length = 100)
	public String getAdvertName() {
		return advertName;
	}

	public void setAdvertName(String advertName) {
		this.advertName = advertName;
	}

	
	@Column(name = "advert_img_path", length = 300)
	public String getAdvertImgPath() {
		return advertImgPath;
	}

	public void setAdvertImgPath(String advertImgPath) {
		this.advertImgPath = advertImgPath;
	}

	
}
