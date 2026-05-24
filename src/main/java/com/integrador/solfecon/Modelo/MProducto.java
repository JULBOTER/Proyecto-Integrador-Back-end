package com.integrador.solfecon.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "productos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idproducto;

    @Column(length = 100, nullable = false)
    String descripcionprod;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal precio;

    @Column(nullable = false)
    Boolean estado;

    // ✅ LONGTEXT — acepta imágenes Base64 de cualquier tamaño
    @Column(columnDefinition = "LONGTEXT")
    String imagen;

    @Column(name = "linea", nullable = false)
    Integer idlinea;

    @Column(name = "promocion", nullable = false)
    Integer idpromocion;

    @ManyToOne
    @JoinColumn(name = "pkproductolinea", referencedColumnName = "idlinea")
    @JsonIgnoreProperties("mProducto")
    MLinea mLinea;

    @ManyToOne
    @JoinColumn(name = "pkproductopromocion", referencedColumnName = "idpromocion")
    @JsonIgnoreProperties("mProducto")
    MPromocion mPromocion;

    @OneToMany(mappedBy = "mProducto")
    @JsonIgnoreProperties("mProducto")
    List<MDetallecotizacion> mDetallecotizacion;

    public MProducto(Integer idproducto, String descripcionprod, BigDecimal precio,
                     Boolean estado, String imagen, Integer idlinea, Integer idpromocion) {
        this.idproducto = idproducto;
        this.descripcionprod = descripcionprod;
        this.precio = precio;
        this.estado = estado;
        this.imagen = imagen;
        this.idlinea = idlinea;
        this.idpromocion = idpromocion;
    }

    public MProducto() {}

    public Integer getIdproducto() { return idproducto; }
    public void setIdproducto(Integer idproducto) { this.idproducto = idproducto; }
    public String getDescripcionprod() { return descripcionprod; }
    public void setDescripcionprod(String descripcionprod) { this.descripcionprod = descripcionprod; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
    public String getImagen() { return (imagen != null && !imagen.isBlank()) ? imagen : "sin_imagen"; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public Integer getIdlinea() { return idlinea; }
    public void setIdlinea(Integer idlinea) { this.idlinea = idlinea; }
    public Integer getIdpromocion() { return idpromocion; }
    public void setIdpromocion(Integer idpromocion) { this.idpromocion = idpromocion; }
}