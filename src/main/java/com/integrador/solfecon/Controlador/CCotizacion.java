package com.integrador.solfecon.Controlador;

import com.integrador.solfecon.Modelo.MCotizacion;
import com.integrador.solfecon.Servicio.SCotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cotizacion")
@CrossOrigin(origins = "*")
public class CCotizacion {

    @Autowired
    SCotizacion sCotizacion;

    // Consulta individual por Id
    @GetMapping("/{idcotizacion}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idcotizacion) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCotizacion.consultaIndividualId(idcotizacion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta por cliente
    @GetMapping("/cliente/{idecliente}")
    public ResponseEntity<?> consultaIndividualIdecliente(@PathVariable String idecliente) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCotizacion.consultaIndividualidecliente(idecliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar cotizacion
    @PutMapping("/{idcotizacion}")
    public ResponseEntity<?> modificarCotizacion(@PathVariable Integer idcotizacion, @RequestBody MCotizacion mCotizacion) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCotizacion.modificarCotizacion(idcotizacion, mCotizacion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

// eliminar  cotizacion

    @DeleteMapping("{idcotizacion}")

    public ResponseEntity<?> eliminarCotizacion(Integer idcotizacion) throws Exception{

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCotizacion.eliminarCotizacion(idcotizacion));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }

    }

}