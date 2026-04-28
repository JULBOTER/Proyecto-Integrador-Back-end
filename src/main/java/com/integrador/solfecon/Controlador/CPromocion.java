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

    // Metodo para el EndPoint de adicionar una promocion

    @PostMapping
    public ResponseEntity<?> guardarPromocion(@RequestBody MPromocion mPromocion) throws Exception {
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

    @GetMapping
    public ResponseEntity<?> consultaGeneralPromocion() throws Exception {
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

    // Consulta individual por Id
    @GetMapping("/{idpromocion}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idpromocion) throws Exception {
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

    // Consulta individual por descripcion
    @GetMapping("/descripcionprom/{descripcionprom}")
    public ResponseEntity<?> consultaIndividualPromocion(@PathVariable String descripcionprom) throws Exception {
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

    // Modificar promocion
    @PutMapping("/{idpromocion}")
    public ResponseEntity<?> modificarPromocion(@PathVariable Integer idpromocion, @RequestBody MPromocion mPromocion) throws Exception {
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

    //Eliminar un promocion
    @DeleteMapping("{idpromocion}")

    public ResponseEntity<?> eliminarPromocion(Integer idpromocion) throws Exception{

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sPromocion.eliminarPromocion(idpromocion));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }

    }

}

