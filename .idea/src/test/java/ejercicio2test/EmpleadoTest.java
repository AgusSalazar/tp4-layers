package ejercicio2test;

import ejercicio2.modelo.Empleado;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Se deben incluir test de unidad del modelo (la cantidad que el alumno considere
//necesario), verificar cobertura (superior a 60%).

public class EmpleadoTest {
    @Test
    public void testEmpleadoSinNombre(){
        assertThrows(RuntimeException.class, () -> {
            var E1= new Empleado("Young", " ", LocalDate.of(1955, 3, 31), "angus@acdc.com");
        });
    }

    @Test
    public void testEmpleadoSinApellido(){
        assertThrows(RuntimeException.class, () -> {
            var E1= new Empleado("", "Angus", LocalDate.of(1955, 3, 31), "angus@acdc.com");
        });
    }

    @Test
    public void testEmpleadoConFechaNacimientoInvalida(){
        assertThrows(RuntimeException.class, () -> {
            var E1= new Empleado("Young", "Angus", LocalDate.now().plusYears(1), "angus@acdc.com");
        });
    }

    @Test
    public void testEmpleadoSinEmail(){
        assertThrows(RuntimeException.class, () -> {
            var E1= new Empleado("Angus", LocalDate.of(1955, 3, 31), null);
        });
    }

    @Test
    public void testEmpleadoQueCumpleHoy(){
        var E1= new Empleado("Angus", LocalDate.now(), "angus@acdc.com");

        assertTrue(E1.cumploHoy());
    }

}
