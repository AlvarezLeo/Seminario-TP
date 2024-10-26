package clases;

import java.util.Date;

public class Turno {
    private String fecha;
    private String hora;
    private int canchaId;
    private String nombre;
    private String apellido;

    public Turno(String fecha, String hora, int canchaId, String nombre, String apellido) {
        this.fecha = fecha;
        this.hora = hora;
        this.canchaId = canchaId;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getCanchaId() {
        return canchaId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setCanchaId(int canchaId) {
        this.canchaId = canchaId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
