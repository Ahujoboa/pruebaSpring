package com.andrea.pruebaSpring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty("Clave autoincremental de tipo Long")

	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "fecha")
	private LocalDate fecha;
	@Column(name = "dni")
	private String dni;




}
