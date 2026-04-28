package com.integrador.solfecon.Servicio;

import com.integrador.solfecon.Modelo.MCliente;
import com.integrador.solfecon.Repositorio.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;


@Service
public class SCliente {

    // Inyectar la interface del Repositorio
    @Autowired
    ICliente iCliente;

    // Constructor
    public SCliente(ICliente iCliente) {
        this.iCliente = iCliente;
    }

    // Adicionar un cliente
    public MCliente adicionarCliente(MCliente mCliente) throws Exception{
        try{
            return iCliente.save(mCliente);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general de clientes
    public List<MCliente> consultaGeneralCliente() throws Exception{
        try{
            return iCliente.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por Id de clientes
    public MCliente consultaIndividualId(String idecliente) throws Exception{
        try{
            Optional<MCliente> registroEncontrado=iCliente.findById(idecliente);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Cliente no registrado");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por nombre del cliente
    public List<MCliente> consultaIndividualNombre(String nomcliente) throws Exception{
        try{
            return iCliente.findByNomcliente(nomcliente);
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar los datos de un cliente
    public MCliente modificarCliente (String idecliente,MCliente mCliente) throws Exception{
        try {
            Optional<MCliente> registroEncontrado=iCliente.findById(idecliente);
            if (registroEncontrado.isPresent()){
                MCliente nuevoRegistro=registroEncontrado.get();
                nuevoRegistro.setIdecliente(mCliente.getIdecliente());
                nuevoRegistro.setNomcliente(mCliente.getNomcliente());

                return iCliente.save(nuevoRegistro);
            }else{
                throw new Exception("No se puede modificar porque cliente no esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar un cliente
    public Boolean eliminarCliente(String idecliente) throws Exception{
        try{
            Optional<MCliente> registroEncontrada=iCliente.findById(idecliente);
            if (registroEncontrada.isPresent()){
                iCliente.deleteById(idecliente);
                return true;
            }else{
                throw new Exception("No se pudo eliminar porque cliente no esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}


