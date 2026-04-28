package ejercicio2.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Empleado {
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;

    public Empleado(String apellido, String nombre, LocalDate fechaNacimiento, String email){
        verificarApellido(apellido);
        verificarNombre(nombre);
        verificarFechaNacimiento(fechaNacimiento);
        verificarEmail(email);
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public boolean cumploHoy(){
        LocalDate hoy = LocalDate.now();
        return (fechaNacimiento.getDayOfMonth() == hoy.getDayOfMonth() && fechaNacimiento.getMonth() == hoy.getMonth());
    }

    public String nombre(){
        return nombre;
    }

    public String apellido(){
        return apellido;
    }

    public String email(){
        return email;
    }

    public LocalDate fechaNacimiento(){
        return fechaNacimiento;
    }

    public void verificarNombre(String nombre){
        if(nombre == null || nombre.isBlank()){
            throw new RuntimeException("El nombre ingresado no es valido!");
        }
    }

    public void verificarApellido(String apellido){
        if(apellido == null || apellido.isBlank()){
            throw new RuntimeException("El apellido ingresado no es valido!");
        }
    }

    public void verificarFechaNacimiento(LocalDate fechaNacimiento){
        if(fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())){
            throw new RuntimeException("La fecha de nacimiento ingresada no es valida!");
        }
    }

    public void verificarEmail(String email){
        if(email == null || email.isBlank()){
            throw new RuntimeException("El email ingresado no es valido!");
        }
    }

}
