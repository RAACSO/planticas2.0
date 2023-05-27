package com.edu.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.cibertec.service.impl.IClienteService;
import com.edu.cibertec.model.Cliente;
import com.edu.cibertec.repository.IClienteDao;



@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll(){
        return (List<Cliente>)clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente){
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id){
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id){
        clienteDao.deleteById(id);
    }
}

