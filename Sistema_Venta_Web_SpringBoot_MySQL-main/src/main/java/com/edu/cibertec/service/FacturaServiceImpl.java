package com.edu.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.cibertec.repository.IFacturaDao;
import com.edu.cibertec.service.impl.IFacturaService;
import com.edu.cibertec.model.Factura;



@Service
public class FacturaServiceImpl implements IFacturaService{

    @Autowired
    private IFacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll(){
        return (List<Factura>)facturaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Factura factura){
        facturaDao.save(factura);
    }

}
