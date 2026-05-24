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

    // POST /cotizacion
    // CORRECCIÓN: faltaba este endpoint — el servicio existía pero no estaba expuesto
    @PostMapping
    public ResponseEntity<?> guardarCotizacion(@RequestBody MCotizacion mCotizacion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sCotizacion.adicionarCotizacion(mCotizacion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /cotizacion/{idcotizacion}
    @GetMapping("/{idcotizacion}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idcotizacion) {
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

    // GET /cotizacion/cliente/{idecliente}
    @GetMapping("/cliente/{idecliente}")
    public ResponseEntity<?> consultaIndividualIdecliente(@PathVariable String idecliente) {
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

    // PUT /cotizacion/{idcotizacion}
    @PutMapping("/{idcotizacion}")
    public ResponseEntity<?> modificarCotizacion(@PathVariable Integer idcotizacion,
                                                 @RequestBody MCotizacion mCotizacion) {
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

    // DELETE /cotizacion/{idcotizacion}
    // CORRECCIÓN: se agregó la barra "/" y la anotación @PathVariable
    @DeleteMapping("/{idcotizacion}")
    public ResponseEntity<?> eliminarCotizacion(@PathVariable Integer idcotizacion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCotizacion.eliminarCotizacion(idcotizacion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}