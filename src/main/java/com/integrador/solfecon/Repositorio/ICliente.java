package com.integrador.solfecon.Repositorio;

import com.integrador.solfecon.Modelo.MCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICliente extends JpaRepository<MCliente,String> {
    List<MCliente> findByNomcliente (String Nomcliente);
}
