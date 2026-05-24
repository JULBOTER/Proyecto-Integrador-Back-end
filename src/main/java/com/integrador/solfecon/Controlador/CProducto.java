package com.integrador.solfecon.Controlador;

import com.integrador.solfecon.Modelo.MProducto;
import com.integrador.solfecon.Servicio.SProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class CProducto {

    @Autowired
    SProducto sProducto;

    // POST /producto
    @PostMapping
    public ResponseEntity<?> guardarProducto(@RequestBody MProducto mProducto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sProducto.adicionarProducto(mProducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /producto
    @GetMapping
    public ResponseEntity<?> consultaGeneralProducto() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.consultaGeneralProducto());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /producto/{idproducto}
    @GetMapping("/{idproducto}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idproducto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.consultaIndividualId(idproducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // GET /producto/descripcion/{descripcion}
    // CORRECCIÓN: el @PathVariable tenía nombre incorrecto (descripcionproducto en vez de descripcion)
    // lo que causaba que Spring no pudiera mapear el parámetro de la URL
    @GetMapping("/descripcion/{descripcion}")
    public ResponseEntity<?> consultaIndividualProducto(@PathVariable("descripcion") String descripcionproducto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.consultaIndividualProducto(descripcionproducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // PUT /producto/{idproducto}
    @PutMapping("/{idproducto}")
    public ResponseEntity<?> modificarProducto(@PathVariable Integer idproducto,
                                               @RequestBody MProducto mProducto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.modificarProducto(idproducto, mProducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // DELETE /producto/{idproducto}
    // CORRECCIÓN: se agregó la barra "/" y la anotación @PathVariable
    @DeleteMapping("/{idproducto}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer idproducto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.eliminarProducto(idproducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}