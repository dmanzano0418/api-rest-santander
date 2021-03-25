/**
 * 
 */
package com.mx.santander.dto.security;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author dmanzano
 *
 */
public class SignupRequest implements Serializable {

	private static final long serialVersionUID = -3352614666406558757L;

	public SignupRequest() {}
	
	public SignupRequest(String username, String email, Set<String> role, String password) {
		super();
		this.username = username;
		this.email = email;
		this.role = role;
		this.password = password;
	}

	@NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }

	@Override
	public String toString() {
		return "SignupRequest [username=" + username + ", email=" + email + ", role=" + role + ", password=" + password
				+ "]";
	}

}
