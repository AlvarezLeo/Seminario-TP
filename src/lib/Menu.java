package lib;

import java.util.Scanner;

public class Menu {
    public int createMenu(){
        int selection;
        int menuInd;
        Scanner input = new Scanner(System.in);
        System.out.println("Si desea ver el menu ingrese 1");
        menuInd = input.nextInt();
        if(menuInd == 1) {

            /***************************************************/

            System.out.println("Por favor selecciona una opcion");
            System.out.println("-------------------------------");
            System.out.println("1 - Agregar Cancha");
            System.out.println("2 - Borrar Cancha");
            System.out.println("3 - Mostrar Cancas");
            System.out.println("4 - Agregar Turno");
            System.out.println("5 - Borrar Turno");
            System.out.println("6 - Mostrar Turnos");
            System.out.println("7 - Agregar Jugador");
            System.out.println("8 - Borrar Jugador");
            System.out.println("9 - Mostrar Jugadores");
            System.out.println("10 - Nuevo Torneo");
            System.out.println("11 - Borrar Torneo");
            System.out.println("12 - Mostrar Torneos");
            System.out.println("13 - Quit");

            selection = input.nextInt();
            return selection;
        }
        else {
            System.exit(0);
            return 0;
        }
    }
}
