package com.integrador.solfecon.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MCliente {

    @Id
    @Column(length = 15, nullable = false)
    String idecliente;

    @Column(length = 100, nullable = false)
    String nomcliente;

    // ✅ mappedBy = "mCliente" — debe coincidir exactamente con el campo en MCotizacion
    @OneToMany(mappedBy = "mCliente")
    @JsonIgnoreProperties("mCliente")
    List<MCotizacion> mCotizacion;

    public MCliente(String idecliente, String nomcliente) {
        this.idecliente = idecliente;
        this.nomcliente = nomcliente;
    }

    public MCliente() {}

    public String getIdecliente() { return idecliente; }
    public void setIdecliente(String idecliente) { this.idecliente = idecliente; }
    public String getNomcliente() { return nomcliente; }
    public void setNomcliente(String nomcliente) { this.nomcliente = nomcliente; }
}