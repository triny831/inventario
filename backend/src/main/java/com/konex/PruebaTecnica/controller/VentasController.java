package com.konex.PruebaTecnica.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.konex.PruebaTecnica.model.Ventas;
import com.konex.PruebaTecnica.service.IVentasService;


@RestController
@RequestMapping("/ventas")
public class VentasController {

	@Autowired
	IVentasService service;

	@GetMapping
	public ResponseEntity<List<Ventas>> listar() {
		List<Ventas> obj = service.listar();
		return new ResponseEntity<List<Ventas>>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> registrar(@RequestBody Ventas ventas) {
		Ventas obj = service.registrar(ventas);
			URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVenta()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@PutMapping
	public ResponseEntity<Ventas> actualizar(@RequestBody Ventas ventas) {
		Ventas obj = service.actualizar(ventas);
		return new ResponseEntity<Ventas>(obj, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ventas> listarPorId(@PathVariable("id") Integer codigo) throws Exception {
		Ventas obj = service.ListarPorId(codigo);
		if (obj == null) {
			throw new Exception("No se encontro id");
		}
		service.eliminar(codigo);
		return new ResponseEntity<Ventas>(obj, HttpStatus.OK);
	}

}
