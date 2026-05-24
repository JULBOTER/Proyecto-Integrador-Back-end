package com.integrador.solfecon.Servicio;

import com.integrador.solfecon.Modelo.MPromocion;
import com.integrador.solfecon.Repositorio.IPromocion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SPromocion {

    @Autowired
    IPromocion iPromocion;

    public SPromocion(IPromocion iPromocion) { this.iPromocion = iPromocion; }

    public MPromocion adicionarPromocion(MPromocion mPromocion) throws Exception {
        try {
            // ✅ Proteger imagen null
            if (mPromocion.getImagen() == null || mPromocion.getImagen().isBlank()
                    || mPromocion.getImagen().equals("sin_imagen")) {
                mPromocion.setImagen("sin_imagen");
            }
            return iPromocion.save(mPromocion);
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public List<MPromocion> consultaGeneralPromocion() throws Exception {
        try { return iPromocion.findAll(); }
        catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public MPromocion consultaIndividualId(Integer idpromocion) throws Exception {
        try {
            Optional<MPromocion> r = iPromocion.findById(idpromocion);
            if (r.isPresent()) return r.get();
            else throw new Exception("Promocion no registrada");
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public List<MPromocion> consultaIndividualPromocion(String descripcionprom) throws Exception {
        try { return iPromocion.findByDescripcionprom(descripcionprom); }
        catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public MPromocion modificarPromocion(Integer idpromocion, MPromocion mPromocion) throws Exception {
        try {
            Optional<MPromocion> registroEncontrado = iPromocion.findById(idpromocion);
            if (registroEncontrado.isPresent()) {
                MPromocion nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setDescripcionprom(mPromocion.getDescripcionprom());
                nuevoRegistro.setDescuento(mPromocion.getDescuento());
                // ✅ Solo actualiza imagen si viene con valor real
                if (mPromocion.getImagen() != null && !mPromocion.getImagen().isBlank()
                        && !mPromocion.getImagen().equals("sin_imagen")) {
                    nuevoRegistro.setImagen(mPromocion.getImagen());
                }
                return iPromocion.save(nuevoRegistro);
            } else {
                throw new Exception("No se puede modificar porque la promocion no esta registrada");
            }
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public Boolean eliminarPromocion(Integer idpromocion) throws Exception {
        try {
            Optional<MPromocion> r = iPromocion.findById(idpromocion);
            if (r.isPresent()) { iPromocion.deleteById(idpromocion); return true; }
            else throw new Exception("No se pudo eliminar porque la promocion no esta registrada");
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }
}





