package com.integrador.solfecon.Servicio;

import com.integrador.solfecon.Modelo.MPromocion;
import com.integrador.solfecon.Repositorio.IPromocion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SPromocion {

    //Inyectar la interface del Repositorio
    @Autowired
    IPromocion iPromocion;
    //Constructor

    public SPromocion(IPromocion iPromocion) {
        this.iPromocion = iPromocion;
    }


//Adicionar un promocion

public MPromocion adicionarPromocion(MPromocion mPromocion) throws Exception {

    try{

        return iPromocion.save(mPromocion);

    } catch (Exception error) {
        throw new Exception(error.getMessage());
    }


}


//Consulta general de promocion

    public List<MPromocion>consultaGeneralPromocion() throws Exception{

        try{

            return iPromocion.findAll();

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }


    }

    //Consulta individual por Id de promocion

    public MPromocion consultaIndividualId(Integer idpromocion) throws Exception{
        try{
            Optional<MPromocion> registroEncontrado=iPromocion.findById(idpromocion);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Promocion  no registrada");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    //Consulta individual por nombre de promocion


    public List<MPromocion> consultaIndividualPromocion(String descripcionprom) throws Exception{
        try{
            return iPromocion.findByDescripcionprom(descripcionprom);
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    //Modificar los datos de un promocion

    public MPromocion modificarPromocion (Integer idpromocion, MPromocion mPromocion) throws Exception{
        try {
            Optional<MPromocion> registroEncontrado=iPromocion.findById(idpromocion);
            if (registroEncontrado.isPresent()){
                MPromocion nuevoRegistro=registroEncontrado.get();
                nuevoRegistro.setIdPromocion(mPromocion.getIdPromocion());
                nuevoRegistro.setDescripcionprom(mPromocion.getDescripcionprom());
                nuevoRegistro.setImagen(mPromocion.getImagen());
                nuevoRegistro.setDescuento(mPromocion.getDescuento());

                return iPromocion.save(nuevoRegistro);
            }else{
                throw new Exception("No se puede modificar porque la linea no esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    //Eliminar una promocion


    public Boolean eliminarPromocion(Integer idpromocion) throws Exception{
        try{
            Optional<MPromocion> registroEncontrada=iPromocion.findById(idpromocion);
            if (registroEncontrada.isPresent()){
                iPromocion.deleteById(idpromocion);
                return true;
            }else{
                throw new Exception("No se pudo eliminar porque la promocion no esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}






