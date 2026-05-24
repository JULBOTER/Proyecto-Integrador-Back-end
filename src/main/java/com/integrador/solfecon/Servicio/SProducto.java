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

    public SProducto(IProducto iProducto) { this.iProducto = iProducto; }

    public MProducto adicionarProducto(MProducto mProducto) throws Exception {
        try {
            // ✅ Proteger imagen null
            if (mProducto.getImagen() == null || mProducto.getImagen().isBlank()
                    || mProducto.getImagen().equals("sin_imagen")) {
                mProducto.setImagen("sin_imagen");
            }
            return iProducto.save(mProducto);
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public List<MProducto> consultaGeneralProducto() throws Exception {
        try { return iProducto.findAll(); }
        catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public MProducto consultaIndividualId(Integer idproducto) throws Exception {
        try {
            Optional<MProducto> r = iProducto.findById(idproducto);
            if (r.isPresent()) return r.get();
            else throw new Exception("Producto no registrado");
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public List<MProducto> consultaIndividualProducto(String descripcionprod) throws Exception {
        try { return iProducto.findByDescripcionprod(descripcionprod); }
        catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public MProducto modificarProducto(Integer idproducto, MProducto mProducto) throws Exception {
        try {
            Optional<MProducto> registroEncontrado = iProducto.findById(idproducto);
            if (registroEncontrado.isPresent()) {
                MProducto nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setDescripcionprod(mProducto.getDescripcionprod());
                nuevoRegistro.setPrecio(mProducto.getPrecio());
                nuevoRegistro.setEstado(mProducto.getEstado());
                nuevoRegistro.setIdlinea(mProducto.getIdlinea());
                nuevoRegistro.setIdpromocion(mProducto.getIdpromocion());
                // ✅ Solo actualiza imagen si viene con valor real
                if (mProducto.getImagen() != null && !mProducto.getImagen().isBlank()
                        && !mProducto.getImagen().equals("sin_imagen")) {
                    nuevoRegistro.setImagen(mProducto.getImagen());
                }
                return iProducto.save(nuevoRegistro);
            } else {
                throw new Exception("No se puede modificar porque el producto no esta registrado");
            }
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public Boolean eliminarProducto(Integer idproducto) throws Exception {
        try {
            Optional<MProducto> r = iProducto.findById(idproducto);
            if (r.isPresent()) { iProducto.deleteById(idproducto); return true; }
            else throw new Exception("No se pudo eliminar porque el producto no esta registrado");
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }
}