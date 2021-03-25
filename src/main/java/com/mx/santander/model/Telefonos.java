/**
 * 
 */
package com.mx.santander.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author dmanzano
 *
 */
@Entity(name = "telefonos")
@Table(name = "telefonos")
public class Telefonos implements Serializable {
	
	private static final long serialVersionUID = 3431861240038494711L;
	
	public Telefonos() {}

	public Telefonos(Long id_telefonos, Long imei, String nombre_marca, String modelo, String nombreCorto,
			Date fechaCreacion, long numeroCelular, String emailSoporte, boolean sistemaIos) {
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



	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefonos_generator")
	@SequenceGenerator(name="telefonos_generator", sequenceName = "telefonos_sequence", allocationSize = 1)
	private Long id_telefonos;
	
	@Column(name = "imei")
	private Long imei;
	
	@Column(name = "nombre_marca")
	private String nombre_marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "nombre_corto")
	private String nombreCorto;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "numero_celular")
	private long numeroCelular;
	
	@Column(name = "email_soporte")
	private String emailSoporte;
	
	@Column(name = "sistema_ios")
	private boolean sistemaIos;
	
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
		return "Telefonos [id_telefonos=" + id_telefonos + ", imei=" + imei + ", nombre_marca=" + nombre_marca + ", modelo="
				+ modelo + ", nombreCorto=" + nombreCorto + ", fechaCreacion=" + fechaCreacion + ", numeroCelular="
				+ numeroCelular + ", emailSoporte=" + emailSoporte + ", sistemaIos=" + sistemaIos + "]";
	}

}
