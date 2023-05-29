package com.edu.cibertec.service.impl;

import java.util.List;

import com.edu.cibertec.model.Factura;

public interface IFacturaService {
    
    public List<Factura> findAll();

    public void save(Factura factura);

}
