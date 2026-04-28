package com.integrador.solfecon.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "productos")
public class MProducto {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idproducto; // Aquí va el código del producto (ej: PROD-001)

    @Column(length = 100, nullable = false)
    String descripcionprod;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal precio;

    @Column(nullable = false)
    Boolean estado;

    @Column(length = 255, nullable = false)
    String imagen;

    @Column(name = "linea", nullable = false)
    Integer idlinea;

    @Column(name = "promocion", nullable = false)
    Integer idpromocion;

//Relaciones

    @ManyToOne
    @JoinColumn(name="pkproductolinea",referencedColumnName = "idlinea")
    @JsonBackReference
    MLinea mLinea;

    @ManyToOne
    @JoinColumn(name="pkproductopromocion",referencedColumnName = "idpromocion")
    @JsonBackReference
    MPromocion mPromocion;

    @OneToMany(mappedBy = "mProducto")
    @JsonManagedReference
    List<MDetallecotizacion> mDetallecotizacion;



// Constructores


    public MProducto(Integer idproducto, String descripcionprod, BigDecimal precio, Boolean estado, String imagen, Integer idlinea, Integer idpromocion) {
        this.idproducto = idproducto;
        this.descripcionprod = descripcionprod;
        this.precio = precio;
        this.estado = estado;
        this.imagen = imagen;
        this.idlinea = idlinea;
        this.idpromocion = idpromocion;
    }

    public MProducto() {
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcionprod() {
        return descripcionprod;
    }

    public void setDescripcionprod(String descripcionprod) {
        this.descripcionprod = descripcionprod;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(Integer idlinea) {
        this.idlinea = idlinea;
    }

    public Integer getIdpromocion() {
        return idpromocion;
    }

    public void setIdpromocion(Integer idpromocion) {
        this.idpromocion = idpromocion;
    }
}

