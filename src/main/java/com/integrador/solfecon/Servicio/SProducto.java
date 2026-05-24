package com.integrador.solfecon.Servicio;

import com.integrador.solfecon.Modelo.MProducto;
import com.integrador.solfecon.Repositorio.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SProducto {

    @Autowired
    IProducto iProducto;

    public SProducto(IProducto iProducto) {
        this.iProducto = iProducto;
    }

    public MProducto adicionarProducto(MProducto mProducto) throws Exception {
        try {
            return iProducto.save(mProducto);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<MProducto> consultaGeneralProducto() throws Exception {
        try {
            return iProducto.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public MProducto consultaIndividualId(Integer idproducto) throws Exception {
        try {
            Optional<MProducto> registroEncontrado = iProducto.findById(idproducto);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Producto no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<MProducto> consultaIndividualProducto(String descripcionprod) throws Exception {
        try {
            return iProducto.findByDescripcionprod(descripcionprod);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public MProducto modificarProducto(Integer idproducto, MProducto mProducto) throws Exception {
        try {
            Optional<MProducto> registroEncontrado = iProducto.findById(idproducto);
            if (registroEncontrado.isPresent()) {
                MProducto nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setIdproducto(mProducto.getIdproducto());
                nuevoRegistro.setDescripcionprod(mProducto.getDescripcionprod());
                nuevoRegistro.setPrecio(mProducto.getPrecio());
                nuevoRegistro.setEstado(mProducto.getEstado());
                nuevoRegistro.setImagen(mProducto.getImagen());
                nuevoRegistro.setIdlinea(mProducto.getIdlinea());
                nuevoRegistro.setIdpromocion(mProducto.getIdpromocion());
                return iProducto.save(nuevoRegistro);
            } else {
                throw new Exception("No se puede modificar porque el producto no está registrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarProducto(Integer idproducto) throws Exception {
        try {
            Optional<MProducto> registroEncontrada = iProducto.findById(idproducto);
            if (registroEncontrada.isPresent()) {
                iProducto.deleteById(idproducto);
                return true;
            } else {
                throw new Exception("No se pudo eliminar porque el producto no está registrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}   // CORRECCIÓN: faltaba el cierre "}" de la clase