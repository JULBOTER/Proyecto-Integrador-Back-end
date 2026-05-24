package com.integrador.solfecon.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "promocion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MPromocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idpromocion;

    @Column(length = 55, nullable = false)
    String descripcionprom;

    // ✅ LONGTEXT — acepta imágenes Base64 de cualquier tamaño
    @Column(columnDefinition = "LONGTEXT")
    String imagen;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal descuento;

    @OneToMany(mappedBy = "mPromocion")
    @JsonIgnoreProperties("mPromocion")
    List<MProducto> mProducto;

    public MPromocion(Integer idpromocion, String descripcionprom, String imagen, BigDecimal descuento) {
        this.idpromocion = idpromocion;
        this.descripcionprom = descripcionprom;
        this.imagen = imagen;
        this.descuento = descuento;
    }

    public MPromocion() {}

    public Integer getIdpromocion() { return idpromocion; }
    public void setIdpromocion(Integer idpromocion) { this.idpromocion = idpromocion; }
    public String getDescripcionprom() { return descripcionprom; }
    public void setDescripcionprom(String descripcionprom) { this.descripcionprom = descripcionprom; }
    public String getImagen() { return (imagen != null && !imagen.isBlank()) ? imagen : "sin_imagen"; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public BigDecimal getDescuento() { return descuento; }
    public void setDescuento(BigDecimal descuento) { this.descuento = descuento; }
}