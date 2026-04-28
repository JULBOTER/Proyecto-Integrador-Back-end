package com.integrador.solfecon.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cotizacion")

public class MCotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idcotizacion;

    @Column(nullable = false)
    LocalDateTime fecha;

    @Column(length = 15, nullable = false)
    String idecliente;


    //Relaciones

    @ManyToOne
    @JoinColumn(name="pkcotizacion",referencedColumnName = "idecliente")
    @JsonBackReference
    MCliente mCliente;

    @OneToMany(mappedBy = "mCotizacion")
    @JsonManagedReference
    List<MDetallecotizacion> mDetallecotizacion;

    public MCotizacion(Integer idcotizacion, LocalDateTime fecha, String idecliente) {
        this.idcotizacion = idcotizacion;
        this.fecha = fecha;
        this.idecliente = idecliente;



    }

    public MCotizacion() {
    }

    public Integer getIdcotizacion() {
        return idcotizacion;
    }

    public void setIdcotizacion(Integer idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getIdecliente() {
        return idecliente;
    }

    public void setIdecliente(String idecliente) {
        this.idecliente = idecliente;
    }
}