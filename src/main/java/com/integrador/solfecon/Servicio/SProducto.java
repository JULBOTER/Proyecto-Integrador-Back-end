package com.integrador.solfecon.Servicio;

import com.integrador.solfecon.Modelo.MProducto;
import com.integrador.solfecon.Repositorio.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SProducto {
    // Inyectar la interface del Repositorio
    @Autowired
    IProducto iProducto;
    //Constructor

    public SProducto(IProducto iProducto) {
        this.iProducto = iProducto;
    }

    //Adicionar un producto
    public MProducto adicionarProducto(MProducto mProducto) throws Exception {
        try {
            return iProducto.save(mProducto);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Consulta general de producto

    public List<MProducto>consultaGeneralProducto() throws Exception{

        try{

            return iProducto.findAll();

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }


    }


    // Consulta individual por Id de producto
    public MProducto consultaIndividualId(Integer idproducto) throws Exception{
        try{
            Optional<MProducto> registroEncontrado=iProducto.findById(idproducto);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Producto no registrado");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por nombre de de producto
    public List<MProducto> consultaIndividualProducto(String descripcionprod) throws Exception{
        try{
            return iProducto.findByDescripcionprod(descripcionprod);
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar los datos de un producto
    public MProducto modificarProducto (Integer idproducto,MProducto mProducto) throws Exception{
        try {
            Optional<MProducto> registroEncontrado=iProducto.findById(idproducto);
            if (registroEncontrado.isPresent()){
                MProducto nuevoRegistro=registroEncontrado.get();
                nuevoRegistro.setIdproducto(mProducto.getIdproducto());
                nuevoRegistro.setDescripcionprod(mProducto.getDescripcionprod());
                nuevoRegistro.setPrecio(mProducto.getPrecio());
                nuevoRegistro.setEstado(mProducto.getEstado());
                nuevoRegistro.setImagen(mProducto.getImagen());
                nuevoRegistro.setIdlinea(mProducto.getIdlinea());
                nuevoRegistro.setIdpromocion(mProducto.getIdpromocion());


                return iProducto.save(nuevoRegistro);
            }else{
                throw new Exception("No se puede modificar el producto porque esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    // Eliminar un producto
    public Boolean eliminarProducto(Integer idproducto) throws Exception{
        try{
            Optional<MProducto> registroEncontrada=iProducto.findById(idproducto);
            if (registroEncontrada.isPresent()){
                iProducto.deleteById(idproducto);
                return true;
            }else{
                throw new Exception("No se pudo eliminar porque producto no esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}