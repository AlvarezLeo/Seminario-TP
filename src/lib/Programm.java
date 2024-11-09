package lib;

import clases.*;

import java.sql.*;
import java.util.Scanner;
import lib.Programm;
import lib.Connect;

public class Programm {
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public void executeBlock() throws ClassNotFoundException, SQLException {
        int option;
        System.out.println("Conectando a la base de datos...");
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "Leoa33879671";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Conexion realizada con exito.");
        Menu menu = new Menu();
        option = menu.createMenu();
        if(option < 1 || option > 14) {
            throw (new IllegalArgumentException("Invalid option"));
        }
        while (option < 14) {
            switch (option) {
                case 1:
                    nuevaCancha(connection);
                    break;
                case 2:
                    borrarCancha(connection);
                    break;
                case 3:
                    mostrarCanchas(connection);
                    break;
                case 4:
                    nuevoTurno(connection);
                    break;
                case 5:
                    borrarTurno(connection);
                    break;
                case 6:
                    mostrarTurnos(connection);
                    break;
                case 7:
                    nuevoJugador(connection);
                    break;
                case 8:
                    borrarJugador(connection);
                    break;
                case 9:
                    mostrarJugadores(connection);
                    break;
                case 10:
                    nuevoTorneo(connection);
                    break;
                case 11:
                    borrarTorneo(connection);
                    break;
                case 12:
                    mostrarTorneos(connection);
                    break;
                case 13:
                    System.exit(0);
                default:
                    break;
            }
            option = menu.createMenu();
            if(option < 1 || option > 14) {
                throw (new IllegalArgumentException("Invalid option"));
            }
        }
    }

    public void nuevaCancha(Connection conn) throws SQLException {
        System.out.println("Nueva Cancha");
        //PreparedStatement preparedStatement = null;
        //Statement statement = null;
        int canchaId;
        String tipoCancha;
        String nombreCancha;
        String techadaInd;
        int updRows;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Numero de Cancha:");
        canchaId = input.nextInt();
        input.nextLine();
        System.out.println("Ingrese Tipo de Cancha:");
        tipoCancha = input.nextLine();
        System.out.println("Ingrese el Nombre de la Cancha:");
        nombreCancha = input.nextLine();
        System.out.println("Ingrese el indicador de Techada:");
        techadaInd = input.nextLine();
        preparedStatement = conn.prepareStatement("UPDATE seminarioS21.Canchas SET tipoCancha = ? " +
                ",nombreCancha = ? " +
                ",techadaInd = ? " +
                "WHERE " +
                "canchaId = ?");
        preparedStatement.setString(1, tipoCancha);
        preparedStatement.setString(2, nombreCancha);
        preparedStatement.setString(3, techadaInd);
        preparedStatement.setInt(4, canchaId);
        updRows = preparedStatement.executeUpdate();
        if(updRows == 0) {
            preparedStatement = conn.prepareStatement("insert into seminarioS21.Canchas VALUES (?,?,?,?)");
            preparedStatement.setInt(1, canchaId);
            preparedStatement.setString(2, tipoCancha);
            preparedStatement.setString(3, nombreCancha);
            preparedStatement.setString(4, techadaInd);
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado con exito.");
        }
        else {
            System.out.println("Registro actualizado con exito.");
        }

        //Cancha newCancha = new Cancha(canchaId, tipoCancha, nombreCancha, techadaInd);
        //GlobalVars.arrayCanchas[GlobalVars.cantCanchas] = newCancha;;
        //GlobalVars.cantCanchas++;
    }

    public void borrarCancha(Connection conn) throws SQLException {
        System.out.println("Nueva Cancha");
        //PreparedStatement preparedStatement = null;
        //Statement statement = null;
        int canchaId;
        //int updRows;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Numero de Cancha:");
        canchaId = input.nextInt();
        input.nextLine();
        preparedStatement = conn.prepareStatement("DELETE FROM  seminarioS21.Canchas WHERE canchaId = ?");
        preparedStatement.setInt(1, canchaId);
        preparedStatement.executeUpdate();
        System.out.println("Registro borrado con exito.");
    }

    public void mostrarCanchas(Connection conn) throws SQLException {
        statement = conn.createStatement();
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

    public void nuevoTurno(Connection conn) throws SQLException {
        System.out.println("Nuevo Turno");
        String fecha;
        String hora;
        int canchaId;
        String nombre;
        String apellido;
        int updRows;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Fecha");
        fecha = input.nextLine();
        System.out.println("Ingrese Hora");
        hora = input.nextLine();
        System.out.println("Ingrese Numero de Cancha");
        canchaId = input.nextInt();
        input.nextLine();
        System.out.println("Ingrese Nombre del Cliente");
        nombre = input.nextLine();
        System.out.println("Ingrese Apellido del Cliente");
        apellido = input.nextLine();
        preparedStatement = conn.prepareStatement("UPDATE SeminarioS21.Turnos SET canchaId = ?, " +
                "nombre = ?," +
                "apellido = ? " +
                "WHERE " +
                "fecha = ? " +
                "AND hora = ? ");
        preparedStatement.setInt(1,canchaId);
        preparedStatement.setString(2,nombre);
        preparedStatement.setString(3,apellido);
        preparedStatement.setString(4,fecha);
        preparedStatement.setString(5,hora);
        updRows =  preparedStatement.executeUpdate();

        if(updRows == 0) {
            preparedStatement = conn.prepareStatement("INSERT INTO SeminarioS21.Turnos VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, fecha);
            preparedStatement.setString(2, hora);
            preparedStatement.setInt(3, canchaId);
            preparedStatement.setString(4, nombre);
            preparedStatement.setString(5, apellido);
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado con exito.");
        }
        else {
            System.out.println("Registro actualizado con exito.");
        }
        //Turno newTurno = new Turno(fecha, hora, canchaId, nombre, apellido);
        //GlobalVars.arrayTurnos[GlobalVars.cantTurnos] = newTurno;
        //GlobalVars.cantTurnos++;
    }

    public void borrarTurno(Connection conn) throws SQLException {
        System.out.println("Borrar Turno");
        //PreparedStatement preparedStatement = null;
        //Statement statement = null;
        String fecha;
        String hora;
        //int updRows;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Fecha");
        fecha = input.nextLine();
        System.out.println("Ingrese Hora");
        hora = input.nextLine();
        preparedStatement = conn.prepareStatement("DELETE FROM  seminarioS21.Turnos WHERE fecha = ? AND hora = ?");
        preparedStatement.setString(1, fecha);
        preparedStatement.setString(2, hora);
        preparedStatement.executeUpdate();
        System.out.println("Registro borrado con exito.");
    }

    public void mostrarTurnos(Connection conn) throws SQLException {
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

    public void nuevoJugador(Connection conn) throws SQLException {
        System.out.println("Nuevo Jugador");
        int updRows;
        int documentoId;
        String nombre;
        String apellido;
        int categoriaId;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Documento:");
        documentoId = input.nextInt();
        input.nextLine();
        System.out.println("Ingrese Nombre:");
        nombre = input.nextLine();
        System.out.println("Ingrese Apellido:");
        apellido = input.nextLine();
        System.out.println("Ingrese Categoria:");
        categoriaId = input.nextInt();
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
        //Jugador newJugador = new Jugador(documentoId, nombre, apellido, categoriaId);
        //GlobalVars.arrayJugadores[GlobalVars.cantJugadores] = newJugador;;
        //GlobalVars.cantJugadores++;
    }

    public void borrarJugador(Connection conn) throws SQLException {
        System.out.println("Borrar Jugador");
        //PreparedStatement preparedStatement = null;
        //Statement statement = null;
        int documentoId;
        //int updRows;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Documento:");
        documentoId = input.nextInt();
        preparedStatement = conn.prepareStatement("DELETE FROM  seminarioS21.Jugadores WHERE documentoId = ?");
        preparedStatement.setInt(1, documentoId);
        preparedStatement.executeUpdate();
        System.out.println("Registro borrado con exito.");
    }

    public void mostrarJugadores(Connection conn) throws SQLException {
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

    public void nuevoTorneo(Connection conn) throws SQLException {
        System.out.println("Nuevo Torneo");
        int updRows;
        int torneoId;
        String fecha;
        int categoriaId;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Numero de Torneo:");
        torneoId = input.nextInt();
        input.nextLine();
        System.out.println("Ingrese Fecha:");
        fecha = input.nextLine();
        System.out.println("Ingrese Categoria:");
        categoriaId = input.nextInt();
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
        //Torneo newTorneo = new Torneo(torneoId, fecha, categoriaId);
        //GlobalVars.arrayTorneos[GlobalVars.cantTorneos] = newTorneo;;
        //GlobalVars.cantTorneos++;
    }

    public void borrarTorneo(Connection conn) throws SQLException {
        System.out.println("Borrar Torneo");
        //PreparedStatement preparedStatement = null;
        //Statement statement = null;
        int torneoId;
        //int updRows;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese Numero de Torneo:");
        torneoId = input.nextInt();
        preparedStatement = conn.prepareStatement("DELETE FROM  seminarioS21.Torneos WHERE torneoId = ?");
        preparedStatement.setInt(1, torneoId);
        preparedStatement.executeUpdate();
        System.out.println("Registro borrado con exito.");
    }

    public void mostrarTorneos(Connection conn) throws SQLException {
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
