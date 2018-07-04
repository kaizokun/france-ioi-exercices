package exercicesFranceIoi.structureDonneeBalayage;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by monsio on 2/4/16.
 */
public class AugmenterFrequentation {

    static class Spectacle implements Comparable<Spectacle>{
        int durree,frequentation;

        public Spectacle(int durree, int frequentation) {
            this.durree = durree;
            this.frequentation = frequentation;
        }

        @Override
        public int compareTo(Spectacle o) {
            return durree - o.durree;
        }


    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

       // int totalSpectacles = scan.nextInt();
        int totalSpectacles = 6;

        Spectacle[] spectacles = new Spectacle[totalSpectacles];

        /*
        for( int s = 0 ; s < totalSpectacles ; s ++ ){
            spectacles[s] = new Spectacle(scan.nextInt(),scan.nextInt());
        }
*/
        spectacles[0] = new Spectacle(900,250);
        spectacles[1] = new Spectacle(600,200);
        spectacles[2] = new Spectacle(3600,50);
        spectacles[3] = new Spectacle(800,400);
        spectacles[4] = new Spectacle(7200,20);
        spectacles[5] = new Spectacle(2400,360);

        Arrays.sort(spectacles);

/*
        int somme = 0;
        double maxMoyenne = 0;
        Spectacle limite = null;

        for(int s = 0 ; s < spectacles.length ; s ++){

            somme += spectacles[s].frequentation;

            int moyenne = somme / (s+1);

            if( moyenne >= maxMoyenne ){
                maxMoyenne = moyenne;
                limite = spectacles[s];
            }

        }

        */

        /*Variante en evitant d'utiliser de snombres à virgules
        * plutot que de sauvegarder la moyenne on enregistre la somme et le
        * nombre de frequence cumulé lors d'un maximum.
        * Et on utilise un produit en croix pour la comparaison
        * */

        int somme = 0,
            maxSomme = 0,
            maxFrequence = 1;

        Spectacle limite = null;

        for(int s = 0 ; s < spectacles.length ; s ++){

            somme += spectacles[s].frequentation;
            /*Si la frequentation du spectacle suivant cumulé offre la même moyenne
             c'est le suivant qui doit être pris en compte
             */
            if( somme * maxFrequence >= maxSomme * (s+1) ){
                maxSomme = somme;
                maxFrequence = (s+1);
                limite = spectacles[s];
            }

        }

        System.out.println(limite.durree);

    }
}
