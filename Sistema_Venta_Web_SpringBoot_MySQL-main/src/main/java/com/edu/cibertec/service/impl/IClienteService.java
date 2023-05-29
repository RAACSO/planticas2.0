package com.edu.cibertec.service.impl;

import java.util.List;

import com.edu.cibertec.model.Cliente;

public interface IClienteService {
    
    public List<Cliente> findAll();

    public void save(Cliente cliente);

    public Cliente findById(Long id);

    public void delete(Long id);
}
