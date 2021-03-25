/**
 * 
 */
package com.mx.santander.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.santander.model.Telefonos;

/**
 * @author dmanzano
 *
 */
@Repository
public interface ITelefonosRepository extends CrudRepository<Telefonos, Long> {
	
	@Query("SELECT t.imei FROM telefonos t WHERE t.imei = ?1")
	Telefonos findByImei(Long imei);

}
