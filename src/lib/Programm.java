package lib;

import clases.*;

import java.sql.*;
import java.util.Scanner;

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
        Cancha newCancha = new Cancha(canchaId, tipoCancha, nombreCancha, techadaInd);
        newCancha.insertCancha(conn);
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
        Cancha newCancha = new Cancha(canchaId);
        newCancha.borrarCancha(conn);
    }

    public void mostrarCanchas(Connection conn) throws SQLException {
        Cancha newCancha = new Cancha();
        newCancha.mostrarCanchas(conn);
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
        Turno newTurno = new Turno(fecha, hora, canchaId, nombre, apellido);
        newTurno.insertTurno(conn);
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
        Turno newTurno = new Turno(fecha, hora);
        newTurno.borrarTurno(conn);
    }

    public void mostrarTurnos(Connection conn) throws SQLException {
        Turno newTurno = new Turno();
        newTurno.mostrarTurnos(conn);
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
        Jugador newJugador = new Jugador(documentoId, nombre, apellido, categoriaId);
        newJugador.insertJugador(conn);
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
        Jugador newJugador = new Jugador(documentoId);
        newJugador.borrarJugador(conn);
    }

    public void mostrarJugadores(Connection conn) throws SQLException {
        Jugador newJugador = new Jugador();
        newJugador.mostrarJugadores(conn);
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
        Torneo newTorneo = new Torneo(torneoId, fecha, categoriaId);
        newTorneo.insertTorneo(conn);
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
        Torneo newTorneo = new Torneo(torneoId);
        newTorneo.borrarTorneo(conn);
    }

    public void mostrarTorneos(Connection conn) throws SQLException {
        Torneo newTorneo = new Torneo();
        newTorneo.mostrarTorneos(conn);
    }
}
