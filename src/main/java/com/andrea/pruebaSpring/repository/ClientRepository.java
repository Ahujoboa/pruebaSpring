package com.andrea.pruebaSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrea.pruebaSpring.entity.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	List<Client> findByNombreAndApellidos(String nombre, String apellidos);
	Optional<Client> findFirstByDni(String dni);
	
}
