package com.integrador.solfecon.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detallecotizacion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MDetallecotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer iddetallecotizacion;

    @Column(nullable = false)
    Integer idcotizacion;

    @Column(nullable = false)
    Integer idproducto;

    @Column(nullable = false)
    Integer cantidad;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal preciounitario;

    // ✅ Campo "mProducto" — referenciado por mappedBy en MProducto
    @ManyToOne
    @JoinColumn(name = "pkdetallecotizacionproducto", referencedColumnName = "idproducto")
    @JsonIgnoreProperties("mDetallecotizacion")
    MProducto mProducto;

    // ✅ Campo "mCotizacion" — referenciado por mappedBy en MCotizacion
    @ManyToOne
    @JoinColumn(name = "pkdetallecotizacioncotizacion", referencedColumnName = "idcotizacion")
    @JsonIgnoreProperties("mDetallecotizacion")
    MCotizacion mCotizacion;

    public MDetallecotizacion(Integer iddetallecotizacion, Integer idcotizacion,
                              Integer idproducto, Integer cantidad, BigDecimal preciounitario) {
        this.iddetallecotizacion = iddetallecotizacion;
        this.idcotizacion = idcotizacion;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
    }

    public MDetallecotizacion() {}

    public Integer getIddetallecotizacion() { return iddetallecotizacion; }
    public void setIddetallecotizacion(Integer v) { this.iddetallecotizacion = v; }
    public Integer getIdcotizacion() { return idcotizacion; }
    public void setIdcotizacion(Integer v) { this.idcotizacion = v; }
    public Integer getIdproducto() { return idproducto; }
    public void setIdproducto(Integer v) { this.idproducto = v; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer v) { this.cantidad = v; }
    public BigDecimal getPreciounitario() { return preciounitario; }
    public void setPreciounitario(BigDecimal v) { this.preciounitario = v; }
}