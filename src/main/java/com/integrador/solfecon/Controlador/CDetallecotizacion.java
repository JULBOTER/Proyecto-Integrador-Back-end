package com.integrador.solfecon.Controlador;

import com.integrador.solfecon.Modelo.MDetallecotizacion;
import com.integrador.solfecon.Servicio.SDetallecotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detallecotizacion")
@CrossOrigin(origins = "*")
public class CDetallecotizacion {

    @Autowired
    SDetallecotizacion sDetallecotizacion;

    // POST /detallecotizacion
    // CORRECCIÓN: faltaba este endpoint — el servicio existía pero no estaba expuesto
    @PostMapping
    public ResponseEntity<?> guardarDetallecotizacion(@RequestBody MDetallecotizacion mDetallecotizacion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sDetallecotizacion.adicionarDetallecotizacion(mDetallecotizacion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /detallecotizacion/{iddetallecotizacion}
    @GetMapping("/{iddetallecotizacion}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer iddetallecotizacion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sDetallecotizacion.consultaIndividualId(iddetallecotizacion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /detallecotizacion/cotizacion/{idcotizacion}
    @GetMapping("/cotizacion/{idcotizacion}")
    public ResponseEntity<?> consultaIndividualIdcotizacion(@PathVariable Integer idcotizacion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sDetallecotizacion.consultaIndividualidcotizacion(idcotizacion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // PUT /detallecotizacion/{iddetallecotizacion}
    @PutMapping("/{iddetallecotizacion}")
    public ResponseEntity<?> modificarDetallecotizacion(@PathVariable Integer iddetallecotizacion,
                                                        @RequestBody MDetallecotizacion mDetallecotizacion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sDetallecotizacion.modificarDetallecotizacion(iddetallecotizacion, mDetallecotizacion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // DELETE /detallecotizacion/{iddetallecotizacion}
    // CORRECCIÓN: se agregó la barra "/" y la anotación @PathVariable
    @DeleteMapping("/{iddetallecotizacion}")
    public ResponseEntity<?> eliminarDetallecotizacion(@PathVariable Integer iddetallecotizacion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sDetallecotizacion.eliminarDetallecotizacion(iddetallecotizacion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}