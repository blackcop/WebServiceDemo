package org.example.ws.pojo;

import org.example.ws.bean.Picture;

public class PictureDetail {

	private Picture picture;
	private Byte[] content;
	/**
	 * @return the picture
	 */
	public Picture getPicture() {
		return picture;
	}
	/**
	 * @param picture the picture to set
	 */
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	/**
	 * @return the content
	 */
	public Byte[] getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(Byte[] content) {
		this.content = content;
	}
}
