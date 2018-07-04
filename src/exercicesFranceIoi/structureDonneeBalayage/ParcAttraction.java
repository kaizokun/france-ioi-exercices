package exercicesFranceIoi.structureDonneeBalayage;

import java.util.Scanner;

/**
 * Created by monsio on 1/27/16.
 */
public class ParcAttraction {


    private static Scanner scan = new Scanner(System.in);
    private static int[] chiffresCumule;
    private static int totalDates;


    public static void lireChiffresParDate(){

        int[] chiffres = new int[]{77, 60, 67, 67, 63, 100, 68, 55, 98, 66};

        totalDates = chiffres.length;

        chiffresCumule = new int[totalDates+1];

        chiffresCumule[0] = 0;

        for( int i = 1 ; i <= totalDates ; i ++ ){
            int ch = chiffres[i-1];// scan.nextInt();
            chiffresCumule[i] = chiffresCumule[i-1] + ch;
        }

    }

    public static void nombreVisiteurPeriode( ){


        int d1 = scan.nextInt(), d2 = scan.nextInt();

        while(d1 > 0 && d2 <= totalDates) {

            System.out.println("nombre de visiteurs entre "+d1+" et "+d2+" : "+(chiffresCumule[d2] - chiffresCumule[d1 - 1]));
            d1 = scan.nextInt();
            d2 = scan.nextInt();
        }

    }


    public static void main(String[] args) {

        //totalDates = scan.nextInt();

        lireChiffresParDate();

        nombreVisiteurPeriode();
    }

}
