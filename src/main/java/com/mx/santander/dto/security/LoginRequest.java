/**
 * 
 */
package com.mx.santander.dto.security;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

/**
 * @author dmanzano
 *
 */
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 5920062286631018594L;

	public LoginRequest() {}
	
	public LoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	@NotBlank
	private String username;

	@NotBlank
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + "]";
	}

}
