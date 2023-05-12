package com.konex.PruebaTecnica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medicamento")
public class Medicamento {
	public Integer getIdMedicamento() {
		return IdMedicamento;
	}
	public void setIdMedicamento(Integer idMedicamento) {
		IdMedicamento = idMedicamento;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getLaboratorio() {
		return Laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		Laboratorio = laboratorio;
	}
	public String getFechaF() {
		return FechaF;
	}
	public void setFechaF(String fechaF) {
		FechaF = fechaF;
	}
	public String getFechaV() {
		return FechaV;
	}
	public void setFechaV(String fechaV) {
		FechaV = fechaV;
	}
	public Integer getStock() {
		return Stock;
	}
	public void setStock(Integer stock) {
		Stock = stock;
	}
	public Integer getValorU() {
		return ValorU;
	}
	public void setValorU(Integer valorU) {
		ValorU = valorU;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdMedicamento")
	private Integer IdMedicamento;
	@Column(name="Nombre",nullable=false)
	private String Nombre;
	@Column(name="Laboratorio",nullable=false)
	private String Laboratorio;
	@Column(name="FechaF")
	private String FechaF;
	@Column(name="FechaV")
	private String FechaV;
	@Column(name="Stock")
	private Integer Stock;
	@Column(name="ValorU")
	private Integer ValorU;

}
