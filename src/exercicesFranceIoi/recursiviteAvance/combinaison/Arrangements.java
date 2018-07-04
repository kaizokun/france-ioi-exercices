package exercicesFranceIoi.recursiviteAvance.combinaison;

import java.util.Scanner;

/**
 * Created by monsio on 2/12/16.
 */
public class Arrangements {

    /**
     * Afficher les applications injectives de l'ensemble N [1 - longeur] sur L l'ensemble des lettres
     * On associe à chaque indice une lettre sans repiochage possible
     * taille : fact(|N|) / fact(|N|-|L|)
     * */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String lettres = "12345";//sc.nextLine();
        int longeur = 3;// sc.nextInt();

       // int totalArrangements = factorielle(lettres.length()) / factorielle(lettres.length() - longeur);

        int totalArrangements = nbArrangements(lettres.length(),longeur);

        String arrangements[] = new String[totalArrangements];

        StringBuffer mot = new StringBuffer();

        boolean lettreDisponible[] = new boolean[lettres.length()];

        for (int l = 0 ; l < lettres.length() ; l ++ )
            lettreDisponible[l] = true;

        mot.setLength(longeur);

        applications(longeur, lettres, arrangements, 0, mot, 0,lettreDisponible);

        for (String app : arrangements)
        {
            System.out.println(app);
        }

    }

    private static int applications(int longeur, String lettres, String[] arrangements, int iMot, StringBuffer mot, int pos, boolean[] lettreDisponible) {

        if( longeur == 0 ) {
            //System.out.println(mot);
            arrangements[iMot] = new String(mot);
            return iMot + 1;
        }

        for( int l = 0 ; l < lettres.length() ; l ++ ){

            char lettre = lettres.charAt(l);

            if(lettreDisponible[ l ]) {
                mot.setCharAt(pos, lettre);
                lettreDisponible[l] = false;
                iMot = applications(longeur - 1, lettres, arrangements, iMot, mot, pos + 1, lettreDisponible);
                lettreDisponible[ l ] = true;
            }


        }

        return iMot;

    }

    private static int factorielle(int n){
        if( n == 0 )
            return 1;
        return n * factorielle(n-1);
    }

    static int nbArrangements(int n, int p)
    {
        if (p == 1)
            return n;
        return n * nbArrangements(n-1,p-1);
    }

}
