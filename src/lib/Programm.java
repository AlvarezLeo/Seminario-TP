package lib;

import clases.*;

import java.util.Scanner;

public class Programm {
    public void executeBlock() {
        int option;
        Menu menu = new Menu();
        option = menu.createMenu();
        if(option < 1 || option > 9) {
            throw (new IllegalArgumentException("Invalid option"));
        }
        while (option < 10) {
            switch (option) {
                case 1:
                    nuevaCancha();
                    break;
                case 2:
                    mostrarCanchas();
                    break;
                case 3:
                    nuevoTurno();
                    break;
                case 4:
                    mostrarTurnos();
                    break;
                case 5:
                    nuevoJugador();
                    break;
                case 6:
                    mostrarJugadores();
                    break;
                case 7:
                    nuevoTorneo();
                    break;
                case 8:
                    mostrarTorneos();
                    break;
                case 9:
                    System.exit(0);
                default:
                    break;
            }
            option = menu.createMenu();
            if(option < 1 || option > 9) {
                throw (new IllegalArgumentException("Invalid option"));
            }
        }
    }

    public void nuevaCancha() {
        System.out.println("Nueva Cancha");
        int canchaId;
        String tipoCancha;
        String nombreCancha;
        String techadaInd;
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
        GlobalVars.arrayCanchas[GlobalVars.cantCanchas] = newCancha;;
        GlobalVars.cantCanchas++;
    }

    public void mostrarCanchas() {
        System.out.println("Canchas:");
        System.out.println("Num|Tipo|Nombre|Techada");
        System.out.println("-----------------------");
        for (int i = 0; i < GlobalVars.cantCanchas; i++) {
            System.out.println(GlobalVars.arrayCanchas[i].getCanchaId()
                    + "|" +  GlobalVars.arrayCanchas[i].getTipoCancha()
                    + "|" + GlobalVars.arrayCanchas[i].getNombreCancha()
                    + "|" + GlobalVars.arrayCanchas[i].getTechadaInd()
            );
        }
        System.out.println("-----------------------");
    }

    public void nuevoTurno() {
        System.out.println("Nuevo Turno");
        String fecha;
        String hora;
        int canchaId;
        String nombre;
        String apellido;
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
        GlobalVars.arrayTurnos[GlobalVars.cantTurnos] = newTurno;
        GlobalVars.cantTurnos++;
    }

    public void mostrarTurnos() {
        System.out.println("Turnos:");
        System.out.println("Fecha|Hora|Cancha|Nombre|Apellido");
        System.out.println("---------------------------------");
        for (int i = 0; i < GlobalVars.cantTurnos; i++) {
            System.out.println(GlobalVars.arrayTurnos[i].getFecha()
                    + "|" + GlobalVars.arrayTurnos[i].getHora()
                    + "|" + GlobalVars.arrayTurnos[i].getCanchaId()
                    + "|" + GlobalVars.arrayTurnos[i].getNombre()
                    + " " + GlobalVars.arrayTurnos[i].getApellido()
            );
        }
        System.out.println("---------------------------------");
    }

    public void nuevoJugador() {
        System.out.println("Nuevo Jugador");
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
        GlobalVars.arrayJugadores[GlobalVars.cantJugadores] = newJugador;;
        GlobalVars.cantJugadores++;
    }

    public void mostrarJugadores() {
        System.out.println("Jugadores:");
        System.out.println("Documento|Nombre|Apellido|Categoria");
        System.out.println("-----------------------------------");
        for (int i = 0; i < GlobalVars.cantJugadores; i++) {
            System.out.println(GlobalVars.arrayJugadores[i].getDocumentoId()
                    + "|" + GlobalVars.arrayJugadores[i].getNombre()
                    + "|" + GlobalVars.arrayJugadores[i].getApellido()
                    + "|" + GlobalVars.arrayJugadores[i].getCategoriaId()
            );
        }
        System.out.println("-----------------------------------");
    }

    public void nuevoTorneo(){
        System.out.println("Nuevo Torneo");
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
        GlobalVars.arrayTorneos[GlobalVars.cantTorneos] = newTorneo;;
        GlobalVars.cantTorneos++;
    }

    public void mostrarTorneos() {
        System.out.println("Torneos:");
        System.out.println("Torneo|Fecha|Categoria");
        System.out.println("----------------------");
        for (int i = 0; i < GlobalVars.cantTorneos; i++) {
            System.out.println(GlobalVars.arrayTorneos[i].getFecha()
                    + "|" + GlobalVars.arrayTorneos[i].getFecha()
                    + "|" + GlobalVars.arrayTorneos[i].getCategoriaId()
            );
        }
        System.out.println("-----------------------------------");
    }
}
