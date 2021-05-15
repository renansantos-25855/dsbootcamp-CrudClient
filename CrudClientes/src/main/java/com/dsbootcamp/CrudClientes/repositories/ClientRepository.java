package com.dsbootcamp.CrudClientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsbootcamp.CrudClientes.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	
}
