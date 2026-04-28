package ejercicio3.UI;

import ejercicio3.modelo.*;
import ejercicio3.modelo.Concurso;
import ejercicio3.persistencia.ArchivoRegistroConcursos;
import ejercicio3.persistencia.ArchivoRegistroInscripciones;

import javax.swing.SwingUtilities;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public List<Concurso> inicializarConcursos(){
        List<Concurso> concursosIniciales;
        var c1 = new Concurso("Concurso de metal", LocalDate.of(2026, 3, 31), LocalDate.of(2026, 5, 10));
        var c2 = new Concurso("Concurso de freestyle", LocalDate.of(2026, 5, 5), LocalDate.of(2026, 5, 20));
        var c3 = new Concurso("Concurso de ajedrez", LocalDate.of(2026, 3, 30), LocalDate.of(2026, 5, 28));

        return concursosIniciales = List.of(c1, c2, c3);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
// log exception...
                    System.out.println(e);
                }
            }
        });
    }

    private void start() {
        ArchivoRegistroConcursos regConcursos = new ArchivoRegistroConcursos("Concursos.txt");
        ArchivoRegistroInscripciones regInscriptos = new ArchivoRegistroInscripciones("Inscriptos.txt");
        regConcursos.inicializarArchivoConcursos(inicializarConcursos());

        new RadioCompetition(regConcursos, regInscriptos);
    }
}
