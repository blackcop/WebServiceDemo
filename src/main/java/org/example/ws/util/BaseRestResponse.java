package org.example.ws.util;

import javax.xml.bind.annotation.XmlElement;

public class BaseRestResponse {
	
	private String errorMsg;

	/**
	 * @return the errorMsg
	 */
	@XmlElement(name = "error_msg")
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
