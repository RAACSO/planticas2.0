package com.edu.cibertec.repository;

import org.springframework.data.repository.CrudRepository;

import com.edu.cibertec.model.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{
    
}
