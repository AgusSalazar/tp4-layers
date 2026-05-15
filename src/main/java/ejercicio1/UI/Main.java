package ejercicio1.UI;
import ejercicio1.persistencia.*;
import java.awt.*;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    var registro = new RegistroParticipanteJDBC();
                    new Ventana(registro);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}

