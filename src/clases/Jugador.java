package clases;

import java.sql.*;

public class Jugador {
    private int documentoId;
    private String nombre;
    private String apellido;
    private int categoriaId;

    public Jugador(int documentoId, String nombre, String apellido, int categoriaId) {
        this.documentoId = documentoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoriaId = categoriaId;
    }

    public Jugador(int documentoId) {
        this.documentoId = documentoId;
    }

    public Jugador(){

    }

    public int getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(int documentoId) {
        this.documentoId = documentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void insertJugador (Connection conn) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updRows;
        preparedStatement = conn.prepareStatement("UPDATE SeminarioS21.Jugadores SET " +
                "nombre = ? " +
                ",apellido = ? " +
                ",categoriaId = ? " +
                "WHERE " +
                "documentoId = ?");

        preparedStatement.setString(1,nombre);
        preparedStatement.setString(2,apellido);
        preparedStatement.setInt(3,categoriaId);
        preparedStatement.setInt(4,documentoId);
        updRows = preparedStatement.executeUpdate();

        if(updRows == 0) {
            preparedStatement = conn.prepareStatement("INSERT INTO SeminarioS21.Jugadores VALUES (?,?,?,?)");
            preparedStatement.setInt(1, documentoId);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setInt(4, categoriaId);
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado con exito.");
        }
        else {
            System.out.println("Registro actualizado con exito.");
        }
    }

    public void borrarJugador(Connection conn) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement = conn.prepareStatement("DELETE FROM  seminarioS21.Jugadores WHERE documentoId = ?");
        preparedStatement.setInt(1, documentoId);
        preparedStatement.executeUpdate();
        System.out.println("Registro borrado con exito.");
    }

    public void mostrarJugadores(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = null;
        System.out.println("Jugadores:");
        System.out.println("Documento|Nombre|Apellido|Categoria");
        System.out.println("-----------------------------------");
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from SeminarioS21.Jugadores");
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("documentoId")
                    + "|" +  resultSet.getString("nombre")
                    + "|" + resultSet.getString("apellido")
                    + "|" + resultSet.getInt("categoriaId"));
        }
        System.out.println("-----------------------------------");
    }
}
