package clases;

import java.sql.*;
import java.util.Scanner;

public class Cancha {
    private int canchaId;
    private String tipoCancha;
    private String nombreCancha;
    private String techadaInd;

    public Cancha(int canchaId, String tipoCancha, String nombreCancha, String techadaInd) {
        this.canchaId = canchaId;
        this.tipoCancha = tipoCancha;
        this.nombreCancha = nombreCancha;
        this.techadaInd = techadaInd;
    }

    public Cancha (int canchaId) {
        this.canchaId = canchaId;
    }

    public Cancha(){

    }

    public int getCanchaId() {
        return canchaId;
    }

    public String getTipoCancha() {
        return tipoCancha;
    }

    public String getNombreCancha() {
        return nombreCancha;
    }

    public String getTechadaInd() {
        return techadaInd;
    }

    public void setCanchaId(int canchaId) {
        this.canchaId = canchaId;
    }

    public void setTipoCancha(String tipoCancha) {
        this.tipoCancha = tipoCancha;
    }

    public void setNombreCancha(String nombreCancha) {
        this.nombreCancha = nombreCancha;
    }

    public void setTechadaInd(String techadaInd) {
        this.techadaInd = techadaInd;
    }

    public void insertCancha(Connection conn) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updRows;
        preparedStatement = conn.prepareStatement("UPDATE seminarioS21.Canchas SET tipoCancha = ? " +
                ",nombreCancha = ? " +
                ",techadaInd = ? " +
                "WHERE " +
                "canchaId = ?");
        preparedStatement.setString(1, this.tipoCancha);
        preparedStatement.setString(2, this.nombreCancha);
        preparedStatement.setString(3, this.techadaInd);
        preparedStatement.setInt(4, this.canchaId);
        updRows = preparedStatement.executeUpdate();
        if(updRows == 0) {
            preparedStatement = conn.prepareStatement("insert into seminarioS21.Canchas VALUES (?,?,?,?)");
            preparedStatement.setInt(1, this.canchaId);
            preparedStatement.setString(2, this.tipoCancha);
            preparedStatement.setString(3, this.nombreCancha);
            preparedStatement.setString(4, this.techadaInd);
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado con exito.");
        }
        else {
            System.out.println("Registro actualizado con exito.");
        }
    }

    public void borrarCancha(Connection conn) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement = conn.prepareStatement("DELETE FROM  seminarioS21.Canchas WHERE canchaId = ?");
        preparedStatement.setInt(1, this.canchaId);
        preparedStatement.executeUpdate();
        System.out.println("Registro borrado con exito.");
    }

    public void mostrarCanchas(Connection conn) throws SQLException {
        ResultSet resultSet = null;
        Statement statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from seminarioS21.Canchas order by canchaId");
        System.out.println("Canchas:");
        System.out.println("Num|Tipo|Nombre|Techada");
        System.out.println("-----------------------");
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("CanchaId")
                    + "|" +  resultSet.getString("TipoCancha")
                    + "|" + resultSet.getString("NombreCancha")
                    + "|" + resultSet.getString("TechadaInd"));
        }
        System.out.println("-----------------------");
    }
}
