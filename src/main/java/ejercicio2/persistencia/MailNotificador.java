package ejercicio2.persistencia;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import ejercicio2.modelo.Notificador;
import ejercicio2.modelo.Empleado;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;
import javax.mail.Session;

public class MailNotificador implements Notificador{

    public void notificar(String archivo) {
        Path ruta = Path.of(archivo);
        DateTimeFormatter formatoLectura = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try {
            List<String> lineas = Files.readAllLines(ruta);

            for (String linea : lineas) {
                // Aplicamos trim() a la línea entera de entrada
                String lineaLimpia = linea.trim();

                if (lineaLimpia.isEmpty()) {
                    continue;
                }

                try { // Segundo try interno para no frenar el bucle
                    String[] datos = lineaLimpia.split(",");

                    if (datos.length < 4) {
                        System.out.println("Saltando línea incompleta: " + lineaLimpia);
                        continue;
                    }

                    // Usamos .trim() en cada dato individual por si hay espacios tras las comas
                    Empleado e = new Empleado(
                            datos[0].trim(),
                            datos[1].trim(),
                            LocalDate.parse(datos[2].trim(), formatoLectura),
                            datos[3].trim()
                    );

                    if (e.cumploHoy()) {
                        mailCumpleaños(e.email(), "Feliz cumpleaños " + e.nombre() + " <3!");
                    }
                } catch (Exception ex) {
                    // Si falla UN empleado, imprimimos el error y SEGUIMOS con el próximo
                    System.err.println("Error procesando la línea [" + lineaLimpia + "]: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("No se ha podido leer el archivo");
        }
    }

    public void mailCumpleaños(String to, String mensaje){
                // provide sender's email ID
        String from = "cumpleaños@empleado.com";

        // provide Mailtrap's username
        final String username = "c79f5fb01a9c67";
        final String password = "2c52861d8dc022";

        // provide Mailtrap's host address
        String host = "sandbox.smtp.mailtrap.io";

        // configure Mailtrap's SMTP details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "2525");

        // create the Session object
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


        try {
            // create a MimeMessage object
            Message message = new MimeMessage(session);
            // set From email field
            message.setFrom(new InternetAddress(from));
            // set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // set email subject field
            message.setSubject("¡Notificacion!");
            // set the content of the email message
            message.setText(mensaje);

            // send the email message
            Transport.send(message);

            System.out.println("El mensaje fue enviado!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
