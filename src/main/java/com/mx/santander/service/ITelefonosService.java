/**
 * 
 */
package com.mx.santander.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mx.santander.model.Telefonos;

/**
 * @author dmanzano
 *
 */
@Component
public interface ITelefonosService {
	
	Telefonos getTelefonoById(Long id);
	List<Telefonos> getAllTelefonos();
	Telefonos saveTelefonos(Telefonos telefonos);
	Telefonos updateTelefonos(Telefonos telefonos);
	void delete(Long id);
	
	Telefonos getTelefonoByImei(Long imei);

}
