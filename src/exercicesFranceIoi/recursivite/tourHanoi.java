package exercicesFranceIoi.recursivite;

import java.util.Scanner;

/**
 * Created by monsio on 1/20/16.
 */
public class tourHanoi {


    private static int cptr = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int taille = scan.nextInt();

        tourHanoi(0,2,taille);

    }

    public static void tourHanoi(int depart, int deplacement, int taille) {

        if( taille == 1 ){
            System.out.println((cptr++)+" : "+(depart+1)+" > "+(((depart+deplacement)%3)+1));
            return;
        }

        int newDep = deplacement%2 + 1;

        tourHanoi(depart,newDep,taille-1);
        tourHanoi(depart,deplacement,1);
        tourHanoi((depart+newDep)%3,newDep,taille-1);

    }



}
