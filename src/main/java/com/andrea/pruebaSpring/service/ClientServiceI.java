package com.andrea.pruebaSpring.service;

import java.util.List;

import com.andrea.pruebaSpring.entity.Client;

public interface ClientServiceI {

	Client guardarCliente(Client cliente);

	List<Client> verTodosClientes();

	List<Client> buscarNombreApellidos(String nombre, String apellido);

	void borrarCliente(Client cliente);

	Client buscarPorId(Long id);

	Client crearCliente(Client cliente);

	Client actualizarCliente(Client cliente);
}
