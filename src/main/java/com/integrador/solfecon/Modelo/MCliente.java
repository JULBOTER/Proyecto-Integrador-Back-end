package com.integrador.solfecon.Modelo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.List;


@Entity
@Table(name="cliente")

public class MCliente {


    // Atributos
    @Id
    @Column(length = 15, nullable = false)
    String idecliente;
    @Column(length = 100, nullable = false)
    String nomcliente;

    // Relaciones

    @OneToMany(mappedBy = "mCliente")
    @JsonManagedReference
    List<MCotizacion> mCotizacion;


    // Constructores


    public MCliente(String idecliente, String nomcliente) {
        this.idecliente = idecliente;
        this.nomcliente = nomcliente;
    }

    public MCliente() {
    }

//Encapsulamiento


    public String getIdecliente() {
        return idecliente;
    }

    public void setIdecliente(String idecliente) {
        this.idecliente = idecliente;
    }

    public String getNomcliente() {
        return nomcliente;
    }

    public void setNomcliente(String nomcliente) {
        this.nomcliente = nomcliente;
    }
}


