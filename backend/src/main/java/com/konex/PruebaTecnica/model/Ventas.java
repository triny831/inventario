package com.konex.PruebaTecnica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class Ventas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdVenta")
	private Integer IdVenta;
	@Column(name = "FechaYHora")
	private String FechaYHora;
	@Column(name = "NombreM")
	private String NombreM;
	@Column(name = "Cantidad")
	private Integer Cantidad;
	@Column(name = "ValorU")
	private String ValorU;
	@Column(name = "ValorT")
	private Integer ValorT;

	public Integer getIdVenta() {
		return IdVenta;
	}

	public void setIdVenta(Integer idVenta) {
		IdVenta = idVenta;
	}

	public String getFechaYHora() {
		return FechaYHora;
	}

	public void setFechaYHora(String fechaYHora) {
		FechaYHora = fechaYHora;
	}

	public String getNombreM() {
		return NombreM;
	}

	public void setNombreM(String nombreM) {
		NombreM = nombreM;
	}

	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public String getValorU() {
		return ValorU;
	}

	public void setValorU(String valorU) {
		ValorU = valorU;
	}

	public Integer getValorT() {
		return ValorT;
	}

	public void setValorT(Integer valorT) {
		ValorT = valorT;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	@ManyToOne
	@JoinColumn(name = "idMedicamento")
	private Medicamento medicamento;
}
