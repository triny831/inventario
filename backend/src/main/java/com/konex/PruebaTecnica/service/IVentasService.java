package com.konex.PruebaTecnica.service;

import java.util.List;

import com.konex.PruebaTecnica.model.Ventas;

public interface IVentasService {
	List<Ventas>listar();
	Ventas registrar(Ventas ventas);
	Ventas actualizar(Ventas ventas);
	void eliminar(Integer codigo);
	Ventas ListarPorId(Integer codigo);
}
