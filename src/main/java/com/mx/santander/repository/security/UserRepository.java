/**
 * 
 */
package com.mx.santander.repository.security;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.santander.model.security.User;

/**
 * @author dmanzano
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Serializable>{
	
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);

}
