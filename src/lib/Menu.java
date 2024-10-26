package lib;

import java.util.Scanner;

public class Menu {
    public int createMenu(){
        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("Por favor selecciona una opcion");
        System.out.println("-------------------------------");
        System.out.println("1 - Agregar Cancha");
        System.out.println("2 - Mostrar Cancas");
        System.out.println("3 - Agregar Turno");
        System.out.println("4 - Mostrar Turnos");
        System.out.println("5 - Agregar Jugador");
        System.out.println("6 - Mostrar Jugadores");
        System.out.println("7 - Nuevo Torneo");
        System.out.println("8 - Mostrar Torneos");
        System.out.println("9 - Quit");

        selection = input.nextInt();
        return selection;
    }
}
