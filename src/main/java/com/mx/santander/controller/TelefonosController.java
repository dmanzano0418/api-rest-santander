/**
 * 
 */
package com.mx.santander.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.santander.dto.TelefonosRequestDTO;
import com.mx.santander.dto.TelefonosResponseDTO;
import com.mx.santander.facade.TelefonosFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author dmanzano
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(value="telefonos API")
@RequestMapping("/apibc")
@RestController
public class TelefonosController {
	
	@Autowired
	private TelefonosFacade telefonosFacade;
	
	@GetMapping("/telefonos/{id}")
	@ApiOperation(value = "Find telefono", notes = "Returns one info")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Telefono Not Found")})
    public ResponseEntity<TelefonosResponseDTO> getTelefonoById(@PathVariable Long id) {
		TelefonosResponseDTO telefonosDTO = telefonosFacade.getTelefonoById(id);
		if (null == telefonosDTO) {
			return new ResponseEntity<TelefonosResponseDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TelefonosResponseDTO>(telefonosDTO, HttpStatus.OK);
	}
	
	@GetMapping("/telefonos/imei/{imei}")
	@ApiOperation(value = "Find telefono by imei", notes = "Returns one info")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "IMEI Not Found")})
    public ResponseEntity<TelefonosResponseDTO> getTelefonoByIdImei(@PathVariable Long imei) {
		TelefonosResponseDTO telefonosDTO = telefonosFacade.getTelefonoByImei(imei);
		if (null == telefonosDTO) {
			return new ResponseEntity<TelefonosResponseDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TelefonosResponseDTO>(telefonosDTO, HttpStatus.OK);
	}
	
	@GetMapping("/telefonos")
	@ApiOperation(value = "Find all telefonos", notes = "Returns a collection of telefonos", response = Iterable.class)
	@ApiResponses(value = {@ApiResponse(code = 204, message = "Telefonos not found")})
	public ResponseEntity<List<TelefonosResponseDTO>> getAllTelefonos() {
		
		List<TelefonosResponseDTO> listTelefonos = telefonosFacade.getAllTelefonos();
		if (null == listTelefonos) {
			return new ResponseEntity<List<TelefonosResponseDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TelefonosResponseDTO>>(listTelefonos, HttpStatus.OK);
		
	}
	
	@PostMapping("/telefonos")
	@ApiOperation(value = "Save Info", notes = "Update a info")
    @ApiResponses({@ApiResponse(code = 201, message = "Successful save telefonos")})
	public ResponseEntity<TelefonosResponseDTO> updateTelefonos(@RequestBody @Valid TelefonosRequestDTO telefonosRequest) {
		TelefonosResponseDTO telefonosResponse = telefonosFacade.saveTelefonos(telefonosRequest);
		return new ResponseEntity<TelefonosResponseDTO>(telefonosResponse, HttpStatus.CREATED);
    }
	
	@PutMapping("/telefonos/{id}")
//	//@ResponseStatus(value = {@ApiResponse(code = 404, message = "Folios Not Found")})
//	//@ApiResponses(value = HttpStatus.OK, reason="Customer Deleted")
//	/*@ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    })*/
	public ResponseEntity<TelefonosResponseDTO> updateTelefonos(@PathVariable Long id, @RequestBody @Valid TelefonosRequestDTO telefonosRequest) {
		
		TelefonosResponseDTO telefonosDTO = telefonosFacade.getTelefonoById(id);
		if (telefonosDTO == null) {
			return new ResponseEntity<TelefonosResponseDTO>(HttpStatus.NOT_FOUND);
		}
		TelefonosResponseDTO telefonosResponse = telefonosFacade.updateTelefonos(telefonosRequest);
		return new ResponseEntity<TelefonosResponseDTO>(telefonosResponse, HttpStatus.OK);
    }
	
	@DeleteMapping("/telefonos/{id}")
	public ResponseEntity<String> deleteTelefonos(@PathVariable Long id) {
		TelefonosResponseDTO telefonosDTO = telefonosFacade.getTelefonoById(id);
		if (telefonosDTO == null) {
			return new ResponseEntity<String>("Telefono no encontrado!", HttpStatus.NOT_FOUND);
		}
		telefonosFacade.deleteTelefonos(id);
		return new ResponseEntity<String>("Telefono borrado correctamente!", HttpStatus.OK);
	}

}
