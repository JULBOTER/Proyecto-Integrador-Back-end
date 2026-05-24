package com.integrador.solfecon.Controlador;

import com.integrador.solfecon.Modelo.MLinea;
import com.integrador.solfecon.Servicio.SLinea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/linea")
@CrossOrigin(origins = "*")
public class CLinea {

    @Autowired
    SLinea sLinea;

    // POST /linea
    @PostMapping
    public ResponseEntity<?> guardarLinea(@RequestBody MLinea mLinea) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sLinea.adicionarLinea(mLinea));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /linea
    @GetMapping
    public ResponseEntity<?> consultaGeneralLinea() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sLinea.consultaGeneralLinea());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /linea/{idlinea}
    @GetMapping("/{idlinea}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idlinea) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sLinea.consultaIndividualId(idlinea));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /linea/descripcion/{descripcion}
    // CORRECCIÓN: el @PathVariable tenía nombre incorrecto (descripcionlinea en vez de descripcion)
    // lo que causaba que Spring no pudiera mapear el parámetro de la URL
    @GetMapping("/descripcion/{descripcion}")
    public ResponseEntity<?> consultaIndividualLinea(@PathVariable("descripcion") String descripcionlinea) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sLinea.consultaIndividualLinea(descripcionlinea));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // PUT /linea/{idlinea}
    @PutMapping("/{idlinea}")
    public ResponseEntity<?> modificarLinea(@PathVariable Integer idlinea,
                                            @RequestBody MLinea mLinea) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sLinea.modificarLinea(idlinea, mLinea));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // DELETE /linea/{idlinea}
    // CORRECCIÓN: se agregó la barra "/" y la anotación @PathVariable
    @DeleteMapping("/{idlinea}")
    public ResponseEntity<?> eliminarLinea(@PathVariable Integer idlinea) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sLinea.eliminarLinea(idlinea));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}