package com.integrador.solfecon.Configuracion;

import com.integrador.solfecon.Modelo.MProducto;
import com.integrador.solfecon.Repositorio.IProducto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@Component
@Order(3) // Se ejecuta de último, después de Líneas (Order 2) y Promociones (Order 1)
public class CargarDatosProducto implements CommandLineRunner {

    private final IProducto productoRepositorio;

    public CargarDatosProducto(IProducto productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public void run(String... argumentos) {
        if (productoRepositorio.count() > 0) {
            System.out.println("La tabla 'productos' ya tiene datos. Saltando carga.");
            return;
        }

        List<MProducto> listaProductos = new ArrayList<>();

        // --- CARGA POR BLOQUES (5 PRODUCTOS POR LÍNEA) ---

        // Línea 1 (Pinturas) -> Promo 1 (Navidad)
        procesarLote(listaProductos, 1, 1, new String[][]{
                {"Rodillo Epóxico Goya 9", "14339.50"}, {"Cinta enmascarar 1*40 mts", "6961.50"},
                {"Aerocolor Anticorrosivo Negro", "15470.00"}, {"Brocha popular mona 1/2 Goya", "6842.00"}, {"Pintura Galón Blanco 5 galones", "447321.00"}
        });

        // Línea 2 (Construcción) -> Promo 2 (Saldos)
        procesarLote(listaProductos, 2, 2, new String[][]{
                {"Cemento Gris de uso General 50 Kg", "43836.72"}, {"Balde plástico construcción", "7378.00"},
                {"Cerradura dos botones Yale", "98413.00"}, {"Alambre de Pua Rollo * 350m", "427757.40"}, {"Ducha Eléctrica 110 V Kontiki", "80265.50"}
        });

        // Línea 3 (Plomería) -> Promo 3 (Productos seguridad)
        procesarLote(listaProductos, 3, 3, new String[][]{
                {"Bomba de agua Periférica 1/2 hp", "162911.00"}, {"Llave de Cañería Hierro 48\"", "205751.00"},
                {"Electrobomba Periferica 110v", "575841.00"}, {"Estufa de empotrar 4 puestos", "2213281.40"}, {"Estufa de piso 4 puestos Gas", "829891.00"}
        });

        // Línea 4 (Eléctricos) -> Promo 4 (Sin promoción)
        procesarLote(listaProductos, 4, 4, new String[][]{
                {"Cautín Eléctrico 60 W", "59381.00"}, {"Multímetro Automático", "118881.00"},
                {"Cortadora Inalámbrica", "15922081.00"}, {"Termometro Laser Infrarojo", "297381.00"}, {"Probador de cables", "535381.00"}
        });

        // Línea 5 (Agropecuario) -> Promo 4
        procesarLote(listaProductos, 5, 4, new String[][]{
                {"Pala Jardinera Cuadrada", "33389.00"}, {"Rastrillo Polipropileno", "27846.00"},
                {"Machete Barrigón Pulido", "19922.00"}, {"Lima Triangular Regular", "11305.00"}, {"Polisombra 50% Ancho 4 Mts", "12733.00"}
        });

        // Línea 6 (Herramientas) -> Promo 4
        procesarLote(listaProductos, 6, 4, new String[][]{
                {"Taladro Percutor 1/2 Vvr", "367591.00"}, {"Sierra Circular 7 - 1/4pg", "593691.00"},
                {"Pulidora 7 Pulgadas 2200W", "843591.00"}, {"Hidrolavadora Karcher", "904281.00"}, {"Set Atornillador 3.6V", "428281.00"}
        });

        // Línea 7 (Seguridad Industrial) -> Promo 4
        procesarLote(listaProductos, 7, 4, new String[][]{
                {"Botas seguridad punta acero", "187425.00"}, {"Careta para esmerilar", "51765.00"},
                {"Casco de seguridad verde", "18742.50"}, {"Gafa soldadura inteligente", "67830.00"}, {"Guante XL latex anticorte", "23205.00"}
        });

        // Línea 8 (Limpieza) -> Promo 4
        procesarLote(listaProductos, 8, 4, new String[][]{
                {"Aspiradora Inalámbrica 20V", "427507.50"}, {"Detergente industrial", "12316.50"},
                {"Trapeadora", "9936.50"}, {"Escoba de 30 dientes", "76933.50"}, {"Recogedor plástico", "5474.00"}
        });

        // Línea 9 (Adhesivos) -> Promo 4
        procesarLote(listaProductos, 9, 4, new String[][]{
                {"Pegante madera 20kg", "333319.00"}, {"Silicona gris Loctite", "27846.00"},
                {"Adhesivo Loctite", "41114.50"}, {"Fijador de roscas rojo", "100257.50"}, {"Zuncho Plastico 1000 mts", "58488.50"}
        });

        // Línea 10 (Tornillería) -> Promo 4
        procesarLote(listaProductos, 10, 4, new String[][]{
                {"Tornillo Autoperforante", "83181.00"}, {"Angulo refuerzo galvanizado", "29631.00"},
                {"Base empotrada poste", "106981.00"}, {"Tuerca Estrella M6", "16303.00"}, {"Tuberia de Drenaje", "154581.00"}
        });

        // Línea 11 (Abrasivos) -> Promo 4
        procesarLote(listaProductos, 11, 4, new String[][]{
                {"Aditivo Impermeabilizante", "989941.00"}, {"Bloqueador Humedad 1 gal", "261481.00"},
                    {"Repelente ecológico", "26061.00"}, {"Insecticida Aerosol", "16541.00"}, {"Herbicida Panzer 480 Ml", "17731.00"}
        });

        // Línea 12 (Herrajes) -> Promo 4
        procesarLote(listaProductos, 12, 4, new String[][]{
                {"Cerradura alcoba satinada", "20111.00"}, {"Riel aluminio con freno", "95081.00"},
                {"Corredera puerta corrediza", "65331.00"}, {"Candado 40mm yale", "732921.00"}, {"Caja Fuerte fixser", "65331.00"}
        });

        productoRepositorio.saveAll(listaProductos);
        System.out.println(">>> Éxito: 60 productos cargados (5 por cada una de las 12 líneas).");
    }

    /**
     * Método auxiliar para procesar datos de forma masiva
     */
    private void procesarLote(List<MProducto> lista, Integer idLinea, Integer idPromo, String[][] datos) {
        for (String[] d : datos) {
            MProducto p = new MProducto();
            p.setIdproducto(null); // Auto-incremental
            p.setDescripcionprod(d[0]);
            p.setPrecio(new BigDecimal(d[1]));
            p.setEstado(true);
            p.setIdlinea(idLinea);
            p.setIdpromocion(idPromo);
            // Genera la ruta de imagen basada en el nombre (minúsculas y guiones bajos)
            p.setImagen("assets/img/productos/" + d[0].toLowerCase().replace(" ", "_") + ".jpg");

            lista.add(p);
        }
    }
}