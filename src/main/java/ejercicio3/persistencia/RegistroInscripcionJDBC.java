package ejercicio3.persistencia;

import ejercicio3.modelo.RegistroConcursos;
import ejercicio3.modelo.RegistroInscripciones;
import ejercicio3.modelo.Persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegistroInscripcionJDBC implements RegistroInscripciones{
    private String url = "jdbc:mysql://localhost:3306/concursos";
    private String user = "root";
    private String password = "teconlimon8";

    // apellido, nombre, teléfono, email, idconcurso
    @Override
    public void saveInscription(Persona p){
        String sql = "INSERT INTO inscriptos (apellido, nombre, telefono, email, id_concurso) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.apellido());
            ps.setString(2, p.nombre());
            ps.setString(3, p.telefono());
            ps.setString(4, p.email());

            ps.setInt(5, p.idConcurso() + 1);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar en BD", e);
        }
    }
}
