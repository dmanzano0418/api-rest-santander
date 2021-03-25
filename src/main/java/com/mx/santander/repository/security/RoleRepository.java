/**
 * 
 */
package com.mx.santander.repository.security;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.santander.model.security.ERole;
import com.mx.santander.model.security.Role;

/**
 * @author dmanzano
 *
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Serializable> {
	
	Optional<Role> findByName(ERole name);
	
}
