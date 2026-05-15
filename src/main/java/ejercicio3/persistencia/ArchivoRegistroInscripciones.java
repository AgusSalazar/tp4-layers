package ejercicio3.persistencia;

import ejercicio3.modelo.RegistroInscripciones;
import  ejercicio3.modelo.Persona;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoRegistroInscripciones implements RegistroInscripciones{
    private String rutaArchivo;

    public ArchivoRegistroInscripciones(String rutaArchivo){
        this.rutaArchivo = rutaArchivo;
    }


    @Override
    public void saveInscription(Persona p) {
        try(FileWriter fw = new FileWriter(this.rutaArchivo, true);
            BufferedWriter bw = new BufferedWriter(fw)){

            // apellido, nombre, teléfono, email, idconcurso
            String lineaEscritura = p.apellido()+ ", " + p.nombre() + ", " + p.telefono() + ", " + p.email() + ", " + p.idConcurso();
            bw.write(lineaEscritura);
            bw.newLine();

        }catch(IOException e) {
            throw new RuntimeException("¡No se pudo escribir sobre el Archivo de Inscriptos!", e);
        }
    }
}
