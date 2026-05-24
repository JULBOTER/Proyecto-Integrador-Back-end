package com.integrador.solfecon.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "linea")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MLinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idlinea;

    @Column(length = 55, nullable = false)
    String descripcionlinea;

    // ✅ LONGTEXT — acepta imágenes Base64 de cualquier tamaño
    @Column(columnDefinition = "LONGTEXT")
    String imagen;

    @OneToMany(mappedBy = "mLinea")
    @JsonIgnoreProperties("mLinea")
    List<MProducto> mProducto;

    public MLinea(Integer idlinea, String descripcionlinea, String imagen) {
        this.idlinea = idlinea;
        this.descripcionlinea = descripcionlinea;
        this.imagen = imagen;
    }

    public MLinea() {}

    public Integer getIdlinea() { return idlinea; }
    public void setIdlinea(Integer idlinea) { this.idlinea = idlinea; }
    public String getDescripcionlinea() { return descripcionlinea; }
    public void setDescripcionlinea(String descripcionlinea) { this.descripcionlinea = descripcionlinea; }
    public String getImagen() { return (imagen != null && !imagen.isBlank()) ? imagen : "sin_imagen"; }
    public void setImagen(String imagen) { this.imagen = imagen; }
}