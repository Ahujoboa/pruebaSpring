package com.andrea.pruebaSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andrea.pruebaSpring.entity.Client;
import com.andrea.pruebaSpring.service.ClientServiceI;

import io.swagger.annotations.ApiOperation;

// La anotación @ApiOperation indica que se va a realizar una operación http contra una ruta.

@RestController
public class ClientController {

	/**
	 * Url de acceso http://localhost:8080/api/clientes
	 */

	private final String URL = "/api/clientes";

	@Autowired
	private ClientServiceI clienteService;

	/**
	 *
	 * Crear un cliente pasado por JSON
	 */
	@PostMapping(URL)
	@ApiOperation("Crear cliente")
	public ResponseEntity<Client> crearCliente(@RequestBody Client cliente) {
		
		if (cliente.getId()!= null)
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(clienteService.crearCliente(cliente));
	}

	/**
	 * Actualizar un cliente
	 */
	@PutMapping(URL)
	@ApiOperation("Actualizar cliente")
	public ResponseEntity<Client> actualizarCliente(@RequestBody Client cliente) {
		if (clienteService.buscarPorId(cliente.getId()) == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clienteService.actualizarCliente(cliente));
	}

	/**
	 * Ver todos los clientes
	 */
	@GetMapping(URL)
	@ApiOperation("Ver todos los clientes")
	public ResponseEntity<List<Client>> verClientes() {
		List<Client> clientes = clienteService.verTodosClientes();
		if (clientes.size() > 0)
			return ResponseEntity.ok(clientes);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(URL + "/{id}")
	@ApiOperation("Ver cliente por ID")
	public ResponseEntity<Client> verCliente(@PathVariable Long id) {
		if (clienteService.buscarPorId(id) != null)
			return ResponseEntity.ok(clienteService.buscarPorId(id));
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(URL + "/{id}")
	@ApiOperation("Borrar cliente por ID")
	public ResponseEntity<Client> borrarCliente(@PathVariable Long id) {
		Client cliente = clienteService.buscarPorId(id);

		if (cliente == null)
			return ResponseEntity.notFound().build();

		clienteService.borrarCliente(clienteService.buscarPorId(id));
		return ResponseEntity.noContent().build();
	}

}
