package clases;

import java.sql.*;
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

    public Turno (String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public Turno () {

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

    public void insertTurno (Connection conn) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updRows;
        preparedStatement = conn.prepareStatement("UPDATE SeminarioS21.Turnos SET canchaId = ?, " +
                "nombre = ?," +
                "apellido = ? " +
                "WHERE " +
                "fecha = ? " +
                "AND hora = ? ");
        preparedStatement.setInt(1,this.canchaId);
        preparedStatement.setString(2,this.nombre);
        preparedStatement.setString(3,this.apellido);
        preparedStatement.setString(4,this.fecha);
        preparedStatement.setString(5,this.hora);
        updRows =  preparedStatement.executeUpdate();

        if(updRows == 0) {
            preparedStatement = conn.prepareStatement("INSERT INTO SeminarioS21.Turnos VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, this.fecha);
            preparedStatement.setString(2, this.hora);
            preparedStatement.setInt(3, this.canchaId);
            preparedStatement.setString(4, this.nombre);
            preparedStatement.setString(5, this.apellido);
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado con exito.");
        }
        else {
            System.out.println("Registro actualizado con exito.");
        }
    }

    public void borrarTurno(Connection conn) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement = conn.prepareStatement("DELETE FROM  seminarioS21.Turnos WHERE fecha = ? AND hora = ?");
        preparedStatement.setString(1, this.fecha);
        preparedStatement.setString(2, this.hora);
        preparedStatement.executeUpdate();
        System.out.println("Registro borrado con exito.");
    }

    public void mostrarTurnos(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = null;
        System.out.println("Turnos:");
        System.out.println("Fecha|Hora|Cancha|Nombre|Apellido");
        System.out.println("---------------------------------");
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select \n" +
                "\tcast(fecha as char(10)) as fecha,\n" +
                "    cast(hora as char(10)) as hora,\n" +
                "    canchaId,\n" +
                "    nombre,\n" +
                "    apellido\n" +
                "from seminarioS21.Turnos " +
                "order by fecha, hora;");
        while(resultSet.next()) {
            System.out.println(resultSet.getString("fecha")
                    + "|" +  resultSet.getString("hora")
                    + "|" + resultSet.getString("canchaId")
                    + "|" + resultSet.getString("nombre")
                    + "|" + resultSet.getString("apellido"));
        }
        System.out.println("---------------------------------");
    }
}
