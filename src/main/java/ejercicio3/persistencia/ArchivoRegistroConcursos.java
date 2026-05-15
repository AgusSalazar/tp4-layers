package ejercicio3.persistencia;

import ejercicio3.modelo.Concurso;
import ejercicio3.modelo.RegistroConcursos;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArchivoRegistroConcursos implements RegistroConcursos{
    private String concursos;

    public ArchivoRegistroConcursos(String concursos){
        this.concursos = concursos;
    }

    @Override
    public void todosLosConcursos(JComboBox<String> combo) {
        Path ruta = Path.of(this.concursos);
        combo.removeAllItems();

        try {
            List<String> lineas = Files.readAllLines(ruta);

            for (String linea : lineas) {
                String[] datos = linea.split(",");
                //idconcurso,nombre,fechaInicioInscripcion,fechaFinInscripcion
                if (datos.length >= 4) {
                    String nombreConcurso = datos[1];
                    String fechaInicio = datos[2];
                    String fechaFin = datos[3];

                    if (tieneInscripcionAbierta(fechaInicio, fechaFin)) {
                        combo.addItem(nombreConcurso);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de concursos:"  + e);
        }
    }

    public boolean tieneInscripcionAbierta(String inicio, String fin){
        LocalDate hoy = LocalDate.now();
        LocalDate fechaInicio= LocalDate.parse(inicio);
        LocalDate fechaLimite = LocalDate.parse(fin);

        return (hoy.isAfter(fechaInicio) && hoy.isBefore(fechaLimite));
    }

    public void inicializarArchivoConcursos(List<Concurso> lista){
        Path ruta = Path.of(this.concursos);

        List<String> lineas = new ArrayList<>();
        for (Concurso c : lista) {
            // idConcurso,nombre,fechaInicio,fechaFin
            String linea = c.idConcurso() + "," + c.nombre() + "," + c.fechaInicio() + "," + c.fechaLimite();
            lineas.add(linea);
        }

        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            System.out.println("Archivo inicializado correctamente");
        } catch (IOException e) {
            throw new RuntimeException("No se pudo inicializar el archivo de concursos", e);
        }

    }

}
