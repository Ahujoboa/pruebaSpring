package com.andrea.pruebaSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrea.pruebaSpring.entity.Client;
import com.andrea.pruebaSpring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientServiceI {

	@Autowired
	ClientRepository clienteRepository;

	/*
	 * public ClienteServiceImpl(ClienteRepository clienteRepository) {
	 * this.clienteRepository = clienteRepository; }
	 */

	@Override
	public Client guardarCliente(Client cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public List<Client> verTodosClientes() {
		return this.clienteRepository.findAll();
	}

	@Override
	public List<Client> buscarNombreApellidos(String nombre, String apellido) {
		return this.clienteRepository.findByNombreAndApellidos(nombre, apellido);
	}

	@Override
	public void borrarCliente(Client cliente) {
		this.clienteRepository.delete(cliente);
	}

	@Override
	public Client buscarPorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public Client crearCliente(Client cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Client actualizarCliente(Client cliente) {
		return clienteRepository.save(cliente);
	}

}
