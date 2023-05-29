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
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    
    @Column(nullable = true)
    private String descripcion;

    
    @Column(nullable = true)
    private Float total;

    
    @JoinColumn(name = "id_cliente")
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Factura(Long id,String descripcion , Float total, Cliente cliente) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.total = total;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Factura() {
        super();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
