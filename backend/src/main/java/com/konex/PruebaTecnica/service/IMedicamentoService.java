package com.konex.PruebaTecnica.service;

import java.util.List;

import com.konex.PruebaTecnica.model.Medicamento;

public interface IMedicamentoService {
	List<Medicamento>listar();
	Medicamento registrar(Medicamento medicamento);
	Medicamento actualizar(Medicamento medicamento);
	void eliminar(Integer codigo);
	Medicamento ListarPorId(Integer codigo);
	
}
