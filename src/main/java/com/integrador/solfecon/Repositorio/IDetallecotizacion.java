package com.integrador.solfecon.Repositorio;

import com.integrador.solfecon.Modelo.MDetallecotizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface IDetallecotizacion extends JpaRepository<MDetallecotizacion,Integer> {
    List<MDetallecotizacion> findByIdcotizacion (Integer idcotizacion);
}