package com.integrador.solfecon.Configuracion;

import com.integrador.solfecon.Modelo.MLinea;
import com.integrador.solfecon.Repositorio.ILinea;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class CargarDatos implements CommandLineRunner {

    private final ILinea lineaRepositorio;

    public CargarDatos(ILinea lineaRepositorio) {
        this.lineaRepositorio = lineaRepositorio;
    }

    @Override
    public void run(String... argumentos) {
        // 1. Verificación de seguridad para no duplicar datos
        if (lineaRepositorio.count() > 0) {
            System.out.println("La tabla 'linea' ya tiene datos. No se realizará la carga.");
            return;
        }

        // 2. Arreglo con los nombres exactos de tu menú
        String[] nombresOficiales = {
                "Pinturas y accesorios",
                "Construcción",
                "Plomería y gas",
                "Eléctricos",
                "Agropecuario",
                "Herramientas",
                "Seguridad Industrial",
                "Limpieza y accesorios",
                "Adhesivos y empaques",
                "Tornillería y accesorios",
                "Abrasivos y químicos",
                "Herrajes y cerrajería"
        };

        List<MLinea> listaLineas = new ArrayList<>();

        // 3. Bucle simple que recorre el arreglo en orden
        for (int i = 0; i < nombresOficiales.length; i++) {
            String nombreLinea = nombresOficiales[i];

            // Generamos una ruta de imagen genérica basada en el nombre o un índice
            // Puedes ajustar la extensión según tus archivos reales (.png, .jpg, etc)
            String rutaImagen = "assets/img/lineas/linea_" + (i + 1) + ".png";

            // Creamos el objeto. ID en null para que sea Auto-incremental
            listaLineas.add(new MLinea(null, nombreLinea, rutaImagen));
        }

        // 4. Guardar en la base de datos
        lineaRepositorio.saveAll(listaLineas);

        System.out.println(">>> Éxito: Se han cargado las 12 líneas oficiales de Solfecon.");
    }
}