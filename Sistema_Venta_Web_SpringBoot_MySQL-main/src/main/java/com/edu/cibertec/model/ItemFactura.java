package com.edu.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "item_factura")
public class ItemFactura {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El total no puede estar vacio")
    @Column(nullable = true)
    private String total;

    @NotEmpty(message = "La cantidad no puede estar vacio")
    @Column(nullable = true)
    private String cantidad;

    @JoinColumn(name = "id_factura")
    @OneToOne(fetch = FetchType.LAZY)
    private Factura factura;

    @JoinColumn(name = "id_producto")
    @OneToOne(fetch = FetchType.LAZY)
    private Producto prodcuto;
}
