package vallegrande.edu.pe.hotelsys.model;

public class Reserva {

    private String cliente;
    private String habitacion;

    public Reserva() {
    }

    public Reserva(String cliente, String habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }
}