package com.konex.PruebaTecnica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konex.PruebaTecnica.model.Ventas;
import com.konex.PruebaTecnica.repository.IVentasRepository;
import com.konex.PruebaTecnica.service.IVentasService;
@Service
public class VentasServiceImpl implements IVentasService{
	@Autowired
	IVentasRepository repo;
	@Override
	public List<Ventas> listar() {
		return repo.findAll();
	}

	@Override
	public Ventas registrar(Ventas ventas) {
		return repo.save(ventas);
	}

	@Override
	public Ventas actualizar(Ventas ventas) {
		return repo.save(ventas);
	}

	@Override
	public void eliminar(Integer codigo) {
		repo.deleteById(codigo);
		
	}

	@Override
	public Ventas ListarPorId(Integer codigo) {
		return repo.findById(codigo).orElse(null);
	}

}
