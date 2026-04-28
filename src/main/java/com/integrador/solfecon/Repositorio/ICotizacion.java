package com.integrador.solfecon.Repositorio;


import com.integrador.solfecon.Modelo.MCotizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICotizacion extends JpaRepository<MCotizacion,Integer> {
    List<MCotizacion> findByIdecliente (String Idecliente);
}
