package com.integrador.solfecon.Servicio;

import com.integrador.solfecon.Modelo.MCotizacion;
import com.integrador.solfecon.Repositorio.ICotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SCotizacion {

    //Inyectar la interface del Repositorio
    @Autowired
    ICotizacion iCotizacion;
    //Constructor

    public SCotizacion(ICotizacion iCotizacion) {
        this.iCotizacion = iCotizacion;
    }


    // Adicionar un cotizacion
    public MCotizacion adicionarCotizacion(MCotizacion mCotizacion) throws Exception {
        try {
            return iCotizacion.save(mCotizacion);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general de cotizaciones
    public List<MCotizacion> consultaGeneralCotizacion() throws Exception{
        try{
            return iCotizacion.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por Id de cotizaciones
    public MCotizacion consultaIndividualId(Integer idcotizacion) throws Exception{
        try{
            Optional<MCotizacion> registroEncontrado=iCotizacion.findById(idcotizacion);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Cotización  no registrada");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por nombre del cliente
    public List<MCotizacion> consultaIndividualidecliente(String idecliente) throws Exception{
        try{
            return iCotizacion.findByIdecliente(idecliente);
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar los datos de una cotizacion
    public MCotizacion modificarCotizacion (Integer idcotizacion,MCotizacion mCotizacion) throws Exception{
        try {
            Optional<MCotizacion> registroEncontrado=iCotizacion.findById(idcotizacion);
            if (registroEncontrado.isPresent()){
                MCotizacion nuevoRegistro=registroEncontrado.get();
                nuevoRegistro.setIdcotizacion(mCotizacion.getIdcotizacion());
                nuevoRegistro.setFecha(mCotizacion.getFecha());
                nuevoRegistro.setIdecliente(mCotizacion.getIdecliente());


                return iCotizacion.save(nuevoRegistro);
            }else{
                throw new Exception("No se puede modificar porque la cotizacion no esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar una cotizacion
    public Boolean eliminarCotizacion(Integer idcotizacion) throws Exception{
        try{
            Optional<MCotizacion> registroEncontrada=iCotizacion.findById(idcotizacion);
            if (registroEncontrada.isPresent()){
                iCotizacion.deleteById(idcotizacion);
                return true;
            }else{
                throw new Exception("No se pudo eliminar porque la cotizacion no esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}



