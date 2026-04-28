package com.integrador.solfecon.Servicio;

import com.integrador.solfecon.Modelo.MLinea;
import com.integrador.solfecon.Repositorio.ILinea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SLinea {

    //Inyectar la interface del Repositorio
    @Autowired
    ILinea iLinea;
    //Constructor

    public SLinea(ILinea iLinea) {
        this.iLinea = iLinea;
    }


//Adicionar una linea

    public MLinea adicionarLinea(MLinea mLinea) throws Exception {

        try{

            return iLinea.save(mLinea);

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }


    }


//Consulta general de lineas

    public List<MLinea>consultaGeneralLinea() throws Exception{

        try{

            return iLinea.findAll();

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }


    }

    //Consulta individual por Id de linea

    public MLinea consultaIndividualId(Integer idlinea) throws Exception{
        try{
            Optional<MLinea> registroEncontrado=iLinea.findById(idlinea);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Linea no registrada");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    //Consulta individual por nombre de linea

    public List<MLinea> consultaIndividualLinea(String descripcionlinea) throws Exception{
        try{
            return iLinea.findByDescripcionlinea(descripcionlinea);
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Modificar los datos de una linea

    public MLinea modificarLinea (Integer idlinea,MLinea mLinea) throws Exception{
        try {
            Optional<MLinea> registroEncontrado=iLinea.findById(idlinea);
            if (registroEncontrado.isPresent()){
                MLinea nuevoRegistro=registroEncontrado.get();
                nuevoRegistro.setIdlinea(mLinea.getIdlinea());
                nuevoRegistro.setDescripcionlinea(mLinea.getDescripcionlinea());
                nuevoRegistro.setImagen(mLinea.getImagen());

                return iLinea.save(nuevoRegistro);
            }else{
                throw new Exception("No se puede modificar porque la linea no esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }



    //Eliminar una linea


    public Boolean eliminarLinea(Integer idlinea) throws Exception{
        try{
            Optional<MLinea> registroEncontrada=iLinea.findById(idlinea);
            if (registroEncontrada.isPresent()){
                iLinea.deleteById(idlinea);
                return true;
            }else{
                throw new Exception("No se pudo eliminar porque linea no esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}