package com.konex.PruebaTecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konex.PruebaTecnica.model.Medicamento;
import com.konex.PruebaTecnica.service.IMedicamentoService;
@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {
	@Autowired
	private IMedicamentoService service;
	@GetMapping
	public ResponseEntity<List<Medicamento>> listar() {
		List<Medicamento> obj = service.listar();
		return new ResponseEntity<List<Medicamento>>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Medicamento> registrar(@RequestBody Medicamento medicamento) {
		Medicamento obj = service.registrar(medicamento);
		return new ResponseEntity<Medicamento>(obj, HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Medicamento> actualizar(@RequestBody Medicamento medicamento) {
		Medicamento obj = service.actualizar(medicamento);
		return new ResponseEntity<Medicamento>(obj, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id")Integer id) throws Exception{
		Medicamento obj = service.ListarPorId(id);
		if (obj == null) {
			throw new Exception("No se encontro id");
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	public ResponseEntity<Medicamento> listarPorId(@PathVariable("id") Integer codigo) throws Exception{
		Medicamento obj = service.ListarPorId(codigo);
		if (obj == null) {
			throw new Exception("No se encontro id");
		}
		return new ResponseEntity<Medicamento>(obj, HttpStatus.OK);
	}
}
