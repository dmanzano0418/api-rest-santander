/**
 * 
 */
package com.mx.santander.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mx.santander.dto.TelefonosRequestDTO;
import com.mx.santander.dto.TelefonosResponseDTO;
import com.mx.santander.model.Telefonos;
import com.mx.santander.service.ITelefonosService;

/**
 * @author dmanzano
 *
 */
@Component
public class TelefonosFacade {
	
	@Autowired
	private ITelefonosService telefonosService;
	
	public TelefonosResponseDTO getTelefonoById(Long id) {
		TelefonosResponseDTO getTelefonoById = null;
		try {
			getTelefonoById = convertEntityToDto(telefonosService.getTelefonoById(id));
		} catch (Exception ex) {
			ex.getMessage();
		}
		return getTelefonoById;
	}
	
	public TelefonosResponseDTO getTelefonoByImei(Long imei) {
		TelefonosResponseDTO getTelefonoByImei = null;
		try {
			getTelefonoByImei = convertEntityToDto(telefonosService.getTelefonoByImei(imei));
		} catch (Exception ex) {
			ex.getMessage();
		}
		return getTelefonoByImei;
	}
	
	public List<TelefonosResponseDTO> getAllTelefonos() {
		List<TelefonosResponseDTO> getAllTelefonos = null;
		try {
			getAllTelefonos = convertEntityToDtoList(telefonosService.getAllTelefonos());
		} catch (Exception e) {
			e.getMessage();
		}
		return getAllTelefonos;
	}
	
	public TelefonosResponseDTO saveTelefonos(TelefonosRequestDTO telefonosRequest) {
		Telefonos telefonos = convertDtoToEntity(telefonosRequest);
		return convertEntityToDto(telefonosService.saveTelefonos(telefonos));
	}
	
	public TelefonosResponseDTO updateTelefonos(TelefonosRequestDTO telefonosRequest) {
		Telefonos telefonos = convertDtoToEntity(telefonosRequest);
		return convertEntityToDto(telefonosService.updateTelefonos(telefonos));
	}
	
	public void deleteTelefonos(Long id) {
		telefonosService.delete(id);
	}
	
	public Telefonos convertDtoToEntity(TelefonosRequestDTO telefonosRequest) {
		// Mapeo request dto ==> entity
		Telefonos telefonos = new Telefonos();
		BeanUtils.copyProperties(telefonosRequest, telefonos);
		return telefonos;
	}
	
	public TelefonosResponseDTO convertEntityToDto(Telefonos telefonos) {
		// Mapeo entity ==> response dto
		TelefonosResponseDTO telefonosResponse = new TelefonosResponseDTO();
		BeanUtils.copyProperties(telefonos, telefonosResponse);
		return telefonosResponse;
	}
	
	public List<TelefonosResponseDTO> convertEntityToDtoList(List<Telefonos> listTelefonos) {
		// Mapeo entity ==> response dto
		List<TelefonosResponseDTO> listaTelefonos = new ArrayList<TelefonosResponseDTO>();
		if (!listTelefonos.isEmpty()) {
			listTelefonos.stream().forEach((list)-> {
				TelefonosResponseDTO telefonosResponseDTO = new TelefonosResponseDTO();
				BeanUtils.copyProperties(list, telefonosResponseDTO);
				listaTelefonos.add(telefonosResponseDTO);
			});
		}
		return listaTelefonos;
	}

}
