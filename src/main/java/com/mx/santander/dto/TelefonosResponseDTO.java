/**
 * 
 */
package com.mx.santander.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author dmanzano
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelefonosResponseDTO implements Serializable {
	
	private static final long serialVersionUID = -6800406908903258299L;
	
public TelefonosResponseDTO() {};
	
	public TelefonosResponseDTO(long id_telefonos,
//			@NotNull(message = "El IMEI es requerido") @Size(max=15, message="El IMEI debe tener {max} caracteres") Long imei,
			@NotNull(message = "El IMEI es requerido") Long imei,
			@NotNull(message = "La marca es requerida") String nombre_marca,
			@NotNull(message = "El modelo es requerido") String modelo,
			@NotNull(message = "El nombre corto es requerido") String nombreCorto,
			@NotNull(message = "La fecha de creacion es requerida") Date fechaCreacion, long numeroCelular, String emailSoporte,
			boolean sistemaIos) {
		super();
		this.id_telefonos = id_telefonos;
		this.imei = imei;
		this.nombre_marca = nombre_marca;
		this.modelo = modelo;
		this.nombreCorto = nombreCorto;
		this.fechaCreacion = fechaCreacion;
		this.numeroCelular = numeroCelular;
		this.emailSoporte = emailSoporte;
		this.sistemaIos = sistemaIos;
	}
	
	private Long id_telefonos;
	@NotNull(message="El imei es requerido")
//	@Size(max=15, message="El IMEI debe tener {max} caracteres")
	private Long imei; // (requerido y de valor único )
	@NotNull(message="La marca es requerida")
	private String nombre_marca; // (requerido, validar caracteres especiales)
	@NotNull(message="El modelo es requerido")
	private String modelo; //(requerido, validar caracteres especiales)
	@NotNull(message="El nombre corto es requerido")
	private String nombreCorto; //(requerido, validar caracteres especiales)
	@NotNull(message="La fecha de creacion es requerida")
	private Date fechaCreacion; // (requerido, validar caracteres especiales)
	private long numeroCelular; // (opcional)
	private String emailSoporte; //(opcional, opcional si trae valor validar formato de Email)
	private boolean sistemaIos; // (Campo boleano)

	public Long getId_telefonos() {
		return id_telefonos;
	}

	public void setId_telefonos(Long id_telefonos) {
		this.id_telefonos = id_telefonos;
	}

	public Long getImei() {
		return imei;
	}

	public void setImei(Long imei) {
		this.imei = imei;
	}

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public long getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(long numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getEmailSoporte() {
		return emailSoporte;
	}

	public void setEmailSoporte(String emailSoporte) {
		this.emailSoporte = emailSoporte;
	}

	public boolean isSistemaIos() {
		return sistemaIos;
	}

	public void setSistemaIos(boolean sistemaIos) {
		this.sistemaIos = sistemaIos;
	}

	@Override
	public String toString() {
		return "TelefonosRequestDTO [id_telefonos=" + id_telefonos + ", imei=" + imei + ", nombre_marca=" + nombre_marca
				+ ", modelo=" + modelo + ", nombreCorto=" + nombreCorto + ", fechaCreacion=" + fechaCreacion
				+ ", numeroCelular=" + numeroCelular + ", emailSoporte=" + emailSoporte + ", sistemaIos=" + sistemaIos
				+ "]";
	}

}
