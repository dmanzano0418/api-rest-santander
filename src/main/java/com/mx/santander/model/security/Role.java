/**
 * 
 */
package com.mx.santander.model.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author dmanzano
 *
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {

	private static final long serialVersionUID = 2074099803728362625L;

	public Role() {}
	
	public Role(Integer id, ERole name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_generator")
	@SequenceGenerator(name="role_generator", sequenceName = "role_sequence", allocationSize = 1)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	public Role(ERole name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
