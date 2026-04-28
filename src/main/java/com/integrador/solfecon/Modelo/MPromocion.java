package com.integrador.solfecon.Modelo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "promocion")

public class MPromocion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idpromocion;
    @Column(length = 55, nullable = false)
    String descripcionprom;

    @Column(length = 255, nullable = false)
    String imagen;

    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal descuento;

    //Relaciones

    @OneToMany(mappedBy = "mPromocion")
    @JsonManagedReference
    List<MProducto> mProducto;

    //Constructores


    public MPromocion(Integer idpromocion, String descripcionprom, String imagen, BigDecimal descuento) {
        this.idpromocion = idpromocion;
        this.descripcionprom = descripcionprom;
        this.imagen = imagen;
        this.descuento = descuento;
    }

    public MPromocion() {
    }

    //Encapsulamiento


    public Integer getIdPromocion() {
        return idpromocion;
    }

    public void setIdPromocion(Integer idpromocion) {
        this.idpromocion = idpromocion;
    }

    public String getDescripcionprom() {
        return descripcionprom;
    }

    public void setDescripcionprom(String descripcionprom) {
        this.descripcionprom = descripcionprom;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }
}

