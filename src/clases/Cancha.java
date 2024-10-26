package clases;

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
}