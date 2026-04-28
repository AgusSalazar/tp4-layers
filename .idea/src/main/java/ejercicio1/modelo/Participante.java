package ejercicio1.modelo;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region) {
        validarNombre(nombre);
        validarRegion(region);
        validarTelefono(telefono);
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private void validarRegion(String region) {
        if(!region.equals("China") && !region.equals("US") && ! region.equals("Europa")) {
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        }
    }

    public void validarNombre(String nombre) {
        if (nombre.equals("")) {
            throw new RuntimeException("Debe cargar un nombre");
        }
    }

    private void validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        if (telefono.equals("")) {
            throw new RuntimeException("Debe cargar un telefono");
        }
        if (!telefono.matches(regex)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
    }

    public String nombre() {
        return nombre;
    }

    public String telefono() {
        return telefono;
    }

    public String region() {
        return region;
    }
}
