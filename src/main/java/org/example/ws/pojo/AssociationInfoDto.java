package org.example.ws.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import org.example.ws.util.BaseRestResponse;

public class AssociationInfoDto extends BaseRestResponse{

	private Integer groupId;
	private Date createDate;
	private String name;
	private String kind;
	private String detail;
	private String activity;

	@XmlElement(name = "asso_id")
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@XmlElement(name = "create_date")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@XmlElement(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "category_name")
	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@XmlElement(name = "detail")
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@XmlElement(name = "activity")
	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}
