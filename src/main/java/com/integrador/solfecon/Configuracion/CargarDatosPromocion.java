package com.integrador.solfecon.Configuracion;
import com.integrador.solfecon.Modelo.MPromocion;
import com.integrador.solfecon.Repositorio.IPromocion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(1) // Es vital que las promociones se carguen primero o al mismo tiempo que las líneas

public class CargarDatosPromocion implements CommandLineRunner {

    private final IPromocion promocionRepositorio;

    public CargarDatosPromocion(IPromocion promocionRepositorio) {
        this.promocionRepositorio = promocionRepositorio;
    }

    @Override
    public void run(String... argumentos) {
        // 1. Verificación para no duplicar datos
        if (promocionRepositorio.count() > 0) {
            System.out.println("La tabla 'promocion' ya tiene datos. Saltando carga.");
            return;
        }

        // 2. Arreglos con los datos oficiales de tu panel administrativo
        String[] nombresPromos = {
                "Navidad",
                "Saldos",
                "Productos seguridad",
                "Sin promoción"
        };

        String[] rutasImagenes = {
                "assets/img/promociones/navidad.jpg",
                "assets/img/promociones/saldos.jpg",
                "assets/img/promociones/seguridad.jpg",
                "assets/img/promociones/sin_promo.jpg"
        };

        // Descuentos en formato String para evitar problemas de precisión con BigDecimal
        String[] porcentajesDescuento = {
                "50.00",
                "20.00",
                "10.00",
                "0.00"
        };

        List<MPromocion> listaPromociones = new ArrayList<>();

        // 3. Bucle que recorre los arreglos y construye los objetos
        for (int i = 0; i < nombresPromos.length; i++) {
            MPromocion promo = new MPromocion();

            // Asignamos los campos usando los setters de tu modelo
            promo.setIdPromocion(null); // ID null para Auto-incremental
            promo.setDescripcionprom(nombresPromos[i]);
            promo.setImagen(rutasImagenes[i]);
            promo.setDescuento(new BigDecimal(porcentajesDescuento[i]));

            listaPromociones.add(promo);
        }

        // 4. Guardar todo el lote en la base de datos
        promocionRepositorio.saveAll(listaPromociones);

        System.out.println(">>> Éxito: Se han cargado las 4 promociones oficiales de Solfecon.");
    }
}