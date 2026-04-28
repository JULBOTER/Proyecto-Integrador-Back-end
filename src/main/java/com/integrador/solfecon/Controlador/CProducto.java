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

    // Metodo para el EndPoint de adicionar un producto
    @PostMapping
    public ResponseEntity<?> guardarProducto(@RequestBody MProducto mProducto) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.sProducto.adicionarProducto(mProducto));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta general
    @GetMapping
    public ResponseEntity<?> consultaGeneralProducto() throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.consultaGeneralProducto());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Consulta individual por Id
    @GetMapping("/{idproducto}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer idproducto) throws Exception {
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

    // Consulta individual por descripcion
    @GetMapping("/descripcion/{descripcion}")
    public ResponseEntity<?> consultaIndividualLinea(@PathVariable String descripcionproducto) throws Exception {
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

    // Modificar producto
    @PutMapping("/{idproducto}")
    public ResponseEntity<?> modificarProducto(@PathVariable Integer idproducto, @RequestBody MProducto mProducto) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.modificarProducto(idproducto,mProducto));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());


        }
    }

    //Eliminar un producto
    @DeleteMapping("{idproducto}")

    public ResponseEntity<?> eliminarProducto(Integer idproducto) throws Exception{

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sProducto.eliminarProducto(idproducto));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }

    }


}
