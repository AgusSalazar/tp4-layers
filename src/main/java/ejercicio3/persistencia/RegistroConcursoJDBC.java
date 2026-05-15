package ejercicio3.persistencia;

import ejercicio3.modelo.RegistroConcursos;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class RegistroConcursoJDBC implements RegistroConcursos{
    private String url = "jdbc:mysql://localhost:3306/Concursos";
    private String user = "root";
    private String password = "teconlimon8";

    @Override
    public void todosLosConcursos(JComboBox<String> combo){
        combo.removeAllItems();
        String query = "SELECT nombre FROM concursos WHERE ? BETWEEN fechaInicio AND fechaFin";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                combo.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD:" + e.getMessage());
        }
    }

}
