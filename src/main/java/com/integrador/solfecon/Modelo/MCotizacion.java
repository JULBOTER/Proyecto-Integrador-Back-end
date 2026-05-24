package com.integrador.solfecon.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cotizacion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MCotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idcotizacion;

    @Column(nullable = false)
    LocalDateTime fecha;

    @Column(length = 15, nullable = false)
    String idecliente;

    // ✅ Este campo DEBE llamarse "mCliente" — es lo que referencia mappedBy en MCliente
    @ManyToOne
    @JoinColumn(name = "pkcotizacion", referencedColumnName = "idecliente")
    @JsonIgnoreProperties("mCotizacion")
    MCliente mCliente;

    // ✅ Este campo DEBE llamarse "mCotizacion" — es lo que referencia mappedBy en MDetallecotizacion
    @OneToMany(mappedBy = "mCotizacion")
    @JsonIgnoreProperties("mCotizacion")
    List<MDetallecotizacion> mDetallecotizacion;

    public MCotizacion(Integer idcotizacion, LocalDateTime fecha, String idecliente) {
        this.idcotizacion = idcotizacion;
        this.fecha = fecha;
        this.idecliente = idecliente;
    }

    public MCotizacion() {}

    public Integer getIdcotizacion() { return idcotizacion; }
    public void setIdcotizacion(Integer idcotizacion) { this.idcotizacion = idcotizacion; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public String getIdecliente() { return idecliente; }
    public void setIdecliente(String idecliente) { this.idecliente = idecliente; }
}