package com.integrador.solfecon.Controlador;

import com.integrador.solfecon.Modelo.MDetallecotizacion;
import com.integrador.solfecon.Servicio.SDetallecotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detallecotizacion")

//origen
@CrossOrigin(origins = "*")
public class CDetallecotizacion {
    @Autowired
    SDetallecotizacion sDetallecotizacion;

    // Consulta individual por Id
    @GetMapping("/{iddetallecotizacion}")
    public ResponseEntity<?> consultaIndividualId(@PathVariable Integer iddetallecotizacion) throws Exception {
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

    // Consulta por idcotizacion
    @GetMapping("/cotizacion/{idcotizacion}")
    public ResponseEntity<?> consultaIndividualIdcotizacion(@PathVariable Integer idcotizacion) throws Exception {
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

    // Modificar detalle cotizacion
    @PutMapping("/{iddetallecotizacion}")
    public ResponseEntity<?> modificarDetallecoizacion(@PathVariable Integer iddetallecotizacion, @RequestBody MDetallecotizacion mDetallecotizacion) throws Exception {
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

    //Eliminar un Detalle cotizacion
    @DeleteMapping("{iddetallecotizacion}")

    public ResponseEntity<?> eliminarDetallecotizacion(Integer iddetallecotizacion) throws Exception{

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.sDetallecotizacion.eliminarDetallecotizacion(iddetallecotizacion));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }

    }

}


