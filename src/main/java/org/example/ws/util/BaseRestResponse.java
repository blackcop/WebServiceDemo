package org.example.ws.util;

import javax.xml.bind.annotation.XmlElement;

public class BaseRestResponse {
	
	private String errorCode;
	private String errorMsg;

	/**
	 * @return the errorMsg
	 */
	@XmlElement(name = "err_msg")
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the errorCode
	 */
	@XmlElement(name = "err_code")
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
