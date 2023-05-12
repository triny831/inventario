package com.konex.PruebaTecnica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konex.PruebaTecnica.model.Medicamento;
import com.konex.PruebaTecnica.repository.IMedicamentoRepository;
import com.konex.PruebaTecnica.service.IMedicamentoService;
@Service
public class MedicamentoServiceImpl implements IMedicamentoService {
	@Autowired
	IMedicamentoRepository repo;

	@Override
	public List<Medicamento> listar() {
		return repo.findAll();
	}

	@Override
	public Medicamento registrar(Medicamento medicamento) {
		return repo.save(medicamento);
	}

	@Override
	public Medicamento actualizar(Medicamento medicamento) {
		return repo.save(medicamento);
	}

	@Override
	public void eliminar(Integer codigo) {
		repo.deleteById(codigo);
	}

	@Override
	public Medicamento ListarPorId(Integer codigo) {
		return repo.findById(codigo).orElse(null);
	}

}
