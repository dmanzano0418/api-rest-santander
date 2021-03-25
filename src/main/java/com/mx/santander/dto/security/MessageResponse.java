/**
 * 
 */
package com.mx.santander.dto.security;

import java.io.Serializable;

/**
 * @author dmanzano
 *
 */
public class MessageResponse implements Serializable {

	private static final long serialVersionUID = 3907842844236001917L;

	public MessageResponse() {}
	
	public MessageResponse(String message) {
		super();
		this.message = message;
	}
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageResponse [message=" + message + "]";
	}

}
