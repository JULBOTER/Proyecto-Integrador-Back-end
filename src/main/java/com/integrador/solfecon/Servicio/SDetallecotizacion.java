package com.integrador.solfecon.Servicio;

import com.integrador.solfecon.Modelo.MDetallecotizacion;
import com.integrador.solfecon.Repositorio.IDetallecotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SDetallecotizacion {
    //Inyectar la interface del Repositorio
    @Autowired
    IDetallecotizacion iDetallecotizacion;
    //Constructor

    public SDetallecotizacion(IDetallecotizacion iDetallecotizacion) {
        this.iDetallecotizacion = iDetallecotizacion;
    }

    // Adicionar detalle cotizacion
    public MDetallecotizacion adicionarDetallecotizacion(MDetallecotizacion mDetallecotizacion) throws Exception {
        try {
            return iDetallecotizacion.save(mDetallecotizacion);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general de detalle cotizaciones
    public List<MDetallecotizacion> consultaGeneralDetallecotizacion() throws Exception{
        try{
            return iDetallecotizacion.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Consulta individual por Id de detalle cotizacion

    public MDetallecotizacion consultaIndividualId(Integer iddetallecotizacion) throws Exception{
        try{
            Optional<MDetallecotizacion> registroEncontrado=iDetallecotizacion.findById(iddetallecotizacion);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Id de detalle cotizacion no registrada ");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por id cotizacion
    public List<MDetallecotizacion> consultaIndividualidcotizacion(Integer idcotizacion) throws Exception{
        try{
            return iDetallecotizacion.findByIdcotizacion(idcotizacion);
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    // Modificar los datos de una cotizacion
    public MDetallecotizacion modificarDetallecotizacion (Integer iddetallecotizacion,MDetallecotizacion mDetallecotizacion) throws Exception{
        try {
            Optional<MDetallecotizacion> registroEncontrado=iDetallecotizacion.findById(iddetallecotizacion);
            if (registroEncontrado.isPresent()){
                MDetallecotizacion nuevoRegistro=registroEncontrado.get();
                nuevoRegistro.setIddetallecotizacion(mDetallecotizacion.getIddetallecotizacion());
                nuevoRegistro.setIdcotizacion(mDetallecotizacion.getIdcotizacion());
                nuevoRegistro.setIdproducto(mDetallecotizacion.getIdproducto());
                nuevoRegistro.setCantidad(mDetallecotizacion.getCantidad());
                nuevoRegistro.setPreciounitario(mDetallecotizacion.getPreciounitario());


                return iDetallecotizacion.save(nuevoRegistro);
            }else{
                throw new Exception("No se puede modificar porque el detalle cotizacion no esta registrado ");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar detalle cotizacion
    public Boolean eliminarDetallecotizacion(Integer iddetallecotizacion) throws Exception{
        try{
            Optional<MDetallecotizacion> registroEncontrada=iDetallecotizacion.findById(iddetallecotizacion);
            if (registroEncontrada.isPresent()){
                iDetallecotizacion.deleteById(iddetallecotizacion);
                return true;
            }else{
                throw new Exception("No se pudo eliminar porque el detalle cotizacion esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
