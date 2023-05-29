package com.edu.cibertec.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.edu.cibertec.model.Factura;
import com.edu.cibertec.service.impl.IFacturaService;

import jakarta.validation.Valid;



@Controller
@SessionAttributes("factura")
public class FacturaControllers {
        
        @Autowired
        private IFacturaService facturaService;
    
        @RequestMapping(value = "/listarFactura", method = RequestMethod.GET)
        public String listar(Model model){
            model.addAttribute("titulo", "Listado de Facturas");
            model.addAttribute("facturas",facturaService.findAll());
            return "listarFactura";
        }
    
        
    
        @RequestMapping(value = "/formfactura")
        public String creara(Map<String,Object>model){
            Factura factura = new Factura();
            model.put("factura", factura);
            model.put("titulo", "Formulario de Factura");
            return "formFactura";
        }


    
        @RequestMapping(value = "/formfactura",method = RequestMethod.POST)
        public String guardarA(@Valid Factura factura,BindingResult result, Model model, SessionStatus status){
            if (result.hasErrors()) {
                model.addAttribute("titulo","Formulario del Factura");
                return "formFactura";
            }
            facturaService.save(factura);
            status.setComplete();
            return "redirect:listarFactura";
        }

}
