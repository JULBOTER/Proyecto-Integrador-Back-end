package com.integrador.solfecon.Controlador;

import com.integrador.solfecon.Modelo.MPromocion;
import com.integrador.solfecon.Servicio.SPromocion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promocion")
@CrossOrigin(origins = "*")
public class CPromocion {

    @Autowired
    SPromocion sPromocion;

    // POST /promocion
    @PostMapping
    public ResponseEntity<?> guardarPromocion(@RequestBody MPromocion mPromocion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sPromocion.adicionarPromocion(mPromocion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /promocion
    @GetMapping
    public ResponseEntity<?> consultaGeneralPromocion() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPromocion.consultaGeneralPromocion());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /promocion/{idpromocion}
    @GetMapping("/{idpromocion}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idpromocion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPromocion.consultaIndividualId(idpromocion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /promocion/descripcionprom/{descripcionprom}
    @GetMapping("/descripcionprom/{descripcionprom}")
    public ResponseEntity<?> consultaIndividualPromocion(@PathVariable String descripcionprom) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPromocion.consultaIndividualPromocion(descripcionprom));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // PUT /promocion/{idpromocion}
    @PutMapping("/{idpromocion}")
    public ResponseEntity<?> modificarPromocion(@PathVariable Integer idpromocion,
                                                @RequestBody MPromocion mPromocion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPromocion.modificarPromocion(idpromocion, mPromocion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // DELETE /promocion/{idpromocion}
    // CORRECCIÓN: se agregó la barra "/" y la anotación @PathVariable
    @DeleteMapping("/{idpromocion}")
    public ResponseEntity<?> eliminarPromocion(@PathVariable Integer idpromocion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPromocion.eliminarPromocion(idpromocion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}