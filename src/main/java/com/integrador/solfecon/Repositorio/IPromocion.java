package com.integrador.solfecon.Repositorio;

import com.integrador.solfecon.Modelo.MPromocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPromocion extends JpaRepository<MPromocion,Integer> {
    List<MPromocion> findByDescripcionprom(String Descripcionprom);

}
