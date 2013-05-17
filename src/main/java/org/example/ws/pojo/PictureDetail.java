package org.example.ws.pojo;

import org.example.ws.bean.Picture;

public class PictureDetail {

	private Picture picture;
	private byte[] content;

	/**
	 * @return the picture
	 */
	public Picture getPicture() {
		return picture;
	}

	/**
	 * @param picture
	 *            the picture to set
	 */
	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	/**
	 * @return the content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}
}
