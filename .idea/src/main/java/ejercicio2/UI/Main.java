package ejercicio2.UI;

import ejercicio2.modelo.*;
import ejercicio2.persistencia.*;

import java.time.LocalDate;
/*
Intente invertir las dependencias hacia el modelo, pero no me salio,
Intente inyectar el Notificador por el constructor y usar el metodo notificar(String) dentro del metodo registrar pero no me anduvo.
Luego intente en vez de hacer lo de arriba hacer otro metodo dentro de la clase ArchivoRegistroEmpleado que habra
el archivo y notifique, pero basicamente es lo mismo porque estoy llamando al metodo de esa clase y sigo dependiendo de la persistencia iguual.
 */
public class Main {
    public static void main(String[] args) {
        Notificador notificador = new MailNotificador();
        String registroEmpleados = "Empleados.txt";
        Empleado E1 = new Empleado("Young", "Angus", LocalDate.of(1955, 3, 31), "angus@acdc.com");
        Empleado E2 = new Empleado("Jhonson", "Brian", LocalDate.of(1955, 4, 26), "brian@acdc.com");

        RegistroEmpleado r = new ArchivoRegistroEmpleado(registroEmpleados);
        r.registrar(E1);
        r.registrar(E2);

        notificador.notificar(registroEmpleados);
    }
}
