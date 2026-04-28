package ejercicio1.persistencia;

import ejercicio1.modelo.Registro;
import ejercicio1.modelo.Participante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroParticipanteJDBC implements Registro{
    String url = "jdbc:mysql://localhost:3306/participantes";
    String user = "root";
    String password = "teconlimon8";
    private Connection dbConn;

    public RegistroParticipanteJDBC() throws SQLException {
        this.dbConn = DriverManager.getConnection(url, user, password);
    }

    @Override
    public void guardar(Participante p){
        try {
            PreparedStatement st = dbConn.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");
            try {
                st.setString(1, p.nombre());
                st.setString(2, p.telefono());
                st.setString(3, p.region());
                st.executeUpdate();
            } finally {
                st.close();
            }
        }catch(SQLException e){
            throw new RuntimeException("No se ha podido guardar el participante");
        }

    }
}
