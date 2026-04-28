package com.integrador.solfecon.Repositorio;

import com.integrador.solfecon.Modelo.MProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IProducto extends JpaRepository<MProducto,Integer> {
    List<MProducto> findByDescripcionprod(String Descripcionprod);
}
