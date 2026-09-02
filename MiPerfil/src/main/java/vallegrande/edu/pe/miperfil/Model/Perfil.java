package vallegrande.edu.pe.miperfil.model;

public class Perfil {

    private String nombreCompleto;
    private String carrera;
    private String semestre;
    private String datoAdicional;

    public Perfil(String nombreCompleto, String carrera,
                  String semestre, String datoAdicional) {

        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        this.semestre = semestre;
        this.datoAdicional = datoAdicional;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getDatoAdicional() {
        return datoAdicional;
    }

    public void mostrarPerfil() {

        System.out.println("===== MI PERFIL =====");
        System.out.println("Nombre completo: " + nombreCompleto);
        System.out.println("Carrera: " + carrera);
        System.out.println("Semestre: " + semestre);
        System.out.println("Dato adicional: " + datoAdicional);
    }
}