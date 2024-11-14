package clases;

import java.sql.*;

public class Torneo {
    private int torneoId;
    private String fecha;
    private int categoriaId;

    public Torneo(int torneoId, String fecha, int categoriaId) {
        this.torneoId = torneoId;
        this.fecha = fecha;
        this.categoriaId = categoriaId;
    }

    public Torneo(int torneoId) {
        this.torneoId = torneoId;
    }

    public Torneo(){

    }

    public int getTorneoId() {
        return torneoId;
    }

    public void setTorneoId(int torneoId) {
        this.torneoId = torneoId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void insertTorneo(Connection conn) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updRows;
        preparedStatement = conn.prepareStatement("UPDATE SeminarioS21.Torneos SET " +
                "fecha = ? " +
                ",categoriaId = ? " +
                "WHERE " +
                "torneoId = ?");

        preparedStatement.setString(1,fecha);
        preparedStatement.setInt(2,categoriaId);
        preparedStatement.setInt(3,torneoId);
        updRows = preparedStatement.executeUpdate();

        if(updRows == 0) {
            preparedStatement = conn.prepareStatement("INSERT INTO SeminarioS21.Torneos VALUES (?,?,?)");
            preparedStatement.setInt(1, torneoId);
            preparedStatement.setString(2, fecha);
            preparedStatement.setInt(3, categoriaId);
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado con exito.");
        }
        else {
            System.out.println("Registro actualizado con exito.");
        }
    }

    public void borrarTorneo(Connection conn) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement = conn.prepareStatement("DELETE FROM  seminarioS21.Torneos WHERE torneoId = ?");
        preparedStatement.setInt(1, torneoId);
        preparedStatement.executeUpdate();
        System.out.println("Registro borrado con exito.");
    }

    public void mostrarTorneos(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = null;
        System.out.println("Torneos:");
        System.out.println("Torneo|Fecha|Categoria");
        System.out.println("----------------------");
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from SeminarioS21.Torneos order by fecha;");
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("torneoId")
                    + "|" +  resultSet.getString("fecha")
                    + "|" + resultSet.getString("categoriaId"));
        }
        System.out.println("-----------------------------------");
    }

}
