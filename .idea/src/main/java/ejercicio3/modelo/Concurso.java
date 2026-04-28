package ejercicio3.modelo;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String nombre;
    private LocalDate fechaLimite;
    private LocalDate fechaInicio;
    private String idConcurso;

    // idconcurso, nombre, fechaInicioInscripcion, fechaFinInscripcion
    public Concurso(String nombre, LocalDate fechaInicio, LocalDate fechaLimite) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
    }

    public String nombre() {
        return nombre;
    }

    public LocalDate fechaLimite() {
        return fechaLimite;
    }

    public LocalDate fechaInicio() {
        return fechaInicio;
    }

    public String idConcurso() {
        return idConcurso;
    }
}