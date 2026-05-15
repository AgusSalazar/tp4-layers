package ejercicio3.modelo;

import javax.swing.*;

// apellido, nombre, teléfono, email, idconcurso

// Poner este JoptionPane en el try que va en radioCompetition -->  JOptionPane.showMessageDialog(this.contentPane, "GENERICO");

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private int idConcurso;

    public Persona(String nombre, String apellido, String dni, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    public void elegirConcurso(int idConcurso){
        validations(idConcurso);
        this.idConcurso = idConcurso;
    }

    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public String dni() {
        return dni;
    }

    public String email() {
        return email;
    }

    public String telefono() {
        return telefono;
    }

    public int idConcurso() {
        return idConcurso;
    }

    private void validarNombre(String nombre){
        if (nombre.isEmpty()) {
            throw new RuntimeException("El nombre ingresado no es valido!");
        }
    }

    private void validarApellido(String apellido){
        if (apellido.isEmpty()) {
            throw new RuntimeException("apellido no puede ser vacio");
        }
    }

    private void validarDni(String dni){
        if (dni.isBlank()) {
            throw new RuntimeException("dni no puede ser vacio");
        }
    }

    private void validarEmail(String email){
        if (!checkEmail(email)){
            throw new RuntimeException("email debe ser válido");
        }
    }

    private void validarTelefono(String telefono){
        if (!checkPhone(telefono)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    private void validations(int idConcurso) {
        if (idConcurso < 0) {
            throw new RuntimeException("Debe elegir un Concurso");
        }
    }
}

//JOptionPane.showMessageDialog(this.contentPane, "Debe elegir un Concurso");
