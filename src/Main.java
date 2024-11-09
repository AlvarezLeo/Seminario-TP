//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import lib.Programm;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        try {
            System.out.println("-------------------------------");
            System.out.println("   Gestion de Club de Padel   ");
            System.out.println("-------------------------------");
            Programm program = new Programm();
            program.executeBlock();
        }
        catch (Exception e) {
            //System.out.println("Hubo un error en la ejecucion del programa");
            System.out.println("Error:" + e.toString());
            //System.out.println(e.toString());
        }
        finally {
            main(null);
        }
    }
}