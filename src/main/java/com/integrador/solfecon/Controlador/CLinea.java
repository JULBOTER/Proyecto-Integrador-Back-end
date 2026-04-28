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

    // Metodo para el EndPoint de adicionar una linea
    @PostMapping
    public ResponseEntity<?> guardarlinea(@RequestBody MLinea mLinea) throws Exception {
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

    @GetMapping
    public ResponseEntity<?> consultaGeneralLinea() throws Exception {
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

    // Consulta individual por Id
    @GetMapping("/{idlinea}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idlinea) throws Exception {
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


    // Consulta individual por descripcion
    @GetMapping("/descripcion/{descripcion}")
    public ResponseEntity<?> consultaIndividualLinea(@PathVariable String descripcionlinea) throws Exception {
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

    // Modificar linea
    @PutMapping("/{idlinea}")
    public ResponseEntity<?> modificarLinea(@PathVariable Integer idlinea, @RequestBody MLinea mLinea) throws Exception {
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

    //Eliminar una linea
    @DeleteMapping("{idlinea}")

    public ResponseEntity<?> eliminarLinea(Integer idlinea) throws Exception{

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sLinea.eliminarLinea(idlinea));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }

    }


}
