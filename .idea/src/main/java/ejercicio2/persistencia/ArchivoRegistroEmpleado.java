package ejercicio2.persistencia;

import ejercicio2.modelo.RegistroEmpleado;
import ejercicio2.modelo.Empleado;
import ejercicio2.modelo.Notificador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ArchivoRegistroEmpleado implements RegistroEmpleado{
    private String archivo;
//    private Notificador notificador;

    public ArchivoRegistroEmpleado(String archivo){
        this.archivo = archivo;
//        this.notificador = notificador;
    }

    @Override
    public void registrar(Empleado e){
        try(FileWriter fw = new FileWriter(this.archivo, true);
            BufferedWriter bw = new BufferedWriter(fw)){

            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String fechaFormateada = e.fechaNacimiento().format(format);

            String lineaEscritura = e.apellido()+ "," +e.nombre()+ "," +fechaFormateada+ "," + e.email();
            bw.write(lineaEscritura);
            bw.newLine();

        }catch(IOException ex){
            throw new RuntimeException("¡No se pudo escribir sobre el Archivo de Empleados!", ex);
        }

    }

}
