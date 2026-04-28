package com.integrador.solfecon.Modelo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "detallecotizacion")

public class MDetallecotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer iddetallecotizacion;

    @Column(nullable = false)
    Integer idcotizacion;

    @Column(nullable = false)
    Integer idproducto;

    @Column(nullable = false)
    Integer cantidad;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal preciounitario;

    //Relaciones

    @ManyToOne
    @JoinColumn(name="pkdetallecotizacionproducto",referencedColumnName = "idproducto")
    @JsonBackReference
    MProducto mProducto;

    @ManyToOne
    @JoinColumn(name="pkdetallecotizacioncotizacion",referencedColumnName = "idcotizacion")
    @JsonBackReference
    MCotizacion mCotizacion;

    public MDetallecotizacion(Integer iddetallecotizacion, Integer idcotizacion, Integer idproducto, Integer cantidad, BigDecimal preciounitario) {
        this.iddetallecotizacion = iddetallecotizacion;
        this.idcotizacion = idcotizacion;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
    }

    public MDetallecotizacion() {
    }

    public Integer getIddetallecotizacion() {
        return iddetallecotizacion;
    }

    public void setIddetallecotizacion(Integer iddetallecotizacion) {
        this.iddetallecotizacion = iddetallecotizacion;
    }

    public Integer getIdcotizacion() {
        return idcotizacion;
    }

    public void setIdcotizacion(Integer idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(BigDecimal preciounitario) {
        this.preciounitario = preciounitario;
    }
}