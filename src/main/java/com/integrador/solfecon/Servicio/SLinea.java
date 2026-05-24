package com.integrador.solfecon.Servicio;

import com.integrador.solfecon.Modelo.MLinea;
import com.integrador.solfecon.Repositorio.ILinea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SLinea {

    @Autowired
    ILinea iLinea;

    public SLinea(ILinea iLinea) { this.iLinea = iLinea; }

    public MLinea adicionarLinea(MLinea mLinea) throws Exception {
        try {
            // ✅ Si imagen es null o vacío, asignar "sin_imagen"
            if (mLinea.getImagen() == null || mLinea.getImagen().isBlank()
                    || mLinea.getImagen().equals("sin_imagen")) {
                mLinea.setImagen("sin_imagen");
            }
            return iLinea.save(mLinea);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<MLinea> consultaGeneralLinea() throws Exception {
        try { return iLinea.findAll(); }
        catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public MLinea consultaIndividualId(Integer idlinea) throws Exception {
        try {
            Optional<MLinea> r = iLinea.findById(idlinea);
            if (r.isPresent()) return r.get();
            else throw new Exception("Linea no registrada");
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public List<MLinea> consultaIndividualLinea(String descripcionlinea) throws Exception {
        try { return iLinea.findByDescripcionlinea(descripcionlinea); }
        catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public MLinea modificarLinea(Integer idlinea, MLinea mLinea) throws Exception {
        try {
            Optional<MLinea> registroEncontrado = iLinea.findById(idlinea);
            if (registroEncontrado.isPresent()) {
                MLinea nuevoRegistro = registroEncontrado.get();
                nuevoRegistro.setDescripcionlinea(mLinea.getDescripcionlinea());
                // ✅ Solo actualiza imagen si viene con valor real nuevo
                if (mLinea.getImagen() != null && !mLinea.getImagen().isBlank()
                        && !mLinea.getImagen().equals("sin_imagen")) {
                    nuevoRegistro.setImagen(mLinea.getImagen());
                }
                return iLinea.save(nuevoRegistro);
            } else {
                throw new Exception("No se puede modificar porque la linea no esta registrada");
            }
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }

    public Boolean eliminarLinea(Integer idlinea) throws Exception {
        try {
            Optional<MLinea> r = iLinea.findById(idlinea);
            if (r.isPresent()) { iLinea.deleteById(idlinea); return true; }
            else throw new Exception("No se pudo eliminar porque linea no esta registrada");
        } catch (Exception error) { throw new Exception(error.getMessage()); }
    }
}