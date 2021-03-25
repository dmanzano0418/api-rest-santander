/**
 * 
 */
package com.mx.santander.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.santander.model.Telefonos;
import com.mx.santander.repository.ITelefonosRepository;

/**
 * @author dmanzano
 *
 */
@Service
public class TelefonosService implements ITelefonosService {
	
	@Autowired
	ITelefonosRepository repository;
	
	@Transactional(readOnly = true)
	public Telefonos getTelefonoById(Long id) {
		
		Telefonos telefono = null;
		
		Optional<Telefonos> telefonoResponse = repository.findById(id);
		
		if (telefonoResponse.isPresent()) {
			telefono = telefonoResponse.get();
		} else {
			throw new RuntimeException("No record found for given id: "+id);
		}
		return telefono;
		
	}
	
	@Transactional(readOnly = true)
	public Telefonos getTelefonoByImei(Long imei) {
		Telefonos telefono = null;
		Telefonos telefonoResponse = repository.findByImei(imei);
		if (telefonoResponse.getImei() == null) {
			return telefono;
		} else {
			throw new RuntimeException("No record found for given imei: " + imei);
		}
	}
	
	@Transactional
	public List<Telefonos> getAllTelefonos() {
		List<Telefonos> listResponse = (List<Telefonos>) repository.findAll();
		return listResponse;
	}
	
	@Transactional
	public Telefonos saveTelefonos(Telefonos telefonos) {
		Telefonos saveTelefonos = null;
		Telefonos telefonoResponse = repository.findByImei(telefonos.getImei());
		if (telefonoResponse == null) {
			saveTelefonos = repository.save(telefonos);
		} else {
			throw new RuntimeException("Ya existe un registro con el IMEI: " + telefonos.getImei());
		}
		return saveTelefonos;
	}

	@Transactional
	public Telefonos updateTelefonos(Telefonos telefonos) {
		Telefonos updateTelefonos = repository.save(telefonos);
		return updateTelefonos;
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
		
	}	

}
