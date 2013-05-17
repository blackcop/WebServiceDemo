package org.example.ws.pojo;

import org.example.ws.bean.PictureSet;

public class PictureSetDetail {

	private PictureSet ps;
	private Byte[] cover;

	/**
	 * @return the ps
	 */
	public PictureSet getPs() {
		return ps;
	}

	/**
	 * @param ps
	 *            the ps to set
	 */
	public void setPs(PictureSet ps) {
		this.ps = ps;
	}

	/**
	 * @return the cover
	 */
	public Byte[] getCover() {
		return cover;
	}

	/**
	 * @param cover
	 *            the cover to set
	 */
	public void setCover(Byte[] cover) {
		this.cover = cover;
	}
}
