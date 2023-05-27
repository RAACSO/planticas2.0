package com.edu.cibertec.repository;

import org.springframework.data.repository.CrudRepository;

import com.edu.cibertec.model.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
    
}
