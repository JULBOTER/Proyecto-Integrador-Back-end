package com.integrador.solfecon.Modelo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "linea")
public class MLinea {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idlinea;

    @Column(length = 55, nullable = false)
    String descripcionlinea;

    @Column(length = 255, nullable = false)
    String imagen;

    //Relaciones


    @OneToMany(mappedBy = "mLinea")
    @JsonManagedReference
    List<MProducto> mProducto;

    //Constructores


    public MLinea(Integer idlinea, String descripcionlinea, String imagen) {
        this.idlinea = idlinea;
        this.descripcionlinea = descripcionlinea;
        this.imagen = imagen;
    }

    public MLinea() {
    }

    public Integer getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(Integer idlinea) {
        this.idlinea = idlinea;
    }

    public String getDescripcionlinea() {
        return descripcionlinea;
    }

    public void setDescripcionlinea(String descripcionlinea) {
        this.descripcionlinea = descripcionlinea;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}