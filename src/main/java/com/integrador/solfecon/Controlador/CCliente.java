package com.integrador.solfecon.Controlador;

import com.integrador.solfecon.Modelo.MCliente;
import com.integrador.solfecon.Servicio.SCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class CCliente {

    @Autowired
    SCliente sCliente;

    // POST /cliente
    @PostMapping
    public ResponseEntity<?> guardarCliente(@RequestBody MCliente mCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sCliente.adicionarCliente(mCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /cliente
    @GetMapping
    public ResponseEntity<?> consultaGeneralCliente() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCliente.consultaGeneralCliente());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /cliente/{idecliente}
    @GetMapping("/{idecliente}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable String idecliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCliente.consultaIndividualId(idecliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /cliente/nombre/{nomcliente}
    @GetMapping("/nombre/{nomcliente}")
    public ResponseEntity<?> consultaIndividualNombre(@PathVariable String nomcliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCliente.consultaIndividualNombre(nomcliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // PUT /cliente/{idecliente}
    @PutMapping("/{idecliente}")
    public ResponseEntity<?> modificarCliente(@PathVariable String idecliente,
                                              @RequestBody MCliente mCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCliente.modificarCliente(idecliente, mCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // DELETE /cliente/{idecliente}
    // CORRECCIÓN: se agregó la barra "/" y la anotación @PathVariable
    @DeleteMapping("/{idecliente}")
    public ResponseEntity<?> eliminarCliente(@PathVariable String idecliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sCliente.eliminarCliente(idecliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}