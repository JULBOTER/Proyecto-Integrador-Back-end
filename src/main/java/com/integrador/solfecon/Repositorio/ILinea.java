package com.integrador.solfecon.Repositorio;

import com.integrador.solfecon.Modelo.MLinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ILinea extends JpaRepository<MLinea,Integer> {
    List<MLinea> findByDescripcionlinea(String Descripcionlinea);
}
